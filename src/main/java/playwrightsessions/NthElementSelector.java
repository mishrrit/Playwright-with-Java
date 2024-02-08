package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {
    static Page page;
    public static void main(String[] args) {
        
        Playwright playwright = Playwright.create();
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context = browser.newContext();
	    page = context.newPage();

        page.navigate("https://www.bigbasket.com/");
         
        System.out.println(getFooterLink(0));

        System.out.println(getBankOffer(-1));
    }

    public static String getFooterLink(int index) {

        Locator footerLinkLocator = page.locator("div.pr-4 ul li a >> nth="+index);
        return footerLinkLocator.textContent();

    }

    public static String getBankOffer(int index){
        Locator bankOffer = page.locator("div[type='linearcollage'] a >>nth="+index);
        return bankOffer.textContent();
    }
    
}
