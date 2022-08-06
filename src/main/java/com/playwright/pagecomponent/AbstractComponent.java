package com.playwright.pagecomponent;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class AbstractComponent {

	private Locator component;
	private Page page;

	public AbstractComponent(String component, Page page) {
		this.component = page.locator(component);
		this.page = page;
	}
	
	public AbstractComponent(Page page) {
		this.page = page;
	}

	public Locator findElement(String webElement) {
		return component.locator(webElement);
	}

	public List<ElementHandle> findElements(String webElement) {
		return page.querySelectorAll(webElement);
	}

}
