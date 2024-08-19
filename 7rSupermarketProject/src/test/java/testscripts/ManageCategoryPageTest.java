package testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.Login;
import pages.ManageCategoryPage;

public class ManageCategoryPageTest extends BaseClass {
  @Test
  public void verifyAddCategory() throws InterruptedException {
	  
	  String Useramefield="admin";
	  String passwordfield="admin";
	  String categoryname="Test Category";
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(Useramefield);
	  login.enterValidPassword(passwordfield);
	  login.clicLoginbutton();
	  
	 ManageCategoryPage categorypage=new ManageCategoryPage(driver);
	 categorypage.clickcategorylink();
	 categorypage.clicknewbutton();
	 categorypage.entercategoryname(categoryname);
	 categorypage.selectgroup();
	 categorypage.selectimage();
	 categorypage.pagescrolldown();
	 Thread.sleep(1000);
	 categorypage.clicksavebutton();
	   
  }
}
