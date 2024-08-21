package testscripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import pages.ManageContactPage;
import utilities.PageUtils;
import utilities.WaitUtils;

public class ManageContactPageTest extends BaseClass {
	@Test
	public void verifyUpdateContact() {

		String Useramefield = "admin";
		String passwordfield = "admin";
		String phone = "9995841221";
		String email = "test1123@mail.com";
		String address = "Test Address";
		String deltime = "8Hrs";
		String delcharge = "12";

		Login login = new Login(driver);
		login.enterValidUsername(Useramefield);
		login.enterValidPassword(passwordfield);
		login.clicLoginbutton();

		ManageContactPage contactpage = new ManageContactPage(driver);
		contactpage.clickmanagecontactlink();
		contactpage.clickeditcontactbutton();
		contactpage.enterphonenumber(phone);
		contactpage.enteremail(email);
		contactpage.enteraddress(address);
		contactpage.enterdeliverytime(deltime);
		contactpage.enterdeliverycharge(delcharge);
		// contactpage.pagescrolldown();
		// page.scrolldown();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		contactpage.clickupdatebutton();

		boolean isContactUpdateAlertShow=contactpage.isContactUpdatedSuccess();
		assertTrue(isContactUpdateAlertShow, Constants.ERROR_MESSAGEFOR_UPDATE_CONTACT);
	}
}
