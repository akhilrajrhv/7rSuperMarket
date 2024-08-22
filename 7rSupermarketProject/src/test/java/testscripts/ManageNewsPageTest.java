package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Login;
import pages.ManageNewsPage;
import utilities.ExcelUtils;

public class ManageNewsPageTest extends BaseClass {
	@Test
	public void verifyAddNews() throws IOException {

		String ValidUsername = ExcelUtils.getStringData(1, 0, "NewDetails");
		String Validpassword = ExcelUtils.getStringData(1, 1, "NewDetails");
		String enternewsdetails = ExcelUtils.getStringData(1, 2, "NewDetails");

		Login login = new Login(driver);
		login.enterValidUsername(ValidUsername);
		login.enterValidPassword(Validpassword);
		login.clicLoginbutton();

		ManageNewsPage newspage = new ManageNewsPage(driver);
		newspage.clickmanagenewslink();
		newspage.clicknewbutton();
		newspage.enternewsdetails(enternewsdetails);
		newspage.clicksavebutton();
	}
}
