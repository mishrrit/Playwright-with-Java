package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicLocator {
    
    public static void main(String[] args) {
    
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        
        Page page = context.newPage();
        page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

        Locator row = page.locator("table#example tr");
        row.locator(":scope",new Locator.LocatorOptions()
            .setHasText("Ashton Cox"))
            .locator(".select-checkbox")
            .click();
        
        // Get the inner text for all the elements in the table
        row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));

        //Angular based application with dynamic tables
        Page dyPage = context.newPage();
        dyPage.navigate("https://primeng.org/");

        Locator dyrow = dyPage.locator("//table[@role='table']//tr");
        dyrow.locator(":scope",new Locator.LocatorOptions()
            .setHasText("James Butt"))
            .locator(".p-checkbox-box")
            .click();
        
        dyrow.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));

    }
}
