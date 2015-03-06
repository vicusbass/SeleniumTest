package pages.applause;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.*;

public class AppPlayPage extends LoadableComponent<AppPlayPage> {
	@SuppressWarnings("unused")
	private final WebDriver driver;
	private String appTitle;
	@FindBy(css = ".document-title")
	WebElement appTitleInPage;
	@FindBy(css = ".score")
	WebElement scoreDiv;
	@FindBy(css = "div.stars-count")
	WebElement reviewCount;

	public AppPlayPage(WebDriver driver, String appTitle) {
		this.driver = driver;
		this.appTitle = appTitle;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// nothing here, we open it from the main Google Play page
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(appTitleInPage.getText(), appTitle,
				"Invalid app title displayed in page");
		assertTrue(scoreDiv.isDisplayed(), "Rating not displayed");
		assertTrue(reviewCount.isDisplayed(), "Review count not displayed");
	}

	/**
	 * Reads exact rating and aproximates the number of stars on the page: - one
	 * option would be to use the width of stars element - simpler option is to
	 * round the exact rating, but in this case we miss the '3.1 stars'
	 * displayed
	 * 
	 * @return
	 */
	public int getRatingStars() {
		String rating = scoreDiv.getText();
		System.out.println("Exact rating in numbers: " + rating);
		return (int) Math.round(Double.parseDouble(rating));
	}

	/**
	 * Gets review count
	 * 
	 * @return
	 */
	public String getReviewCount() {
		return reviewCount.getText().replace("(", "").replace(")", "");
	}
}
