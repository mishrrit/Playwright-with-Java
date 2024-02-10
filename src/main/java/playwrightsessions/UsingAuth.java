package playwrightsessions;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UsingAuth {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        /**
         * Creates a new browser context with persistent storage.
         * 
         * The storage state will be saved to the provided path,
         * so that user sessions can persist across multiple runs.
         */
        BrowserContext context = browser
                .newContext(new Browser.NewContextOptions().setStorageStatePath((Paths.get("applogin.json"))));

        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(page.title());  
        page.close();    
    }
    
}

