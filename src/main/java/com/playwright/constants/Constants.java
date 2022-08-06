package com.playwright.constants;

import com.playwright.utils.PropertyReader;

public enum Constants {

	URL, HEADLESS, BROWSER;

	public String readProperty() {
		return PropertyReader.readProperty(getPropertyName());
	}

	public String getPropertyName() {
		return name().toLowerCase();
	}

}
