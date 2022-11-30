package com.playwright.pagecomponentpanels;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class SearchResultContentPanel extends AbstractPanel {

	private Page page;

	private static final String SEARCH_PAGE_HEADER = "div#content h1";
	private static final String SEARCH_ITEMS_COMPONENT = "//div[contains(@class,'product-layout')]";

	public SearchResultContentPanel(String component, Page page) {
		super(component, page);
		this.page = page;
	}

	public SearchResultItemsPanel getSearchResultItemsComponent() {
		return new SearchResultItemsPanel(SEARCH_ITEMS_COMPONENT, page);
	}

	public String getSearchHeaderText() {
		findElement(SEARCH_PAGE_HEADER).waitFor();
		return getText(SEARCH_PAGE_HEADER);
	}

	public List<ElementHandle> getResultItems() {
		findElement(SEARCH_ITEMS_COMPONENT).waitFor();
		return findElements(SEARCH_ITEMS_COMPONENT);
	}

}
