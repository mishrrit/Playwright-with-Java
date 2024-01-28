package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/*
  BrowserContext allows user to open multiple sessions of a browser i.e. browser context inside a single test.
  BrowserContexts provide a way to operate multiple independent browser sessions. 
  If a page opens another page, e.g. with a window.open call, the popup will belong to the parent page's browsercontext.
  Playwright allows creating "incognito" browser contexts with Browser.newContext() method."Incognito" browser contexts don't write any browsing data to disk. 

 */

public class BrowserContextConcept {

    public static void main(String[] args) {
	try (Playwright playwright = Playwright.create()) {
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

	    // Browser Context 1
	    BrowserContext context1 = browser.newContext();
	    Page page1 = context1.newPage();
	    page1.navigate("https://www.google.co.in/");
	    System.out.println(page1.title());

	    // Browser Context 2
	    BrowserContext context2 = browser.newContext();
	    Page page2 = context2.newPage();
	    page2.navigate("https://orangeHRM.com/");
	    System.out.println(page2.title());

	    // Browser Context 3
	    BrowserContext context3 = browser.newContext();
	    Page page3 = context3.newPage();
	    page3.navigate("https://youtube.com/");
	    System.out.println(page3.title());
	    
	    page1.close();
	    context1.close();
	    
	    page2.close();
	    context2.close();
	    
	    page3.close();
	    context3.close();
	    

	}

    }

}
