package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import pages.ManageSubCategory;
import utilities.ExcelUtils;

public class ManageSubCategoryTest extends BaseClass {

	@Test
	public void verifyAddSubcategory() throws IOException {

		String ValidUsername = ExcelUtils.getStringData(1, 0, "SubCategoryDetails");
		String Validpassword = ExcelUtils.getStringData(1, 1, "SubCategoryDetails");
		String subcategoryvalue = ExcelUtils.getStringData(1, 2, "SubCategoryDetails");

		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();

		ManageSubCategory subcategory = new ManageSubCategory(driver);
		subcategory.clickSubCategorylink();
		subcategory.clickNewButton();
		subcategory.selectCategory();
		subcategory.enterSubCategory(subcategoryvalue);
		subcategory.imageupload();
		subcategory.clickSaveButton();

		boolean isSuccessAlertshow = subcategory.isAlerttextdisplay();
		assertTrue(isSuccessAlertshow, Constants.ERROR_MESSAGEFOR_ADDCATEGORY);
	}
}
