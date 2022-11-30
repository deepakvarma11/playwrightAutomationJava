package com.playwright.pagecomponents;

import com.microsoft.playwright.Page;
import com.playwright.pagecomponentpanels.HeaderBarPanel;

public class HomePageComponents {

	private Page page;
	private static final String HEADER_BAR = "header .row";

	public HomePageComponents(Page page) {
		this.page = page;
	}

	public HeaderBarPanel getHeaderBarPanel() {
		return new HeaderBarPanel(HEADER_BAR, page);
	}

}
