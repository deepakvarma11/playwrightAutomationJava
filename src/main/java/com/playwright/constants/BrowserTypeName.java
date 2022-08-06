package com.playwright.constants;

import com.playwright.utils.PropertyReader;

public enum BrowserTypeName {
	CHROMIUM, EDGE, CHROME;

	public String readBrowserName() {
		return PropertyReader.readProperty(getPropertyName());
	}

	public String getPropertyName() {
		return name().toLowerCase();
	}
}
