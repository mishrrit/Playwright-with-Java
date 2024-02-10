package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {
    static Page page;

    public static void main(String[] args) {

	Playwright playwright = Playwright.create();

	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	page = context.newPage();

	page.navigate("https://selectorshub.com/xpath-practice-page/");
	String userName1 = "Joe.Root";
	String userName2 = "John.Smith";
	
	
	selectUser("Joe.Root");
	selectUser("Jasmine.Morgan");
	
	
	System.out.println("User Role of "+userName1+" : "+getUserRole(userName1));
	System.out.println("User Role of "+userName2+" : "+getUserRole(userName2));
	
	//Using above
	System.out.println("UserName above of "+userName1+" is "+ getUserName(userName1));
	System.out.println("UserName above of "+userName2+" is "+ getUserName(userName2));
	
	
	Locator nearElements = page.locator("td:near(:text('Joe.Root'),100)");
	List<String> nearElementText = nearElements.allInnerTexts();
	
	nearElementText.forEach(e -> System.out.println(e));
	
	page.close();

    }

    public static void selectUser(String userName) {
	//using left-of
	page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
    }

    public static String getUserRole(String userName) {
	//Using right-of
	return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
    }
    
    public static String getUserName(String userName) {
	//Using near and similarly it can be used for below
	return page.locator("a:above(:text('" + userName + "'))").first().textContent();
		
    }
}
