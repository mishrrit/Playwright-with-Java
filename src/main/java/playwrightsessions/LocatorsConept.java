package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsConept {

    public static void main(String[] args) {
	
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();
	
	page.navigate("https://orangeHRM.com/");
	
	Locator contactSales = page.locator("#navbarSupportedContent > div.d-flex.web-menu-btn > ul > li:nth-child(2) > a > button");
	int count = contactSales.count();
	System.out.println(count);
	if(contactSales.isVisible()){
	    contactSales.first().click();
	}else {
	   System.out.println("not visible"); 
	}
	
	//multiple elements
	page.navigate("https://orangehrm.com/en/30-day-free-trial");
	Locator countries = page.locator("select#Form_getForm_Country>option");
	System.out.println("Size is "+countries.count());
	
	//1st way of iteration
	for(int i=0;i<countries.count();i++) {
	    System.out.println(countries.nth(i).textContent());
	}
	
	//2nd way of iteration using List
	List<String> optionsTextList = countries.allTextContents();
	for(String e:optionsTextList) {
	    System.out.println(e);
	}
	
	//3rd way of iteration using Lambda Expression
	optionsTextList.forEach(ele -> System.out.println(ele));
	
	page.close();
	context.close();
	browser.close();
	

    }

}
