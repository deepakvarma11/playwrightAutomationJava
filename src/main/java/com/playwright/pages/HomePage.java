package com.playwright.pages;

import com.microsoft.playwright.Page;
import com.playwright.constants.Constants;
import com.playwright.pagecomponents.HomePageComponents;

public final class HomePage extends BasePage {

	private Page page;
	private HomePageComponents homePageComponents;

	public HomePage(Page page) {
		super(page);
		this.page = page;
		homePageComponents = new HomePageComponents(page);
	}

	public void navigateToHomePage() {
		navigateTo(Constants.URL.readProperty().toString());
		waitForLoadState();
	}

	public String getHomePageTitle() {
		return getTitle();
	}

	public String getHomePageURL() {
		return getUrl();
	}

	public ResultsPage doSearch(String productName) {
		homePageComponents.getHeaderBarPanel().doSearch(productName);
		return new ResultsPage(page);
	}

}
