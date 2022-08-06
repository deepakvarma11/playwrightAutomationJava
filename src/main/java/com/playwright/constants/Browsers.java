package com.playwright.constants;

public enum Browsers {

	MSEDGE,
	CHROME;
	
	public String getValue() {
		return name().toLowerCase();
	}
}
