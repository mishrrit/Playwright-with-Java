package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

/*
 * mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://academy.naveenautomationlabs.com/"
 * It enables you to generate code, more like record and play
 * 
 * debugging Options: Add an environment variable in the runtime configuration as PWDEBUG : 1
 * Or, using page.pause(); and continue debugging.
 * 
 * 
 */

public class CodeGenExample {

    public static void main(String[] args) {
	try (Playwright playwright = Playwright.create()) {
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context = browser.newContext();
	    
	    
	    Page page = context.newPage();
	    page.navigate("https://academy.naveenautomationlabs.com/");
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
	    page.frameLocator("#microfe-popup-login")
		    .getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Continue with email"))
		    .click();
	    
	    //Adding a debugger 
	    page.pause();
	    
	    page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
	    page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("test@email.com");
	    page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
	    page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("password");
	    page.frameLocator("#microfe-popup-login")
		    .getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
	}
    }

}
