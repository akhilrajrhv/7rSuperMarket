package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	
	WebDriver driver;

public ManageCategoryPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);//Page factory defined
	}

@FindBy(xpath="(//a[@class='small-box-footer'])[5]")WebElement clickcategory;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement clicknewbutton;
@FindBy(xpath="//input[@id='category']")WebElement categoryfield;
@FindBy(xpath="//li[@id='134-selectable']")WebElement selectgroup;
@FindBy(xpath="//input[@id='main_img']")WebElement selectimage;
@FindBy(xpath="//button[@name='create']")WebElement savebutton;
String filepath="C:\\Users\\USER\\Desktop\\Test Images\\testimage.jpg";

public void clickcategorylink() {
	clickcategory.click();
}

public void clicknewbutton() {
	clicknewbutton.click();
}

public void entercategoryname(String name) {
	categoryfield.sendKeys(name);
}

public void selectgroup() {
	selectgroup.click();
}

public void selectimage() {
	selectimage.sendKeys(filepath);
	
}

public void clicksavebutton() {
	savebutton.click();
}

public void pagescrolldown() {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,150)");//Scroll Down
}

}
