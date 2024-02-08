package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {

    public static void main(String[] args) {

	Playwright playwright = Playwright.create();

	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();

	page.navigate("https://books-pwakit.appspot.com/");

	// Page --DOM --Shadow DOM -->Elements
	page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing");
	String captureText = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
	System.out.println(captureText);

	Page page1 = context.newPage();

	// Page --DOM --iFrame -- Shadow DOM -->Elements
	page1.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
	page1.frameLocator("#pact").locator("#snacktime #tea").fill("Ginger Sugarless Tea");
	System.out.println(page1.title());
	

    }

}
