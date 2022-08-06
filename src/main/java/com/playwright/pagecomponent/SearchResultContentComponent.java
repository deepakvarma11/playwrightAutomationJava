package com.playwright.pagecomponent;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class SearchResultContentComponent extends AbstractComponent {

	private Page page;

	public SearchResultContentComponent(String component, Page page) {
		super(component, page);
		this.page = page;
	}

	private String searchPageHeader = "div#content h1";
	private String searchItemsComponent = "//div[contains(@class,'product-layout')]";

	public SearchResultItemsComponent getSearchResultItemsComponent() {
		return new SearchResultItemsComponent(searchItemsComponent, page);
	}

	public String getSearchHeaderText() {
		findElement(searchPageHeader).waitFor();
		return findElement(searchPageHeader).textContent();
	}

	public List<ElementHandle> getResultItems() {
		findElement(searchItemsComponent).waitFor();
		return findElements(searchItemsComponent);
	}

}
