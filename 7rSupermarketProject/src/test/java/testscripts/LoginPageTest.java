package testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Credentials;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import utilities.ExcelUtils;

public class LoginPageTest extends BaseClass {
	
	@DataProvider(name="credentials")
	public Object[][] testData() {// data provider
		Object[][] input = new Object[2][2];
		//input[0][0] = "admin";
		//input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;
	}
	
	@Test(priority = 1,dataProvider = "credentials")
	public void verifyEnterValidUsernameAndInvalidPassword(String ValidUsername,String Invalidpassword) throws IOException {

		//String ValidUsername = ExcelUtils.getStringData(1, 0, "LoginDetails");
		//String Invalidpassword = ExcelUtils.getStringData(1, 1, "LoginDetails");

		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Invalidpassword);
		login.clicLoginbutton();

		// Assertion
		boolean isAlertcloseShow = login.isClosebuttonDisplayed();
		assertTrue(isAlertcloseShow, Constants.ERROR_MESSAGEFOR_INVAILD_LOGIN);

	}

	@Test(priority = 2)
	@Parameters({"Username","Password"})
	public void verifyEnterInvalidUsernameAndValidPassword(String InValidUsername,String Validpassword) throws IOException {

		//String InValidUsername = ExcelUtils.getStringData(2, 0, "LoginDetails");
		//String Validpassword = ExcelUtils.getStringData(2, 1, "LoginDetails");

		Login login = new Login(driver);
		login.enterValidUsername(InValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();

		// Assertion
		boolean isAlertcloseShow = login.isClosebuttonDisplayed();
		assertTrue(isAlertcloseShow, Constants.ERROR_MESSAGEFOR_INVAILD_LOGIN);

	}

	@Test(priority = 3)
	public void verifyEnterInvalidUsernameAndInvalidPassword() throws IOException {

		String InValidUsername = ExcelUtils.getStringData(3, 0, "LoginDetails");
		String InValidpassword = ExcelUtils.getStringData(3, 1, "LoginDetails");

		Login login = new Login(driver);
		login.enterValidUsername(InValidUsername);
		login.enterValidPassword(InValidpassword);
		login.clicLoginbutton();

		// Assertion
		boolean isAlertcloseShow = login.isClosebuttonDisplayed();
		assertTrue(isAlertcloseShow, Constants.ERROR_MESSAGEFOR_INVAILD_LOGIN);

	}

	@Test(priority = 4)
	public void verifyEnterValidUsernameAndValidPassword() throws IOException {

		String ValidUsername = ExcelUtils.getStringData(4, 0, "LoginDetails");
		String Validpassword = ExcelUtils.getStringData(4, 1, "LoginDetails");

		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();

		// Assertion
		boolean isDashboardLoaded = login.isDashboardDisplayed();
		assertTrue(isDashboardLoaded, Constants.ERROR_MESSAGEFOR_VALID_LOGIN);
	}

	// @Test

	public void verifyremembermeCheckbox() {
		Login login = new Login(driver);
		boolean isremberme = login.isremembermeDisplayed();
		assertTrue(isremberme, "Remember me check box not loaded");

	}
}
