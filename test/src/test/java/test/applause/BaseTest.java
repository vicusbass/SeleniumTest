package test.applause;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public WebDriver driver;
	String browser = "";

	@BeforeSuite
	public void setupSuite() {
		InputStream file = this.getClass().getResourceAsStream(
				"/config.properties");
		Properties props = new Properties();
		try {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		browser = props.getProperty("browser");

	}

	@BeforeMethod
	public void setupTest() {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Well, only Firefox allowed at this time...");
		}
	}

	@AfterMethod
	public void tearDownSuite() {
		driver.close();
		// hack needed because of existing bug in Selenium/Firefox which might
		// trigger a plugincontainer error
		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
		}
	}

	public static void log(String s) {
		System.out.println(s);
	}
}
