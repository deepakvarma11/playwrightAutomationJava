package playwrightPractise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frames {

	Playwright play;
	Browser browser;
	Page page;

	@BeforeClass
	public void setUp() {
		play = Playwright.create();
		browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		page = context.newPage();
	}

	@Test(priority = 0)
	public void openSite() {
		page.navigate("http://www.londonfreelance.org/courses/frames/index.html");
		String value = page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(value);

		page.frame("navbar").locator("text=Home").click();
	}

	@Test(priority = 1)
	public void openSite2() {
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		page.locator("img[title='vehicle-registration-forms-and-templates']").click();
		page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8").fill("Deepak varma");
	}

	@AfterClass
	public void close() {
		page.close();
		browser.close();
		play.close();
	}
}
