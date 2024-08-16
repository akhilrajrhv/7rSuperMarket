package testscripts;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.Login;

public class AdminUserPageTest extends BaseClass{
  @Test
  public void verifyCreateNewAdminUser() {
	  
	  String Useramefield="admin";
	  String passwordfield="admin";
	  String adminusername="Akhil";
	  String adminpassword="User123";
	 // String admintype="Admin";
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(Useramefield);
	  login.enterValidPassword(passwordfield);
	  login.clicLoginbutton();

	  AdminUsersPage adminuser=new AdminUsersPage(driver);
	  adminuser.clickadminuserlink();
	  adminuser.clicknewbutton();
	  adminuser.enterusername(adminusername);
	  adminuser.enterpassword(adminpassword);
	  adminuser.selectuser();
	  adminuser.clicksavebutton();
	  
  }
}
