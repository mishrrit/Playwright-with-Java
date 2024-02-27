package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AccountLogOutPage {
    Page page;

    private String AccountLogout = "div#content h1";

    public AccountLogOutPage(Page page) {
        this.page = page;

    }

    public String getAccountLogOutPageTitle() {
        return page.title();
    }

    public String getAccountLogOutPageURL() {
        return page.url();
    }

    public boolean AccountLogout() {
        return page.isVisible(AccountLogout);
    }
}
