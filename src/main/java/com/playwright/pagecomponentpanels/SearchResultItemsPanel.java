package com.playwright.pagecomponentpanels;

import com.microsoft.playwright.Page;

public class SearchResultItemsPanel extends AbstractPanel {

	private Page page;

	private static final String PRODUCT_NAME = "//a[text()='%s']";

	public SearchResultItemsPanel(String component, Page page) {
		super(component, page);
		this.page = page;
	}

	public void selectProduct(String productName) {
		click(String.format(PRODUCT_NAME, productName));
		waitForLoadState();
	}

}
