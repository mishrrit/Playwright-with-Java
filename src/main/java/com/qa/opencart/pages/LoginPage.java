package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String email = "input[name='email']";
    private String password = "input[name='password']";
    private String loginButton = "input[value='Login']";
    private String forgottenPasword = "a:text('Forgotten Password')";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        String title = page.title();
        System.out.println("Page title is :" + title);
        return title;
    }

    public AccountsPage login(String email, String password) {
        page.fill(this.email, email);
        page.fill(this.password, password);
        page.click(this.loginButton);
        System.out.println("Logged in successfully");
        return new AccountsPage(page);
    }

    public boolean forgotPassword() {
        return page.isVisible(forgottenPasword);
    }

}
