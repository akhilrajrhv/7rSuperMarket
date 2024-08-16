package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.Login;
import pages.ManageFooterPage;

public class ManageFooterPageTest extends BaseClass{
  @Test
  public void verifyEditFooterDetails() {
	  
	  String Useramefield="admin";
	  String passwordfield="admin";
	  String updateaddress="Asiatic business center,Technopark Phase";
	  String updateemail="testing@gmail.com";
	  String updatephone="9995412335";
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(Useramefield);
	  login.enterValidPassword(passwordfield);
	  login.clicLoginbutton();
	  
	  ManageFooterPage managefooter=new ManageFooterPage(driver);
	  managefooter.clickmanagefooterlink();
	  managefooter.clickeditbutton();
	  managefooter.clearaddressfield();
	  managefooter.enteraddress(updateaddress);
	  managefooter.clearemailfield();
	  managefooter.enteremail(updateemail);
	  managefooter.clearphonenofield();
	  managefooter.enterphone(updatephone);
	  managefooter.clickupdatebutton();
	
  }


}
