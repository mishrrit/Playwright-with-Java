package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {

    public static void main(String[] args) {
	Playwright playwright = Playwright.create();

	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();

	page.navigate("https://www.amazon.in/");
	
	//Using Visible tag
	List<String> allLinks = page.locator("a:visible").allInnerTexts();
	
	for(int i=0;i<allLinks.size();i++) {
	    System.out.println(allLinks.get(i));
	}
	
	//Using Xpath
	int allImages = page.locator("xpath = //img >>visible=true").count();
	System.out.println(allImages);
	
	
    }

}
