package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.Login;

public class LoginPageTest extends BaseClass {
  @Test
  public void verifyEnterValidUsernameAndPassword() {
	  
	  String Useramefield="admin";
	  String passwordfield="admin";
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(Useramefield);
	  login.enterValidPassword(passwordfield);
	  login.clicLoginbutton();
	  
	  //Assertion
	  boolean isDashboardLoaded=login.isDashboardDisplayed();
	  assertTrue(isDashboardLoaded, "Dashboard not loaded");
  }
}
