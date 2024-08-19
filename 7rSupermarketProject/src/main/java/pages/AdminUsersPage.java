package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	
	
	WebDriver driver;

public AdminUsersPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}


@FindBy(xpath="(//a[@class='small-box-footer'])[1]")WebElement adminuserlink;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
@FindBy(xpath="//input[@id='username']")WebElement username;
@FindBy(xpath="//input[@id='password']")WebElement password;
//@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
@FindBy(xpath="//button[@class='close']")WebElement createalert;
//Select se =new Select(usertype);


 
 
 public void clickadminuserlink() {
		adminuserlink.click();
	}
 public void clicknewbutton() {
		newbutton.click();
	}
 
 public void enterusername(String adminname) {
		username.sendKeys(adminname);
	}
 public void enterpassword(String adminpassword) {
		password.sendKeys(adminpassword);
	}
 
 public void selectuser() {
	 	Select select = new Select(driver.findElement(By.xpath("//select[@id='user_type']")));
	 	select.selectByIndex(2);
		
	}
 
 public void clicksavebutton() {
		savebutton.click();
	}
 
 public boolean isalerttextdisplay() {
	return createalert.isDisplayed();
	
}
}
