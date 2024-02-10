package playwrightsessions;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");

        /**
         * Waits for a download to start, then returns the Download object.
         * Clicks on the link to trigger the download before waiting.
         */
        Download download = page.waitForDownload(() -> {
            page.click("text=chromedriver_win32.zip");
        });
        //download.cancel();
        System.out.println(download.failure());
        System.out.println(download.url());
        download.saveAs(Paths.get("ritesh_chrome_driver.zip"));

        System.out.println(download.suggestedFilename());
        

}
}