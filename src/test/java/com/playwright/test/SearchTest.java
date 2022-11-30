package com.playwright.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.playwright.base.test.BaseTest;

public class SearchTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		homePage.navigateToHomePage();
		assertEquals(homePage.getHomePageTitle(), "Your Store");
	}

	@DataProvider(name = "doSearchProduct")
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "Iphone" }, { "Samsung" } };
	}

	@Test(dataProvider = "doSearchProduct")
	public void searchItem(String item) {
		homePage.doSearch(item);
		assertEquals(resultPage.getSearchHeaderText(), "Search - " + item);
	}

}
