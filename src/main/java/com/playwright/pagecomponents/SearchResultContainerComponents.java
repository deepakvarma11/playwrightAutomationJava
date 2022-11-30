package com.playwright.pagecomponents;

import com.microsoft.playwright.Page;
import com.playwright.pagecomponentpanels.SearchResultContentPanel;

public class SearchResultContainerComponents {

	private Page page;

	public SearchResultContainerComponents(Page page) {
		this.page = page;
	}

	private static final String SEARCH_RESULT_PANEL = "div#product-search.container";

	public SearchResultContentPanel getSearchResultContentPanel() {
		return new SearchResultContentPanel(SEARCH_RESULT_PANEL, page);
	}

}
