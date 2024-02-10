package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElements {

    public static void main(String[] args) {

	Playwright playwright = Playwright.create();

	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();

	page.navigate("https://www.amazon.in/");
	Locator footer = page.locator("div.navFooterLinkCol:has(a[href ='https://amazon.jobs'])");
	footer.allInnerTexts().forEach(e -> System.out.println(e));

    }

}
