package com.playwright.constants;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public enum BrowserFactory {

	CHROMIUM {
		@Override
		public Browser initialize(Playwright playwright) {
			// TODO Auto-generated method stub
			return playwright
					.chromium()
					.launch(new BrowserType
							.LaunchOptions()
							.setHeadless(headless));
		}
	},
	EDGE {
		@Override
		public Browser initialize(Playwright playwright) {
			// TODO Auto-generated method stub
			return playwright
					.chromium()
					.launch(new BrowserType
							.LaunchOptions()
							.setChannel(BrowserChannel.MSEDGE.getValue())
							.setHeadless(headless));
		}
	},
	CHROME {
		@Override
		public Browser initialize(Playwright playwright) {
			// TODO Auto-generated method stub
			return playwright
					.chromium()
					.launch(new BrowserType
							.LaunchOptions()
							.setChannel(BrowserChannel.CHROME.getValue())
							.setHeadless(headless));
		}
	};

	public abstract Browser initialize(Playwright playwright);

	boolean headless = Constants.HEADLESS.readProperty().toString().equals("true") ? true : false;

}
