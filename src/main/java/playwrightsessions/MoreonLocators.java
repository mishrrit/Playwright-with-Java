package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/*
 * using has-text or text 
 */
public class MoreonLocators {

    public static void main(String[] args) {
	
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();
	
	page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	page.locator("#input-email").fill("admin");
	page.locator("#input-password").fill("password");
	
	//using parent tag and has-text
	page.locator("form input:has-text('Login')").click();
	
	//using directly text tag
	page.locator("text =Continue").click();
	
    }

}
