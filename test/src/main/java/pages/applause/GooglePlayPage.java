package pages.applause;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;
import static test.applause.BaseTest.log;

public class GooglePlayPage extends LoadableComponent<GooglePlayPage> {
	private final WebDriver driver;
	@FindBy(css = "input[placeholder='Search']")
	WebElement searchBoxPlay;
	@FindBy(id = "gbqfb")
	WebElement searchBtn;

	public GooglePlayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// do nothing, we want to load this page through Apps link
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getTitle().contentEquals("Google Play"),
				"Invalid page title: " + driver.getTitle());
		assertTrue(driver.getCurrentUrl().contains("play.google.com/store"),
				"Invalid Google Play url: " + driver.getCurrentUrl());
		assertTrue(searchBoxPlay.isDisplayed(),
				"Search box not visible in Google Play");
	}

	public void typeSearchTerm(String s) {
		log("Typing term in App search box: " + s);
		searchBoxPlay.sendKeys(s);
	}

	public void clickSearch() {
		log("Click Search button");
		searchBtn.click();
	}

	/**
	 * Validates if app is displayed as small card
	 * 
	 * @param title
	 *            - App title as displayed in app card
	 * @return
	 */
	public boolean isAppDisplayed(String title) {
		log("Validating that app is displayed as small card");
		By criteria = By
				.cssSelector("div.card.apps > .card-content > .details > h2 > a[title='"
						+ title + "']");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(criteria));
		return driver.findElement(criteria).isDisplayed();
	}

	/**
	 * Opens app by clicking on it's cover
	 * 
	 * @param title
	 *            - App title as displayed in app card
	 * @return
	 */
	public AppPlayPage openAppByTitle(String title) {
		log("Open app: " + title);
		By criteriaTitle = By
				.cssSelector("div.card.apps > .card-content > .details > h2 > a[title='"
						+ title + "']");
		driver.findElement(criteriaTitle).click();
		return new AppPlayPage(driver, title);
	}
}
