package playwrightPractise;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextLocators {

	Playwright play;
	Browser browser;
	Page page;

	@BeforeClass
	public void setUp() {
		play = Playwright.create();
		browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@Test(priority = 0)
	public void openContactSales() {
		page.navigate("https://www.orangehrm.com/");
		page.locator("text=Contact Sales").click();
		Locator fullName = page.locator("//div[@id='Form_submitForm_FullName_Holder']/label");
		fullName.waitFor();
		assertEquals(fullName.textContent(), "Full Name");
	}

	@Test(priority = 1)
	public void openFreeDemo() {
		page.locator("li:has-text('Book a Free Demo')").click();
		page.locator("h3:has-text('See OrangeHRM in Action')").isVisible();
	}

	@Test(priority = 2)
	public void openAboutUs() {
		page.locator("xpath=img[@class='nav-logo']").click();
		page.locator(" Executive Profile").last().click();
	}

	@AfterClass
	public void close() {
		page.close();
		browser.close();
		play.close();
	}

}
