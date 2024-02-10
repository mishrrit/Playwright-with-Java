package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUp {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Opening a window pop and handle the title of the pop up page
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Page popUp = page.waitForPopup(() -> {
            page.click("a[href=\"https://twitter.com/orangehrm?lang=en\"]");
        });

        System.out.println("New Page Title is : " + popUp.url());

        System.out.println("Parent page title is: " + page.title());

        // Opening a new tab in the same window and enter the url manually
        Page blankPopUp = page.waitForPopup(() -> {
            page.click("a[target=\"_blank\"]");
        });
        blankPopUp.waitForLoadState();
        blankPopUp.navigate("https://www.google.com");
        System.out.println("Google Page Title is : " + blankPopUp.url());


        //shut down the browser
        blankPopUp.close();
        page.close();
        popUp.close();
        context.close();
        playwright.close();

    }

}
