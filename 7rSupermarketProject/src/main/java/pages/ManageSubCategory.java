package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtils;

public class ManageSubCategory {

	WebDriver driver;

	public ManageSubCategory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);// Page factory defined
	}

	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	WebElement subcategorylink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageuploadbutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successfullalert;

	String sub_cat_filepath = "C:\\Users\\USER\\Desktop\\Test Images\\testimage.jpg";

	PageUtils page = new PageUtils();

	public void clickSubCategorylink() {
		subcategorylink.click();
	}

	public void clickNewButton() {
		newbutton.click();
	}

	public void selectCategory() {
		page.selectSubCategoryDropDownByValue(categorydropdown);
	}

	public void enterSubCategory(String subcategory) {
		subcategoryfield.sendKeys(subcategory);
	}

	public void imageupload() {
		imageuploadbutton.sendKeys(sub_cat_filepath);
	}

	public void clickSaveButton() {
		savebutton.click();
	}
	
	 public boolean isAlerttextdisplay() {
			return successfullalert.isDisplayed();
			
		}

}
