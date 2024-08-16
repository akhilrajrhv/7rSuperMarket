package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
	WebDriver driver;

public ManageFooterPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}

@FindBy(xpath="(//a[@class='small-box-footer'])[8]")WebElement managefooter;
@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")WebElement editfooterbutton;
@FindBy(xpath="//textarea[@id='content']")WebElement addressfield;
@FindBy(xpath="//input[@id='email']")WebElement emailfield;
@FindBy(xpath="//input[@id='phone']")WebElement phonefield;
@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;

public void clickmanagefooterlink() {
	managefooter.click();
}

public void clickeditbutton() {
	editfooterbutton.click();
}

public void clearaddressfield() {
	addressfield.clear();
}

public void enteraddress(String address) {
	addressfield.sendKeys(address);
}

public void clearemailfield() {
	emailfield.clear();
}
public void enteremail(String email) {
	emailfield.sendKeys(email);
}

public void clearphonenofield() {
	phonefield.clear();
}

public void enterphone(String phone) {
	phonefield.sendKeys(phone);
}

public void clickupdatebutton() {
	updatebutton.click();
}

}
