package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    // 1. Locators
    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String loginLink = "a:text('Login')";
    private String myAccountLink = "a[title='My Account']";

    // 2. Constructor
    public HomePage(Page page) {
        this.page = page;
    }

    // 3. Methods
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Page title is :" + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("Page URL is :" + url);
        return url;
    }

    public String searchProduct(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        return page.locator(searchPageHeader).innerText();
    }

    public LoginPage navigatetoLoginPage() {
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }

}
