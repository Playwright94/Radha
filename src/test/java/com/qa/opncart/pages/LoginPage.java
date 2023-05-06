package com.qa.opncart.pages;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// String locators

	private String emailID = "//input[@id='input-email']";

	private String password = "//input[@id='input-password']";

	private String loginBtn = "//input[@value='Login']";

	private String forgotpwdLink = "//input[@name='password']//following-sibling::a";
	private String LogoutLink = "//div[@class='list-group']/child::a[text()='Logout']";

	private String Componentslink="//a[text()='Components']";
	private String CompeonentOptions="//a[text()='Components']/parent::li/div//li";
	
	
	
	// constructor
	public LoginPage(Page page) {
		this.page = page;

	}
	// page actions now

	public String getLoginPageTitle() {

		String title = page.title();
		return title;

	}

	public boolean isForgotPwdLinkExist() {

		boolean disabled =page.isVisible(forgotpwdLink);
		return disabled;
	}

	public boolean doLogin(String appUsername, String appPassword) {
		System.out.println(appUsername + " ::" + appPassword);

		page.fill(emailID, appUsername);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if (page.isVisible(LogoutLink)) {
			System.out.println("user is successfully logged in");
			return true;
		}
		return false;

	}
	
	public boolean validateComponentsVisibleOptions() {
		
	//	page.locator(Componentslink).hover();
		page.hover(Componentslink);
		boolean disabled = page.locator(CompeonentOptions).isDisabled();
		return disabled;
		
		
	}
	
	public List<String> printComponentOptions() {
		page.hover(Componentslink);
		List<String> allOption = page.locator(CompeonentOptions).allTextContents();
	//	allOption.forEach(e->System.out.println(e));
		ArrayList<String> liString=new ArrayList<String>();
		for (String string : allOption) {
			liString.add(string);
			
		}
		
		return liString;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
