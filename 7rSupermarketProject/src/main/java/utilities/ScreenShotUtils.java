package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class ScreenShotUtils {

	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;// Interface
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// To take screenshot

		File f1 = new File(System.getProperty("user.dir") + "\\OutputScreenshots");// create file
		if (!f1.exists()) {
			f1.mkdirs();// Java make directories (if no path given automatically create directory)
		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0));// For time stamp

		File finalDestination = new File(System.getProperty("user.dir") + "\\OutputScreenshots\\" + name + "_" + timeStamp + ".png");
		FileHandler.copy(screenShot, finalDestination);

	}

}
