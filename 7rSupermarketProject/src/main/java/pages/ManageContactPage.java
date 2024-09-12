package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtils;
import utilities.WaitUtils;

public class ManageContactPage {

	WebDriver driver;

public ManageContactPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}
@FindBy(xpath="(//a[@class='small-box-footer'])[5]")WebElement managecontactlink;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editcontactbutoon;
@FindBy(xpath="//input[@id='phone']")WebElement phonenofield;
@FindBy(xpath="//input[@id='email']")WebElement emailfield;
@FindBy(xpath="//textarea[@name='address']")WebElement addressfield;
@FindBy(xpath="(//textarea[@id='content'])[2]")WebElement deliverytimefield;
@FindBy(xpath="//input[@id='del_limit']")WebElement deliverychargefield;
@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement updatebutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement contactsuccessalert;

WaitUtils pagewait=new WaitUtils();
PageUtils page=new PageUtils();

public ManageContactPage clickmanagecontactlink () {
	managecontactlink.click();
	return this;
}

public ManageContactPage clickeditcontactbutton () {
	editcontactbutoon.click();
	return this;
}

public ManageContactPage enterphonenumber (String phoneno) {
	phonenofield.clear();
	phonenofield.sendKeys(phoneno);
	return this;
}

public ManageContactPage enteremail (String email) {
	emailfield.clear();
	emailfield.sendKeys(email);
	return this;
}

public ManageContactPage enteraddress (String address) {
	addressfield.clear();
	addressfield.sendKeys(address);
	return this;
}

public ManageContactPage enterdeliverytime (String deliverytime) {
	deliverytimefield.clear();
	deliverytimefield.sendKeys(deliverytime);
	return this;
}

public ManageContactPage enterdeliverycharge (String deliverycharge) {
	deliverychargefield.clear();
	deliverychargefield.sendKeys(deliverycharge);
	//page.scrolldown();
	return this;
}

public ManageContactPage clickupdatebutton () {
	 pagewait.waitforelement(updatebutton);
	updatebutton.click();
	return new ManageContactPage(driver);
}

public void pagescrolldown() {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,150)");//Scroll Down
}

public boolean isContactUpdatedSuccess() {
	return contactsuccessalert.isDisplayed();
}

}
