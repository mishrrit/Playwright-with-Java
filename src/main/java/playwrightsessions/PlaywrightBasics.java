package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

    public static void main(String[] args) {
	
	//starting playwright server
	Playwright playwright = Playwright.create();
	
	//Running webkit browser in head mode(setHeadless(false))
	//Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	//Running chromium browser in head mode(setHeadless(false))
	// Browser browser = playwright.chromium().launch(new
	// BrowserType.LaunchOptions().setHeadless(false));
	
	//Running chromium browser in head mode(setHeadless(false))
	// Browser browser = playwright.fireox().launch(new
	// BrowserType.LaunchOptions().setHeadless(false));
	
	
	//Running Chrome
	LaunchOptions lp = new LaunchOptions();
	lp.setChannel("chrome");//same could be done for msedge using chromium
	lp.setHeadless(false);
	Browser browser = playwright.chromium().launch(lp);
	
	//Firefox Browser
	//lp.setChannel("firefox");
	//Browser browser = playwright.firefox().launch(lp);
	
	Page page = browser.newPage();
	page.navigate("https://www.amazon.com");

	String title = page.title();
	System.out.println("Page Title is " + title);

	String url = page.url();
	System.out.println("URL is " + url);

	browser.close();
	playwright.close();

    }

}
