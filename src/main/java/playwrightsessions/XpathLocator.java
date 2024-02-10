package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        
        Page page = context.newPage();

         //amazon.in
        page.navigate("https://www.amazon.in/");

        page.locator("//input[@id='twotabsearchtextbox']").fill("macbook pro");

        Locator totalAmazonLinks = page.locator("//a[contains(text(),'Amazon')]");
        System.out.println(totalAmazonLinks.count());

        List<String> amazonLinks = totalAmazonLinks.allInnerTexts();
        for (String e : amazonLinks) {
            System.out.println(e);
        }
        page.close(); 

        //selectors hub
        Page page1 = context.newPage();
        page1.navigate("https://selectorshub.com/xpath-practice-page/");
        //page1.locator("//a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();

        Locator checkBoxes = page1.locator("//table[@id ='resultTable']// input[@type='checkbox']");
        for(int i= 0; i<checkBoxes.count();i++ ){
            checkBoxes.nth(i).click();
        }

        page1.locator("(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
        page1.locator("(//table[@id='resultTable']//input[@type='checkbox'])[position()= 2]").click();
        page1.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
        page1.close();
        

    }

}
