package testscripts;

import org.testng.annotations.Test;

import pages.Login;
import pages.ManageNewsPage;

public class ManageNewsPageTest extends BaseClass {
  @Test
  public void verifyAddNews() {
	  
	  String Useramefield="admin";
	  String passwordfield="admin";
	  String enternewsdetails= "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
	  
	  Login login=new Login(driver);
	  login.enterValidUsername(Useramefield);
	  login.enterValidPassword(passwordfield);
	  login.clicLoginbutton();
	  
	  ManageNewsPage newspage=new ManageNewsPage(driver);
	  newspage.clickmanagenewslink();
	  newspage.clicknewbutton();
	  newspage.enternewsdetails(enternewsdetails);
	  newspage.clicksavebutton();
  }
}
