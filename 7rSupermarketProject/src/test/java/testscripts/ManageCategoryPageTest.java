package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.Login;
import pages.ManageCategoryPage;
import testscripts.*;
import utilities.ExcelUtils;
import utilities.WaitUtils;

public class ManageCategoryPageTest extends BaseClass {

	public Login login;
	public AdminUsersPage adminuser;
	public ManageCategoryPage managecategory;

	@Test(priority = 1)
	public void verifyAddCategory() throws InterruptedException, IOException {

		String ValidUsername = ExcelUtils.getStringData(1, 0, "CategoryDetail");
		String Validpassword = ExcelUtils.getStringData(1, 1, "CategoryDetail");
		String categoryname = ExcelUtils.getStringData(1, 2, "CategoryDetail");

		String adminusername = ExcelUtils.getStringData(1, 2, "AdminUserDetails");
		String adminpassword = ExcelUtils.getStringData(1, 3, "AdminUserDetails");
		
		Login login = new Login(driver);
		adminuser = login.enterValidUsername(ValidUsername).enterValidPassword(Validpassword).clicLoginbutton();
		managecategory = adminuser.clickadminuserlink().clicknewbutton().enterusername(adminusername).enterpassword(adminpassword).selectuser().clicksavebutton();
		managecategory = managecategory.navigatedashboard().clickcategorylink().clicknewbutton().entercategoryname(categoryname).selectgroup().selectimage().clicksavebutton();

		boolean isCategoryAddAlertShow = managecategory.isCategoryCreatedSuccess();
		assertTrue(isCategoryAddAlertShow, Constants.ERROR_MESSAGEFOR_ADDCATEGORY);
	}

	// @Test(priority=2)
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
		// categorypage.selectgroup();
		// categorypage.selectimage();
		categorypage.editpagescrolldown();
		// Thread.sleep(1000);
		categorypage.clickupdatebutton();

		boolean isCategoryAddAlertShow = categorypage.isCategoryCreatedSuccess();
		assertTrue(isCategoryAddAlertShow, Constants.ERROR_MESSAGEFOR_ADDCATEGORY);
	}
}
