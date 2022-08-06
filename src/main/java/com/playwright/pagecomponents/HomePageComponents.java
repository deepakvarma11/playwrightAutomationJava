package com.playwright.pagecomponents;

import com.microsoft.playwright.Page;
import com.playwright.pagecomponent.HeaderBarComponent;
import com.playwright.pagecomponent.SearchResultItemsComponent;

public class HomePageComponents {

	Page page;
	private static String headerBar = "header .row";

	public HomePageComponents(Page page) {
		this.page = page;
	}

	public HeaderBarComponent getHeaderBar() {
		return new HeaderBarComponent(headerBar, page);
	}

}
