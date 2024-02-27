package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.constants.AppConstants;
import com.qa.opencart.base.BaseTest;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void testTitle() {
        String title = hp.getHomePageTitle();
        Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void testURL() {
        String url = hp.getHomePageURL();
        Assert.assertEquals(url, prop.getProperty("url").trim());
    }

    @DataProvider
    public Object[][] getproductData() {
        return new Object[][] {
                { "Macbook" },
                { "iMac" },
                { "iPhone" }
        };

    }

    @Test(priority = 3, dataProvider = "getproductData")
    public void testSearchProduct(String productName) {
        String searchResult = hp.searchProduct(productName);
        Assert.assertEquals(searchResult, "Search - " + productName);
    }

}
