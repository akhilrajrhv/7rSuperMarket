package testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import utilities.ExcelUtils;

public class LoginPageTest extends BaseClass {

	@Test(priority = 1)
	public void verifyEnterValidUsernameAndInvalidPassword() throws IOException {

		String ValidUsername = ExcelUtils.getStringData(1, 0, "LoginDetails");
		String Invalidpassword = ExcelUtils.getStringData(1, 1, "LoginDetails");

		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Invalidpassword);
		login.clicLoginbutton();

		// Assertion
		boolean isAlertcloseShow = login.isClosebuttonDisplayed();
		assertTrue(isAlertcloseShow, Constants.ERROR_MESSAGEFOR_INVAILD_LOGIN);

	}

	@Test(priority = 2)
	public void verifyEnterInvalidUsernameAndValidPassword() throws IOException {

		String InValidUsername = ExcelUtils.getStringData(2, 0, "LoginDetails");
		String Validpassword = ExcelUtils.getStringData(2, 1, "LoginDetails");

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
