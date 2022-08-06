 package com.playwright.pagecomponent;

import com.microsoft.playwright.Page;

public final class HeaderBarComponent extends AbstractComponent {

	private String search = "input[name='search']";
	private String searchbtn = "div#search button";

	public HeaderBarComponent(String component, Page page) {
		super(component, page);
	}

	public void doSearch(final String item) {
		findElement(search).fill(item);
		findElement(searchbtn).click();
	}

}
