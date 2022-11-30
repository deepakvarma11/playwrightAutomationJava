package com.playwright.constants;

public enum BrowserChannel {
	MSEDGE, CHROME;

	public String getValue() {
		return name().toLowerCase();
	}
}
