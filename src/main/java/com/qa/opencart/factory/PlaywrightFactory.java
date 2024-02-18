package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    Path path;

    /**
     * ThreadLocal variables to store Playwright browser, context, page instances
     * per thread.
     * Using ThreadLocal ensures each thread has its own instance.
     */
    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<Playwright>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<Browser>();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<BrowserContext>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<Page>();

    /**
     * Gets the Playwright instance for the current thread.
     *
     * Gets the Browser instance for the current thread.
     * 
     * Gets the BrowserContext instance for the current thread.
     *
     * Gets the Page instance for the current thread.
     */
    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();
        System.out.println("BrowserName: " + browserName);

        playwright = Playwright.create();
        playwrightThreadLocal.set(playwright);

        switch (browserName.toLowerCase()) {
            case "chromium":
                // browser = playwright.chromium().launch(new
                // BrowserType.LaunchOptions().setHeadless(false));
                browserThreadLocal
                        .set(playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                // browser = playwright.firefox().launch(new
                // BrowserType.LaunchOptions().setHeadless(false));
                browserThreadLocal
                        .set(playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "webkit":
                // browser = playwright.webkit().launch(new
                // BrowserType.LaunchOptions().setHeadless(false));
                browserThreadLocal
                        .set(playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                 //browser = playwright.webkit().launch(new
                 //BrowserType.LaunchOptions().setHeadless(false));
                browserThreadLocal
                        .set(playwright.chromium()
                                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;

            default:
                System.out.println("Browser not supported");
                break;
        }

        /*
         * browserContext = browser.newContext();
         * page = browserContext.newPage();
         * page.navigate(prop.getProperty("url").trim());
         */

        browserContextThreadLocal.set(getBrowser().newContext());

        pageThreadLocal.set(getBrowserContext().newPage());

        getPage().navigate(prop.getProperty("url").trim());

        return getPage();

    }

    /**
     * Initializes properties.
     */
    public Properties init_properties() {

        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";

        getPage().screenshot(new Page.ScreenshotOptions()
            .setPath(Paths.get(path))
            .setFullPage(true));
        return path;
    }
}
