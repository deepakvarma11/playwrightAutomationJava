package com.playwright.pagecomponents;

import com.microsoft.playwright.Page;
import com.playwright.pagecomponent.SearchResultContentComponent;

public class SearchResultContainerComponents {

	private Page page;

	public SearchResultContainerComponents(Page page) {
		this.page = page;
	}

	private static String searchResultPanel = "div#product-search.container";

	public SearchResultContentComponent getSearchResultContentComponent() {
		return new SearchResultContentComponent(searchResultPanel, page);
	}

}
