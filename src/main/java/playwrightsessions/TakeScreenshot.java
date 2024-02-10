package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TakeScreenshot {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://naveenautomationlabs.com/opencart/");

        // fullPage: true - full page or else only visible screenshot is captured
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("myscreens/VisibleScreen.png"))
                .setFullPage(false));

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("myscreens/FullScreen.png"))
                .setFullPage(true));

        page.locator("img[title='MacBook']")
                .screenshot(new ScreenshotOptions().setPath(Paths.get("myscreens/singleElement.png")));
        page.locator("div#content div.row")
                .screenshot(new ScreenshotOptions().setPath(Paths.get("myscreens/section.png")));
        
        page.close();
        context.close();
        playwright.close();
    }

}
