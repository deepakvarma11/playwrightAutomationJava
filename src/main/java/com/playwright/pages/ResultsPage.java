package com.playwright.pages;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.playwright.pagecomponents.HomePageComponents;
import com.playwright.pagecomponents.SearchResultContainerComponents;

public class ResultsPage {

	private Page page;
	private HomePageComponents homePageComponents;
	private SearchResultContainerComponents searchResultContainerComponents;

	public ResultsPage(Page page) {
		this.page = page;
		homePageComponents = new HomePageComponents(page);
		searchResultContainerComponents = new SearchResultContainerComponents(page);
	}

	public String getSearchHeaderText() {
		return searchResultContainerComponents.getSearchResultContentComponent().getSearchHeaderText();
	}

	public List<ElementHandle> getResultItems() {
		return searchResultContainerComponents.getSearchResultContentComponent().getResultItems();
	}

	public void selectProduct(String productName) {
		searchResultContainerComponents.getSearchResultContentComponent().getSearchResultItemsComponent().selectProduct(productName);
	}

}
