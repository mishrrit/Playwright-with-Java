package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelectors {

    public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();

	page.navigate("https://orangehrm.com/en/30-day-free-trial");

	page.locator("text=Privacy Policy").first().click();
	Locator links = page.locator("text=Privacy Policy");

	for (int i = 0; i < links.count(); i++) {
	    String text = links.nth(i).textContent();
	    if (text.contains("Service Privacy Policy")) {
		links.nth(i).click();
		break;
	    }
	}

	page.close();
	context.close();
	browser.close();

    }

}
