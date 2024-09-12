package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PageUtils;
import utilities.WaitUtils;


public class SerchAdminUserPage 
{
	WebDriver driver;
	
	public SerchAdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	PageUtils page=new PageUtils();
	WaitUtils Wait=new WaitUtils();
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") WebElement adminUsers;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement clickSearch;
	@FindBy(xpath="//input[@id='un']") WebElement enterUsername;
	@FindBy(xpath="//select[@id='ut']") WebElement userType;
	@FindBy(xpath="(//button[@type='submit'])[1]") WebElement searchButton;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]") WebElement delete;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']") WebElement alertSearch;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertDelete;
	
	public void clickAdminUsers()
	{
		adminUsers.click();
		
	}	
	public void clickSearch()
	{
		clickSearch.click();
		
	}
	public void enterUsername(String username) throws IOException
	{
		enterUsername.click();			
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(enterUsername));
		System.out.println(username);
		enterUsername.sendKeys(username);
		
	}
	public void selectUserTypeFromDropdown()
	{
		page.selectUserType(userType);
	}
		
	public void selectSearchButton()
	{
		searchButton.click();
	
	}
	public void deleteSearchedValue()
	{
		delete.click();
		driver.switchTo().alert().accept();
		
	}
	public boolean isSearchAlertDisplayed()
	{
		return alertSearch.isDisplayed();
	}
	public boolean isDeleteAlertDisplayed()
	{
		return alertDelete.isDisplayed();
	}
}