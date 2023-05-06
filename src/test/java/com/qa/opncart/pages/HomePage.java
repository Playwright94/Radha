package com.qa.opncart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	//private String locators
	
	private String search="//input[@name='search']";
	
	private String searchIcon="//span[@class='input-group-btn']/button";
	
	private String searchPageHeader="//div[@id='content']/h1";
	private String loginLink = "//a[text()='Login']";
	
	private String myAccountLink="//span[text()='My Account']";
	
	
	
	
	
	
	//constructor
	public HomePage(Page page) {
		this.page=page;
		
	}
	
	//page actions
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("the title of the page is::"+title);
		
		return title;

	}
	public String getHomepageUrl() {
		String url = page.url();
		System.out.println("the url of the page is::"+url);
		return url;

	}
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		
		String textContent = page.textContent(searchPageHeader);
		
		System.out.println("the searched content is  "+textContent);
		//return page.textContent(searchPageHeader);
		return textContent;

	}
	
	public LoginPage navigateToLogin() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
		
		
	}
	
	

}
