package playwrightsessions;

import java.awt.Toolkit;
import java.awt.Dimension;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserSize {

    public static void main(String[] args) {
        /**
         * Gets the screen size of the display using the Toolkit class.
         * width and height are set to the width and height of the screen.
         */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));

        Page page = context.newPage();
        page.navigate("https://www.amazon.in");

    }
}
