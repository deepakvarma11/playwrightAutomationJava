package playwrightPractise;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class Test01 {

	Playwright play;
	Browser bro;
	Page page;

	@Test(priority = 0)
	public void setup() {
		play = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		bro = play.chromium().launch(lp);
//		bro = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
		page = bro.newPage();
	}

	@Test(priority = 1)
	public void test1() {

		page.navigate("https://www.google.co.in/");

		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println(page.title());

		page.locator("xpath = //input[@name='q']").fill("Deepak varma");

		page.pause();

		// Click [aria-label="Search"]
		page.locator("[aria-label=\"Search\"]").click();
		// Press Enter
		// page.waitForNavigation(new
		// Page.WaitForNavigationOptions().setUrl("https://www.google.co.in/search?q=Deepak+varma&source=hp&ei=mRiJYoueD9OAmAWTy5ugDA&iflsig=AJiK0e8AAAAAYokmqYEJA1h5wvUjaWqPETmLT8XnvWrq&ved=0ahUKEwjLzuHchvH3AhVTAKYKHZPlBsQQ4dUDCAc&uact=5&oq=Deepak+varma&gs_lcp=Cgdnd3Mtd2l6EAMyCwguEIAEEMcBEK8BMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIGCAAQHhAWMgYIABAeEBYyCAgAEB4QFhAKMgYIABAeEBYyBggAEB4QFlAAWABghowBaAFwAHgAgAHEAYgBxAGSAQMwLjGYAQCgAQE&sclient=gws-wiz"),
		// () ->
		page.waitForNavigation(() -> {
			page.locator("[aria-label=\"Search\"]").press("Enter");
		});
		// assertThat(page).hasURL("https://www.google.co.in/search?q=Deepak+varma&source=hp&ei=mRiJYoueD9OAmAWTy5ugDA&iflsig=AJiK0e8AAAAAYokmqYEJA1h5wvUjaWqPETmLT8XnvWrq&ved=0ahUKEwjLzuHchvH3AhVTAKYKHZPlBsQQ4dUDCAc&uact=5&oq=Deepak+varma&gs_lcp=Cgdnd3Mtd2l6EAMyCwguEIAEEMcBEK8BMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIGCAAQHhAWMgYIABAeEBYyCAgAEB4QFhAKMgYIABAeEBYyBggAEB4QFlAAWABghowBaAFwAHgAgAHEAYgBxAGSAQMwLjGYAQCgAQE&sclient=gws-wiz");
		// Click [aria-label="Search"]
		page.locator("[aria-label=\"Search\"]").click();
		// Fill [aria-label="Search"]
		page.locator("[aria-label=\"Search\"]").fill("Deepak varma battini");
		// Press Enter
		// page.waitForNavigation(new
		// Page.WaitForNavigationOptions().setUrl("https://www.google.co.in/search?q=Deepak+varma+battini&ei=sxiJYsqbHtCiseMP1MG-4Ao&ved=0ahUKEwiKwaPphvH3AhVQUWwGHdSgD6wQ4dUDCA4&uact=5&oq=Deepak+varma+battini&gs_lcp=Cgdnd3Mtd2l6EAMyBwghEAoQoAEyBwghEAoQoAEyBwghEAoQoAEyBwghEAoQoAE6DgguEMcBEK8BELADEJECOgkIABAeELADEAc6CAgAEIAEELADOgUIABCABDoGCAAQHhAWOgQIABANOgoILhDHARCvARANOgYIABAeEA06AggmOgQIIRAVOgUIIRCgAUoECEEYAUoECEYYAFDHBljbFGDkGmgBcAB4AIABlgOIAcwQkgEJMC4zLjIuMi4xmAEAoAEByAEKwAEB&sclient=gws-wiz"),
		// () ->
		page.waitForNavigation(() -> {
			page.locator("[aria-label=\"Search\"]").press("Enter");
		});

		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("google.jpg")));
	}

	@Test(priority = 2)
	public void close() {
		bro.close();
		play.close();
	}

}
