package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test_111 {

	public String getclassname() {
		String className = this.getClass().getSimpleName();
		return className;
	}
	public static void main(String[] args) {
		Test_111 test = new Test_111();
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sowji\\Downloads\\chromedriver_win32 _4420\\chromedriver.exe");
		//driver = new ChromeDriver();		
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\Sowji\\newdemo\\eclipse-workspace\\DemoFramework\\Reports\\latest.html");
		ExtentReports extents = new ExtentReports();
		extents.attachReporter(reporter);
		
		ExtentTest logger = extents.createTest(test.getclassname());
		logger.info("this is info");
		
		logger.pass(" this is pass");
		
		logger.fail("This is fail");
		
		ExtentTest logger2 = extents.createTest("Test-2");
		
		logger2.info("this is info");
		logger2.pass("this is pass");
		
		extents.flush();

	}

}
