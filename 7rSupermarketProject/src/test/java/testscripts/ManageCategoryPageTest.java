package testscripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import pages.ManageCategoryPage;
import utilities.WaitUtils;

public class ManageCategoryPageTest extends BaseClass {

	@Test(priority=1)
	public void verifyAddCategory() throws InterruptedException {

		String Useramefield = "admin";
		String passwordfield = "admin";
		String categoryname = "Test Category 1102";

		Login login = new Login(driver);
		login.enterValidUsername(Useramefield);
		login.enterValidPassword(passwordfield);
		login.clicLoginbutton();

		ManageCategoryPage categorypage = new ManageCategoryPage(driver);
		categorypage.clickcategorylink();
		categorypage.clicknewbutton();
		categorypage.entercategoryname(categoryname);
		categorypage.selectgroup();
		categorypage.selectimage();
		categorypage.pagescrolldown();
		Thread.sleep(1000);
		categorypage.clicksavebutton();
		
		boolean isCategoryAddAlertShow=categorypage.isCategoryCreatedSuccess();
		assertTrue(isCategoryAddAlertShow, Constants.ERROR_MESSAGEFOR_ADDCATEGORY);
	}
	
	//@Test(priority=2)
	public void verifyEditCategory() throws InterruptedException {

		String Useramefield = "admin";
		String passwordfield = "admin";
		String editedcategoryname = "Edited Category 1102";

		Login login = new Login(driver);
		login.enterValidUsername(Useramefield);
		login.enterValidPassword(passwordfield);
		login.clicLoginbutton();

		ManageCategoryPage categorypage = new ManageCategoryPage(driver);
		categorypage.clickcategorylink();
		categorypage.clickeditbutton();
		categorypage.clearcategoryfield();
		categorypage.entercategoryname(editedcategoryname);
	//	categorypage.selectgroup();
	//	categorypage.selectimage();
		categorypage.editpagescrolldown();
		//Thread.sleep(1000);
		categorypage.clickupdatebutton();
		
		boolean isCategoryAddAlertShow=categorypage.isCategoryCreatedSuccess();
		assertTrue(isCategoryAddAlertShow, Constants.ERROR_MESSAGEFOR_ADDCATEGORY);
	}
}
