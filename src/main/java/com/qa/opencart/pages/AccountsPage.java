package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AccountsPage {

    Page page;

    private String logout = "//*[@id=\"column-right\"]/div/a[13]";

    public AccountsPage(Page page) {
        this.page = page;
    }

    public String getAccountsPageTitle() {
        System.out.println(page.title());
        return page.title();
    }

    public AccountLogOutPage logout() {
        page.click(logout);
        System.out.println("Logged out successfully");
        return new AccountLogOutPage(page);
    }
}
