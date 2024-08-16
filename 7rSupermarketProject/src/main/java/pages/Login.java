package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;

public Login(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}
@FindBy(xpath="//input[@name='username']") WebElement userame;
@FindBy(xpath="//input[@name='password']") WebElement password;
@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement sigin;
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath="//button[@class='close']") WebElement alertclose;
@FindBy(xpath="//label[@for='remember']") WebElement remember;

public void enterValidUsername(String user) {
	userame.sendKeys(user);
}

public void enterValidPassword(String pass) {
	password.sendKeys(pass);
}


public void clicLoginbutton() {
	sigin.click();
}

public boolean isDashboardDisplayed() {
	return dashboard.isDisplayed();
}

public boolean isClosebuttonDisplayed() {
	return alertclose.isDisplayed();
}

public boolean isremembermeDisplayed() {
	return remember.isDisplayed();
}
}
