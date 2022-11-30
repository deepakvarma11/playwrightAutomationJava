package com.playwright.pages;

import java.io.File;
import java.nio.file.Paths;

import com.microsoft.playwright.Page;
import com.playwright.constants.Constants;
import com.playwright.pagecomponentpanels.AbstractPanel;

public class BasePage extends AbstractPanel {

	protected Page page;

	BasePage(Page page) {
		super(page);
		this.page = page;
	}

	public void captureScreenshot(String file) {
		String fileName = System.getProperty("user.dir") 
				+ File.separator + Constants.REPORTPATH.readProperty()
				+ File.separator + "screenshots" + File.separator + file + ".png";
		page.screenshot(new Page
				.ScreenshotOptions()
				.setPath(Paths.get(fileName))
				.setFullPage(true));
	}

}
