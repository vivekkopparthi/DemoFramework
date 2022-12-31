package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Common {

	
public static String GetProperty(String key) throws IOException {
	Properties prop = new Properties();
	
	FileInputStream inputstrem = new FileInputStream(".\\config\\configurations.properties");

	prop.load(inputstrem);
	
	String result = (String) prop.get(key);
	
	return result;
	
}

public static void takeScreenShot(WebDriver driver) throws IOException {
	System.out.println(Thread.currentThread().getStackTrace()[java.lang.Thread.activeCount()].getMethodName());
	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	//System.out.println(stackTraceElements.length+"*********");
	System.out.println(stackTraceElements[2].getMethodName());

	TakesScreenshot screenshot = ((TakesScreenshot) driver);
	
	File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
	
	String dest_path = ".\\Reports\\ScreenShot";
	
	File dest_file = new File(dest_path);
	
	FileHandler.copy(srcfile, dest_file);
}

public static String takeScreenShot2(WebDriver driver) throws IOException {
	TakesScreenshot screenshot = ((TakesScreenshot) driver);
	
	File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
	
	String dest_path = ".\\Reports\\ScreenShot_step";
	
	File dest_file = new File(dest_path);
	
	FileHandler.copy(srcfile, dest_file);
	System.out.println(dest_path);
	return dest_path;
}


	
	
}
