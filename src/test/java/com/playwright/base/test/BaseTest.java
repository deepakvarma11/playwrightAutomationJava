package com.playwright.base.test;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.pages.HomePage;
import com.playwright.pages.ResultsPage;
import com.playwright.utils.BrowserManager;

@Listeners(TestListener.class)
public class BaseTest {

	private final Playwright playwright = Playwright.create();
	private final Browser browser = BrowserManager.browser(playwright);
	private final Page page = browser.newPage();

	protected HomePage homePage;
	protected ResultsPage resultPage;

	protected BaseTest() {
	}

	@BeforeClass
	public void setup() {
		homePage = new HomePage(page);
		resultPage = new ResultsPage(page);
	}

	@AfterClass
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}

	@AfterMethod
	public void captureScreenshot(final ITestResult result) {
		ITestNGMethod method = result.getMethod();

		if (ITestResult.FAILURE == result.getStatus()) {
			homePage.captureScreenshot(method.getMethodName());
		}
	}
}
