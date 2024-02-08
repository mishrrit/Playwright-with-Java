package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsPopUpHandle {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        
        Page page = context.newPage();
        /**
         * Handles JavaScript dialogs (alert, confirm, prompt) opened by the page.
         * Prints dialog message to console and accepts prompt with input "Hello, How
         * are you?".
         */
        page.onDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            dialog.accept("Hello, How are you?");
            // dialog.dismiss();
        });

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.click("//button[text()='Click for JS Alert']");
        String JSAlertResult = page.textContent("#result");
        System.out.println(JSAlertResult);

        Thread.sleep(1500);
        page.click("//button[text()='Click for JS Confirm']");
        String JSConfirmResult = page.textContent("#result");
        System.out.println(JSConfirmResult);
        Thread.sleep(1500);

        page.click("//button[text()='Click for JS Prompt']");
        String JSPromptResult = page.textContent("#result");
        System.out.println(JSPromptResult);
        Thread.sleep(1500);

        page.close();
        context.close();
        playwright.close();
    
    }
}
