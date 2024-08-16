package testscripts;

import static org.testng.Assert.assertFalse;
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
  
  @Test
  public void verifyEnterValidUsernameAndInvalidPassword() {
	  
	  String ValidUsername="admin";
	  String Invalidpassword="sample";
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(ValidUsername);
	  login.enterValidPassword(Invalidpassword);
	  login.clicLoginbutton();
	  
	  //Assertion
	boolean isAlertcloseShow=login.isClosebuttonDisplayed();
	assertTrue(isAlertcloseShow, "Alert for incorrect credentials not loaded");
	
  }
  
  @Test
  
  public void verifyremembermeCheckbox() {
	  Login login=new Login(driver);
	  boolean isremberme=login.isremembermeDisplayed();
		assertTrue(isremberme, "Remember me check box not loaded");
	  
  }
}
