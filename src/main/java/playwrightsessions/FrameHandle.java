package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

    public static void main(String[] args) {

	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();

	page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

	// Using frame locator
	String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
	System.out.println(header);

	// Using Frame
	String header2 = page.frame("main").locator("h2").textContent();
	System.out.println(header2);

	// Using Frame Xpath
	String header3 = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
	System.out.println(header3);

	// IFrame examples
	Page page1 = context.newPage();
	page1.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
	// page.pause();
	page1.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();

	page1.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8").fill("Ritesh");
	System.out.println(page.title());

	// closing pages
	page1.close();
	page.close();

    }

}
