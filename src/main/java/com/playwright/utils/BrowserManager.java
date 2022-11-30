package com.playwright.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.playwright.constants.BrowserFactory;
import com.playwright.constants.Constants;

public final class BrowserManager {

	private BrowserManager() {
	}

	public static Browser browser(Playwright playwright) {
		return BrowserFactory.valueOf(Constants.BROWSER.readProperty().toUpperCase()).initialize(playwright);
	}

}
