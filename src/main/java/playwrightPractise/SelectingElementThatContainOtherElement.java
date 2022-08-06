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

public class SelectingElementThatContainOtherElement {

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
		page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");
		Locator count = page.locator("select#Form_submitForm_Country:has(option[value='India'])");
		
		count.allInnerTexts().forEach(e -> System.out.println(e));
	}

	@AfterClass
	public void close() {
		page.close();
		browser.close();
		play.close();
	}

}
