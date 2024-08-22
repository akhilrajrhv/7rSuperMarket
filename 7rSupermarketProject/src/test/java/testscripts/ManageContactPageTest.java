package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import pages.ManageContactPage;
import utilities.ExcelUtils;
import utilities.PageUtils;
import utilities.WaitUtils;

public class ManageContactPageTest extends BaseClass {
	@Test
	public void verifyUpdateContact() throws IOException {

		String ValidUsername = ExcelUtils.getStringData(1, 0, "ContactDetails");
		String Validpassword = ExcelUtils.getStringData(1, 1, "ContactDetails");
		String phone = ExcelUtils.getIntegerData(1, 2, "ContactDetails");
		String email = ExcelUtils.getStringData(1, 3, "ContactDetails");
		String address = ExcelUtils.getStringData(1, 4, "ContactDetails");
		String deltime = ExcelUtils.getIntegerData(1, 5, "ContactDetails");
		String delcharge = ExcelUtils.getIntegerData(1, 6, "ContactDetails");

		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
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

		boolean isContactUpdateAlertShow = contactpage.isContactUpdatedSuccess();
		assertTrue(isContactUpdateAlertShow, Constants.ERROR_MESSAGEFOR_UPDATE_CONTACT);
	}
}
