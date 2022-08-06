package com.playwright.utils;

import java.util.Objects;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.constants.BrowserTypeName;
import com.playwright.constants.Browsers;
import com.playwright.constants.Constants;

public final class PlaywrightFactory {

	private PlaywrightFactory() {
	}

	Playwright playwright;
	Browser browser = null;
	BrowserContext browserContext;
	Page page = null;

	public static PlaywrightFactory initialPlayWrightFactory() {
		return new PlaywrightFactory();
	}

	public Page initDriver() {

		String browserName = Constants.BROWSER.readProperty().toUpperCase();

		boolean headless = Constants.HEADLESS.readProperty().toString().equals("true") ? true : false;
		playwright = Playwright.create();

		switch (BrowserTypeName.valueOf(browserName)) {
		case CHROMIUM:
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
			break;
		case EDGE:
			browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setChannel(Browsers.MSEDGE.getValue()).setHeadless(headless));
			break;
		case CHROME:
			browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setChannel(Browsers.CHROME.getValue()).setHeadless(headless));
			break;
		default:
			System.out.println("Browser not found");
			throw new IllegalArgumentException();
		}

		browserContext = browser.newContext();
		page = browserContext.newPage();
		return page;
	}

	public void quit() {
//		page.close();
//		browser.close();
		playwright.close();
	}

}
