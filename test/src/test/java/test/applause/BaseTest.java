package test.applause;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	WebDriver driver;

	@BeforeSuite
	public void setupSuite() {
		driver = new FirefoxDriver();
	}

	@AfterSuite
	public void tearDownSuite() {
		driver.quit();
	}

	public static void log(String s) {
		System.out.println(s);
	}
}
