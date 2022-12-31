package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Admin_Page;
import pageObjects.Signin_page;
import utility.BaseClass;
import utility.Common;

public class OrangeHRM extends BaseClass {
	
	
  @Test
  public void f() throws Exception {
	  
	    logger = extents.createTest("OrangeHRM");
	    logger.pass("pass");
		Signin_page signin = new Signin_page(driver);
		signin.getlogger(logger);
		logger.info("Validating Signin");
		
		
		BaseClass.Steplogger(logger, Common.takeScreenShot2(driver));
		signin.validateSignIn( true);   //when: launch the URL and Enter credentials
		
//		Admin_Page adminpage = new Admin_Page(driver);
//		
//		adminpage.moveToAdminPage();
//		
//		adminpage.user_Search("Jasmine.Morgan", "ESS", "Jasmine Morgan", "Enabled");// AND: search for a user
//		
//		adminpage.validateSearchResults("Jasmine.Morgan", "ESS", "Jasmine Morgan", "Enabled");// then: user should be validated 
		
		
	  
  }
}
