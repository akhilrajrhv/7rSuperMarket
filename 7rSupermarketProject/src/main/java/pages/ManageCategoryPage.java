package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtils;
import utilities.WaitUtils;

public class ManageCategoryPage {

	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);// Page factory defined
	}

	@FindBy(xpath = "(//a[@class='small-box-footer'])[5]")
	WebElement clickcategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknewbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement selectimage;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@role='button' and @class='btn btn-sm btn btn-primary btncss' and contains(@href, 'edit=378')]")
	WebElement editcategorybutton;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updatecategorybutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryaddsuccssAlert;
	String filepath = "C:\\Users\\USER\\Desktop\\Test Images\\testimage.jpg";

	WaitUtils pagewait = new WaitUtils();
	

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
		//selectimage.sendKeys(filepath);
		//upload.uploadImage(selectimage, filepath);
		FileUploadUtils.uploadImage(selectimage, filepath);

	}

	public void clicksavebutton() {
		pagewait.waitforelement(savebutton);
		savebutton.click();
	}
	
	public void clickeditbutton() {
		editcategorybutton.click();
	}
	public void clearcategoryfield() {
		editcategorybutton.clear();
	}
	public void clickupdatebutton() {
		updatecategorybutton.click();
	}
	
	public boolean isCategoryCreatedSuccess() {
		return categoryaddsuccssAlert.isDisplayed();
	}

	public void pagescrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");// Scroll Down
	}
	public void editpagescrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");// Scroll Down
	}

}
