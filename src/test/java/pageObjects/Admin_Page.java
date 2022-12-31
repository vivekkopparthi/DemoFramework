package pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Admin_Page {

	WebDriver driver;
	public Admin_Page(WebDriver driver) {
		this.driver = driver;
	}
	By admin_icon = By.id("menu_admin_viewAdminModule");
	By username = By.name("searchSystemUser[userName]");
	By userrole_dd = By.name("searchSystemUser[userType]");
	By empt_name = By.name("searchSystemUser[employeeName][empName]");
	By status_dd = By.name("searchSystemUser[status]");
	By searchButton = By.id("searchBtn");
	
	public void moveToAdminPage() {
		driver.findElement(admin_icon).click();
	}
	public void user_Search(String userName,String userrole,String empNAme,String status) throws InterruptedException {
		driver.findElement(username).sendKeys(userName);
		
		WebElement roledropdown = driver.findElement(userrole_dd);		
		this.selectDD_visibleText(roledropdown, userrole);
		
		driver.findElement(empt_name).sendKeys(empNAme);
		
		WebElement statusdropdown = driver.findElement(status_dd);
		this.selectDD_visibleText(statusdropdown, status);
		
		driver.findElement(searchButton).click();
		Thread.sleep(2000);
		
	}
	
	public void selectDD_visibleText(WebElement dropdown,String optionToSelect) {
		Select optionselect = new Select(dropdown);
		optionselect.selectByVisibleText(optionToSelect);
	}
	
	public void validateSearchResults(String userName,String userrole,String empNAme,String status) {
		
		driver.findElement(By.xpath("//a[text()='"+userName+"']")).isDisplayed();
		driver.findElement(By.xpath("//td[text()='"+userrole+"']")).isDisplayed();
		driver.findElement(By.xpath("//td[text()='"+empNAme+"']")).isDisplayed();
		driver.findElement(By.xpath("//td[text()='"+status+"']")).isDisplayed();
		
	}
	
	
}
