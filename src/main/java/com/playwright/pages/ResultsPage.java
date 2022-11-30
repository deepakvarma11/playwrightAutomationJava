package com.playwright.pages;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.playwright.pagecomponents.SearchResultContainerComponents;

public class ResultsPage extends BasePage {

	private Page page;
	private SearchResultContainerComponents searchResultContainerComponents;

	public ResultsPage(Page page) {
		super(page);
		this.page = page;
		searchResultContainerComponents = new SearchResultContainerComponents(page);
	}

	public String getSearchHeaderText() {
		return searchResultContainerComponents.getSearchResultContentPanel().getSearchHeaderText();
	}

	public List<ElementHandle> getResultItems() {
		return searchResultContainerComponents.getSearchResultContentPanel().getResultItems();
	}

	public void selectProduct(final String productName) {
		searchResultContainerComponents
				.getSearchResultContentPanel().getSearchResultItemsComponent().selectProduct(productName);
	}

}
