package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constaants.AppConstants;

public class HomePageTest extends BaseTest{
	
	@Test
	public void homepageTitleTest() {
		String actualTitle = hp.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOMEPAGE_TITLE);
	}

	@Test
	public void homepageUrlTest() {
		String actualUrl = hp.getHomepageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	@Test(dataProvider="getProductData")
	public void searchProduct(String productName) {
		String doSearch = hp.doSearch(productName);
		Assert.assertEquals(doSearch, "Search - "+productName);
		
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Redmi"},
			{"Samsung"},
			{"Micromax"}
			
		};

	}
	
	
	

}
