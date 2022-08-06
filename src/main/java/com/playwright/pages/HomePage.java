package com.playwright.pages;

import com.microsoft.playwright.Page;
import com.playwright.constants.Constants;
import com.playwright.pagecomponents.HomePageComponents;

public final class HomePage {

	private Page page;
	private HomePageComponents homePageComponents;

	public HomePage(Page page) {
		this.page = page;
		homePageComponents = new HomePageComponents(page);
	}
	
	public void navigateToHomePage() {
		page.navigate(Constants.URL.readProperty().toString());
		page.waitForLoadState();
	}

	public String getHomePageTitle() {
		return page.title();
	}

	public String getHomePageURL() {
		return page.url();
	}

	public ResultsPage doSearch(String productName) {
		homePageComponents.getHeaderBar().doSearch(productName);
		return new ResultsPage(page);
	}

}
