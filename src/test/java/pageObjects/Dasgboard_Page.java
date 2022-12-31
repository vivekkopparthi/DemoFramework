package pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dasgboard_Page {

	WebDriver driver;

	public Dasgboard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validateMeanuicons(String[] options) {

		List<WebElement> optionsList = driver.findElements(By.xpath("//div[@id='mainMenu']/ul/li/a/b"));
		Assert.assertEquals(optionsList.size(), options.length, "Number of actual and expected options are missmatch");

		for (int i = 0; i < options.length; i++) {
			Assert.assertTrue(optionsList.get(i).getText().equals((options[i])),"this option is not expected"+optionsList.get(i).getText());
		}

	}
}
