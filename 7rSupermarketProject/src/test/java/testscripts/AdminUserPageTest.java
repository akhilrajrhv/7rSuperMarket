package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.Login;
import utilities.ExcelUtils;

public class AdminUserPageTest extends BaseClass {
	@Test
	public void verifyCreateNewAdminUser() throws IOException {


		Login login = new Login(driver);
		String ValidUsername = ExcelUtils.getStringData(1, 0, "AdminUserDetails");
		String Validpassword = ExcelUtils.getStringData(1, 1, "AdminUserDetails");
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();

		AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser.clickadminuserlink();
		adminuser.clicknewbutton();
		String adminusername = ExcelUtils.getStringData(1, 2, "AdminUserDetails");
		String adminpassword = ExcelUtils.getStringData(1, 3, "AdminUserDetails");
		System.out.println("Admin UserName--->"+adminusername);
		adminuser.enterusername(adminusername);
		adminuser.enterpassword(adminpassword);
		adminuser.selectuser();
		adminuser.clicksavebutton();

		boolean isAlerttextshow = adminuser.isalerttextdisplay();
		assertTrue(isAlerttextshow, "Failed!! Admin User Not Created");

	}
}
