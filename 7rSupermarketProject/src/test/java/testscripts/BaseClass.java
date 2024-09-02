package testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenShotUtils;

public class BaseClass {

	WebDriver driver;
	ScreenShotUtils scrshot;

	@BeforeMethod
	@Parameters("Browser")
	public void initializeMethod(String browser) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}

		// driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	/*
	 * public void afterMethod() { // driver.quit(); }
	 * 
	 */

	@AfterMethod
	public void browserQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotUtils();
			scrshot.captureFailureScreenShot(driver, itestresult.getName());
			driver.quit();

		}

	}
}
