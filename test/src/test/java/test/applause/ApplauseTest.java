package test.applause;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import pages.applause.AppPlayPage;
import pages.applause.GooglePlayPage;
import pages.applause.GoogleSearchPage;

public class ApplauseTest extends BaseTest {

	@Test(timeOut = 30000)
	public void testAppRating() throws InterruptedException {
		GoogleSearchPage searchPage = new GoogleSearchPage(driver).get();
		searchPage.clickAppsIcon();
		GooglePlayPage playPage = searchPage.clickGooglePlayLink().get();
		playPage.typeSearchTerm("Testing");
		playPage.clickSearch();
		assertTrue(playPage.isAppDisplayed("Software Testing Concepts"));
		System.out.println("--------------------------------------------");
		AppPlayPage appPage = playPage.openAppByTitle(
				"Software Testing Concepts").get();
		System.out.println("Rating: " + appPage.getRatingStars() + " stars");
		System.out.println("Review count: " + appPage.getReviewCount());
	}
}
