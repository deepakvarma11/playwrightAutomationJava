package com.playwright.pagecomponentpanels;

import com.microsoft.playwright.Page;

public final class HeaderBarPanel extends AbstractPanel {

	private static final String SEARCH = "input[name='search']";
	private static final String SEARCH_BTN = "div#search button";

	public HeaderBarPanel(String component, Page page) {
		super(component, page);
	}

	public void doSearch(final String item) {
		enterText(SEARCH, item);
		click(SEARCH_BTN);
	}

}
