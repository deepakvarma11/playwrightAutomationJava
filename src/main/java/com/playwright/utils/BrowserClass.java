package com.playwright.utils;

import com.microsoft.playwright.Page;

public final class BrowserClass {

	private BrowserClass() {
	}

	public static Page initBrowser() {
		return PlaywrightFactory.initialPlayWrightFactory().initDriver();
	}

	public static void quitBrowser(Page page) {
//		PlaywrightFactory.initialPlayWrightFactory().quit();
		page.context().browser().close();
	}

}
