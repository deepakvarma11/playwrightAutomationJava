package com.playwright.pagecomponent;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.playwright.utils.FormatString;

public class SearchResultItemsComponent extends AbstractComponent {

	private Page page;

	public SearchResultItemsComponent(String component, Page page) {
		super(component, page);
		this.page = page;
	}

	private String productNameXpath = "//a[text()='%s']";

	public void selectProduct(String productName) {
		findElement(FormatString.format(productNameXpath, productName)).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

}
