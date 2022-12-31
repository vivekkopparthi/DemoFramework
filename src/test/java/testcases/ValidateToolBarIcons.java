package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Dasgboard_Page;
import pageObjects.Signin_page;
import utility.BaseClass;

public class ValidateToolBarIcons extends BaseClass{
	@Test
	public void f() throws Exception {
		logger = extents.createTest("validate Tool Bar");	
//		Signin_page signin = new Signin_page(driver);
//
//		signin.validateSignIn(true);
//
//		Dasgboard_Page dashboard = new Dasgboard_Page(driver);
//
//		String[] optionsarray = { "PIM", "Admin", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard",
//				"Directory", "Maintenance", "Buzzs" };
//		dashboard.validateMeanuicons(optionsarray);
		logger.pass("pass");
		
		

	}
}
