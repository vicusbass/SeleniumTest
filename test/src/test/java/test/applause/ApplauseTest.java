package test.applause;

import org.testng.annotations.Test;

import pages.applause.GoogleSearchPage;

public class ApplauseTest extends BaseTest {

	@Test
	public void testAppRating() throws InterruptedException{
		GoogleSearchPage searchPage=new GoogleSearchPage(driver);
		searchPage.get();
		searchPage.clickAppsIcon();
		searchPage.clickGooglePlayLink();
		Thread.sleep(5000);
	}
}
