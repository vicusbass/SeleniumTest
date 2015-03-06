package pages.applause;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;
import static test.applause.BaseTest.log;

public class GoogleSearchPage extends LoadableComponent<GoogleSearchPage> {

	private final WebDriver driver;
	@FindBy(name="btnK")
	private WebElement searchBtn;
	@FindBy(id = "lst-ib")
	private WebElement searchBox;
	@FindBy(css = "div.gb_5a > a")
	private WebElement appsGridIcon;
	@FindBy(id = "gb78")
	private WebElement googlePlayLink;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("google"));
		assertTrue(searchBtn.isDisplayed());
		assertTrue(searchBox.isDisplayed());
		assertTrue(appsGridIcon.isDisplayed());
	}

	@Override
	protected void load() {
		driver.get("http://google.com");
	}

	public void clickAppsIcon() {
		log("Click on Apps icon");
		appsGridIcon.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(googlePlayLink));
	}

	public void clickGooglePlayLink() {
		log("Click on Google Play icon");
		googlePlayLink.click();
	}
}
