package com.playwright.pagecomponentpanels;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public abstract class AbstractPanel {

	private Locator component;
	private Page page;

	public AbstractPanel(final String component, Page page) {
		this.component = page.locator(component);
		this.page = page;
	}

	public AbstractPanel(Page page) {
		this.page = page;
	}

	public void navigateTo(final String url) {
		page.navigate(url);
	}

	public String getTitle() {
		return page.title();
	}

	public String getUrl() {
		return page.url();
	}

	public Locator findElement(final String webElement) {
		return component.locator(webElement);
	}

	public List<ElementHandle> findElements(final String webElement) {
		return page.querySelectorAll(webElement);
	}

	public void waitForLoadState() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public String getText(final String webElement) {
		return findElement(webElement).textContent();
	}

	public void click(final String webElement) {
		findElement(webElement).click();
	}

	public void enterText(final String webElement, final String text) {
		findElement(webElement).fill(text);
	}

}
