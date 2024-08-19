package testscripts;

import static org.testng.Assert.assertTrue;

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
	  
	  
	  boolean isAlerttextshow=adminuser.isalerttextdisplay();
	  assertTrue(isAlerttextshow, "Failed!! Admin User Not Created");
	  
  }
}
