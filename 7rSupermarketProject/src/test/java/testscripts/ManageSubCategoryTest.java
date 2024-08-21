package testscripts;

import static org.testng.Assert.assertTrue;

import org.apache.commons.math3.analysis.function.Constant;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login;
import pages.ManageSubCategory;

public class ManageSubCategoryTest extends BaseClass{
	
  @Test
  public void verifyAddSubcategory() {
	  
		String Useramefield = "admin";
		String passwordfield = "admin";
		String subcategoryvalue = "Test Subcategory 1126";

		Login login = new Login(driver);
		login.enterValidUsername(Useramefield);
		login.enterValidPassword(passwordfield);
		login.clicLoginbutton();
		
		ManageSubCategory subcategory=new ManageSubCategory(driver);
		subcategory.clickSubCategorylink();
		subcategory.clickNewButton();
		subcategory.selectCategory();
		subcategory.enterSubCategory(subcategoryvalue);
		subcategory.imageupload();
		subcategory.clickSaveButton();
		
		  boolean isSuccessAlertshow=subcategory.isAlerttextdisplay();
		  assertTrue(isSuccessAlertshow, Constants.ERROR_MESSAGEFOR_ADDCATEGORY);
  }
}
