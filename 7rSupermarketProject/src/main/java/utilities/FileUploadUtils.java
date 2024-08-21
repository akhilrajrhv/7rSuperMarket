package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

import pages.ManageCategoryPage;

public class FileUploadUtils {
	// Create send keys and roboclass

    public static void uploadImage(WebElement fileInputElement, String filePath) {
        fileInputElement.sendKeys(filePath);
    }

	public void selectAll() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
	}

}
