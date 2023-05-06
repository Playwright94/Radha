package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constaants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		lp = hp.navigateToLogin();

		String actualLogiPageTitle = lp.getLoginPageTitle();

		System.out.println("page title is::" + actualLogiPageTitle);

		Assert.assertEquals(actualLogiPageTitle, AppConstants.LOGIN_TITLE);

	}

	@Test(priority = 2)
	public void isForgotPwdlinkExist() {
		Assert.assertTrue(lp.isForgotPwdLinkExist());

	}

	@Test(priority = 3)
	public void appLoginTest() {
		Assert.assertTrue(lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));

	}
	
	@Test(priority = 4)
	public void ComponentsOptionTest() {
	   Assert.assertTrue(lp.validateComponentsVisibleOptions());
		
	}
	
//	@Test(priority = 5)
//	public void ComponentsOptionAvailabilityTest() {
//	   List<String> printComponentOptions = lp.printComponentOptions();
//	   Assert.assertTrue(printComponentOptions.contains("Monitors (2)"));
//		
//	}
	
	
	
	
	
	
	
	

}
