package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtils {
	
	WebDriver driver;

public void selectAdminUsertypeDropDownByIndex(WebElement element)
{
	Select select=new Select(element);
	select.selectByIndex(2);
}

public void selectSubCategoryDropDownByValue(WebElement element)
{
	Select select=new Select(element);
	select.selectByValue("164");
}

public void selectUserType(WebElement usertype)
{
	Select select=new Select(usertype);
	select.selectByIndex(2);
}

public void scrolldown() {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,150)");
}
}
