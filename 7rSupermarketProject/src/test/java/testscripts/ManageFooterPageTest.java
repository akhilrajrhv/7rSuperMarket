package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.Login;
import pages.ManageFooterPage;
import utilities.ExcelUtils;

public class ManageFooterPageTest extends BaseClass{
  @Test
  public void verifyEditFooterDetails() throws IOException {
	  
		String ValidUsername = ExcelUtils.getStringData(1, 0, "FooterDetails");
		String Validpassword = ExcelUtils.getStringData(1, 1, "FooterDetails");
		String updateaddress = ExcelUtils.getStringData(1, 2, "FooterDetails");
		String updateemail = ExcelUtils.getStringData(1, 3, "FooterDetails");
		String updatephone = ExcelUtils.getStringData(1, 4, "FooterDetails");
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(ValidUsername);
	  login.enterValidPassword(Validpassword);
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
	  
	  boolean isfooteralertshow=managefooter.isfooterupdatealertdisplay();
	  assertTrue(isfooteralertshow, "Failed!! Footer text not updated");
	
  }


}
