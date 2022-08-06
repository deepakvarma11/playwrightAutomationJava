package com.playwright.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.playwright.pages.HomePage;
import com.playwright.pages.ResultsPage;
import com.playwright.utils.BrowserClass;

public class BaseTest {

	protected HomePage homePage;
	protected ResultsPage resultPage;
	protected Page page;

	protected BaseTest() {
	}

	@BeforeTest
	public void setup() {
		page = BrowserClass.initBrowser();
		homePage = new HomePage(page);
		resultPage = new ResultsPage(page);
	}

	@AfterTest
	public void tearDown() {
		BrowserClass.quitBrowser(page);
	}
}
