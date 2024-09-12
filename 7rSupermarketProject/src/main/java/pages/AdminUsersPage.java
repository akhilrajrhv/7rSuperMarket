package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtils;

public class AdminUsersPage {
	
	
	WebDriver driver;
	PageUtils page=new PageUtils();
	
public AdminUsersPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}


@FindBy(xpath="(//a[@class='small-box-footer'])[1]")WebElement adminuserlink;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
@FindBy(xpath="//input[@id='username']")WebElement username;
@FindBy(xpath="//input[@id='password']")WebElement password;
@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
@FindBy(xpath="//button[@class='close']")WebElement createalert;



 
 
 public AdminUsersPage clickadminuserlink() {
		adminuserlink.click();
		return this;
	}
 public AdminUsersPage clicknewbutton() {
		newbutton.click();
		return this;
	}
 
 public AdminUsersPage enterusername(String adminname) {
		username.sendKeys(adminname);
		return this;
	}
 public AdminUsersPage enterpassword(String adminpassword) {
		password.sendKeys(adminpassword);
		return this;
	}
 
 public AdminUsersPage selectuser() {
	 	//Select select = new Select(driver.findElement(By.xpath("//select[@id='user_type']")));
	 	//select.selectByIndex(2);
	 	page.selectAdminUsertypeDropDownByIndex(usertype);
		return this;
		
	}
 
 public ManageCategoryPage clicksavebutton() {
		savebutton.click();
		return new ManageCategoryPage(driver);
	}
 
 public boolean isalerttextdisplay() {
	return createalert.isDisplayed();
	
}
}
