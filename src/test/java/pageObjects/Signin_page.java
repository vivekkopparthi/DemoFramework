package pageObjects;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import utility.Common;

public class Signin_page {

	WebDriver driver;
	ExtentTest logger;

	public Signin_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername1")
	WebElement signin_box;

	@FindBy(id = "txtPassword")
	WebElement Password_box;

	@FindBy(name = "Submit")
	WebElement submit_button;

	public void getlogger(ExtentTest logger) {
		this.logger = logger;
	} 
	public void validateSignIn(boolean isPositive) throws Exception {
		try {
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			System.out.println(stackTraceElements[2].getMethodName());
			//StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
			//System.out.println(java.lang.Thread.activeCount()+"88888888888");
			System.out.println(Thread.currentThread().getStackTrace()[java.lang.Thread.activeCount()].getMethodName());
			logger.info("Entering User Name");
			
			signin_box.sendKeys(Common.GetProperty("UserName"));
//			logger.info("Entering User password");
//			Password_box.sendKeys(Common.GetProperty("Password"));
//			logger.info("click on signin");
//			submit_button.click();
//			String currentURL = driver.getCurrentUrl();
//			if (isPositive) {
//				logger.info("this is positive Test case");
//				System.out.println("this is positive Test case");
//				Assert.assertEquals(currentURL, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
//                logger.pass("Test pass");
//				
//			} else {
//				System.out.println("This is neg test");
//				Assert.assertEquals(currentURL,
//						"https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
//
//			}

		} catch (NoSuchElementException e) {
			System.out.println("Unable to find element with given Locator "+e);
			Common.takeScreenShot(driver);
			logger.fail("Unable to find element with given Locator "+e);
			logger.addScreenCaptureFromPath("C:\\Users\\Sowji\\newdemo\\eclipse-workspace\\DemoFramework\\Reports\\ScreenShot");
			
			throw e;
		}
		catch (NoSuchWindowException e) {
			System.out.println("Unable to find Window");
			Common.takeScreenShot(driver);
			logger.fail("Unable to find Window");
			logger.addScreenCaptureFromPath("C:\\Users\\Sowji\\newdemo\\eclipse-workspace\\DemoFramework\\Reports\\ScreenShot");
			throw e;
		}
		catch (AssertionError e) {
			System.out.println(e);
			Common.takeScreenShot(driver);
			logger.fail(e);
			logger.addScreenCaptureFromPath("C:\\Users\\Sowji\\newdemo\\eclipse-workspace\\DemoFramework\\Reports\\ScreenShot");

			throw e;
		}
		catch (Exception e) {
			System.out.println(e);
			Common.takeScreenShot(driver);
			logger.fail(e);
			logger.addScreenCaptureFromPath("C:\\Users\\Sowji\\newdemo\\eclipse-workspace\\DemoFramework\\Reports\\ScreenShot");

			throw e;
		}

	}

}
