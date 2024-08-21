package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;

public ManageNewsPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}

@FindBy(xpath="(//a[@class='small-box-footer'])[9]")WebElement managenewslink;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
@FindBy(xpath="//textarea[@id='news']")WebElement newsinput;
@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebuton;


public void clickmanagenewslink () {
	managenewslink.click();
}

public void clicknewbutton () {
	newbutton.click();
}

public void enternewsdetails (String news) {
	newsinput.sendKeys(news);
}

public void clicksavebutton () {
	savebuton.click();
}

}
