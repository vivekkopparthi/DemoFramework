package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	public WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extents;
	public static ExtentTest logger;
	// public static MediaEntityBuilder

	// @BeforeClass
	@BeforeSuite
	public void openBrowser() throws IOException {
		reporter = new ExtentHtmlReporter(
				"C:\\Users\\Sowji\\newdemo\\eclipse-workspace\\DemoFramework\\Reports\\latest.html");
		extents = new ExtentReports();
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Execution Report - "+java.util.Calendar.getInstance().getTime().toString());
		
		reporter.config().setReportName("Orange HRM Execution Results");
		reporter.config().setJS("$('.brand-logo').text('Orang');");
		extents.attachReporter(reporter);
		extents.setSystemInfo("OS", System.getProperty("os.name"));
		extents.setSystemInfo("Java", System.getProperty("java.specification.version"));
		extents.setSystemInfo("User", System.getProperty("user.name"));
		extents.setSystemInfo("Time", java.util.Calendar.getInstance().getTime().toString());

		if (Common.GetProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\Users\\\\Sowji\\\\Downloads\\\\chromedriver_win32 (6)\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Common.GetProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Sowji\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(Common.GetProperty("URL"));
	}

	// @AfterMethod
	// public void getresult(ITestResult result) {
	// if
	// }
	// @AfterClass
	@AfterSuite
	public void closeBrowser() {
		driver.close();
		extents.flush();
	}

	public static void Steplogger(ExtentTest logger, String path) throws IOException {

		logger.fail("pic info", MediaEntityBuilder.createScreenCaptureFromPath(
				"C:\\\\Users\\\\Sowji\\\\newdemo\\\\eclipse-workspace\\\\DemoFramework\\\\Reports\\\\ScreenShot_step",
				"ss1").build());
	}

}
