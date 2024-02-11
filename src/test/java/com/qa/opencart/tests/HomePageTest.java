package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;

public class HomePageTest {

    PlaywrightFactory pf;
    Page page;

    HomePage hp;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        page = pf.initBrowser("chromium");
        hp = new HomePage(page);
    }

    @Test(priority =1 )
    public void testTitle() {
        String title = hp.getHomePageTitle();
        Assert.assertEquals(title, "Your Store");
    }

    @Test(priority = 2)
    public void testURL() {
        String url = hp.getHomePageURL();
        Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/");
    }

    @Test(priority = 3)
    public void testSearchProduct() {
        String productName = "Macbook";
        String searchResult = hp.searchProduct(productName);
        Assert.assertEquals(searchResult, "Search - Macbook");
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }

}
