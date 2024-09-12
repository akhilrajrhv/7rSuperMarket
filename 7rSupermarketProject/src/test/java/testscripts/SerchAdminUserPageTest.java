package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import utilities.ExcelUtils;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import pages.SerchAdminUserPage;

public class SerchAdminUserPageTest extends BaseClass {

	@Test
	public void adminusersearch() throws IOException {
		String ValidUsername = ExcelUtils.getStringData(4, 0, "LoginDetails");
		String Validpassword = ExcelUtils.getStringData(4, 1, "LoginDetails");
		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();
		
		String username = ExcelUtils.getStringData(1, 2, "AdminUserDetails");
		SerchAdminUserPage search = new SerchAdminUserPage(driver);
		search.clickAdminUsers();
		search.clickSearch();
		search.enterUsername(username);
		search.selectUserTypeFromDropdown();
		search.selectSearchButton();
		//search.deleteSearchedValue();
		boolean isalertdisplayed = search.isSearchAlertDisplayed();
		assertTrue(isalertdisplayed, Constants.ERRORFORADMINUSERSEARCH);
	}
	
	public void deletedsearchedadminuser() throws IOException {
		String ValidUsername = ExcelUtils.getStringData(4, 0, "LoginDetails");
		String Validpassword = ExcelUtils.getStringData(4, 1, "LoginDetails");
		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();
		
		String username = ExcelUtils.getStringData(1, 2, "AdminUserDetails");
		SerchAdminUserPage search = new SerchAdminUserPage(driver);
		search.clickAdminUsers();
		search.clickSearch();
		search.enterUsername(username);
		search.selectUserTypeFromDropdown();
		search.selectSearchButton();
		search.deleteSearchedValue();
		boolean isalertdisplayed = search.isSearchAlertDisplayed();
		assertTrue(isalertdisplayed, Constants.ERRORFORADMINUSERSEARCHDELETE);
	}
}