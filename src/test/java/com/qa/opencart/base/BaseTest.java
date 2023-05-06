package com.qa.opencart.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencartFactory.PlaywrightFactory;
import com.qa.opncart.pages.HomePage;
import com.qa.opncart.pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	protected Page page;
	protected HomePage hp;
	protected Properties prop;
	protected LoginPage lp;
	
	@BeforeTest
	public void setup() throws IOException {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		hp = new HomePage(page);

	}
	
	
	@AfterTest
	public void teardown() {
		page.context().browser().close();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
