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

	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
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
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement navigateto_dashboard;
	
	String filepath = "C:\\Users\\USER\\Desktop\\Test Images\\testimage.jpg";

	WaitUtils pagewait = new WaitUtils();
	

	public ManageCategoryPage clickcategorylink() {
		clickcategory.click();
		return this;
	}

	public ManageCategoryPage clicknewbutton() {
		clicknewbutton.click();
		return this;
	}

	public ManageCategoryPage entercategoryname(String name) {
		categoryfield.sendKeys(name);
		return this;
	}

	public ManageCategoryPage selectgroup() {
		selectgroup.click();
		return this;
	}

	public ManageCategoryPage selectimage() {
		//selectimage.sendKeys(filepath);
		FileUploadUtils.uploadImage(selectimage, filepath);
		return this;

	}

	public ManageCategoryPage clicksavebutton() {
		pagewait.waitforelement(savebutton);
		savebutton.click();
		return this ;
	}
	
	public ManageCategoryPage navigatedashboard() {
		
		navigateto_dashboard.click();
		return this;
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
