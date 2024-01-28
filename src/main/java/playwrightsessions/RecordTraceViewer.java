package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

/*
 * Tracing allows you to trace meta data,api,events ,etc under a zip file.
 * Once run, the trace.zip file is created
 * There are 2 ways to view the trace:
 * 1. Using browser
 * Drop your trace file here: https://trace.playwright.dev/
 * 2. Using cmd
 * mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
 */

public class RecordTraceViewer {

    public static void main(String[] args) {
	try (Playwright playwright = Playwright.create()) {
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context = browser.newContext();

	    // Start tracing before creating / navigating a page.
	    context.tracing()
		    .start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

	    Page page = context.newPage();
	    page.navigate("https://devon.greythr.com/uas/portal/auth/login");
	    page.navigate("https://devon.greythr.com/");
	    page.navigate(
		    "https://devon.greythr.com/uas/portal/auth/login?login_challenge=41d3c3bf77e94028b4abed15a2518d2b");
	    page.getByPlaceholder("Employee No").click();
	    page.getByPlaceholder("Employee No").fill("691");
	    page.getByPlaceholder("Password").click();
	    page.getByPlaceholder("Password").fill("password");
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

	    // Stop tracing and export it into a zip archive.
	    context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
	    context.close();
	    browser.close();
	    playwright.close();
	}
    }

}
