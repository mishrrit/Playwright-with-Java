package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.fill("//input[@name='username']", "Admin");
        page.fill("//input[@name='password']", "admin123");
        page.click("//button[@type='submit']");

        
        /**
         * Saves the browser context state like cookies and local storage to disk.
         * This allows the state to be restored when the context is created again.
         * The state is saved to the path provided in StorageStateOptions.
         */
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
        
    }

}
