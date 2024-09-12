package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.ManageCategoryPage;
import pages.Login;
import utilities.ExcelUtils;

public class AdminUserPageTest extends BaseClass {

	public Login login;
	public AdminUsersPage adminuser;
	public ManageCategoryPage managecategory;

	@Test
	public void verifyCreateNewAdminUser() throws IOException {

	
		String ValidUsername = ExcelUtils.getStringData(1, 0, "AdminUserDetails");
		String Validpassword = ExcelUtils.getStringData(1, 1, "AdminUserDetails");
		// For chaining(Pass only one driver)
		login = new Login(driver);
		adminuser = login.enterValidUsername(ValidUsername).enterValidPassword(Validpassword).clicLoginbutton();

		String adminusername = ExcelUtils.getStringData(1, 2, "AdminUserDetails");
		String adminpassword = ExcelUtils.getStringData(1, 3, "AdminUserDetails");
		managecategory = adminuser.clickadminuserlink().clicknewbutton().enterusername(adminusername).enterpassword(adminpassword).selectuser().clicksavebutton();

		boolean isAlerttextshow = adminuser.isalerttextdisplay();
		assertTrue(isAlerttextshow, "Failed!! Admin User Not Created");

	}
}
