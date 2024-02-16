package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.constants.AppConstants;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginPageNavigation() {
        lp = hp.navigatetoLoginPage();
        String actLoginPageTitle = lp.getLoginPageTitle();
        Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void testForgottenPasswordLinkExists() {
        lp = hp.navigatetoLoginPage();
        Assert.assertTrue(lp.forgotPassword());
    }

    @Test(priority = 3)
    public void testLogin() {
        lp = hp.navigatetoLoginPage();
        ap = lp.login(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        String actAccountPageTitle = lp.getLoginPageTitle();
        Assert.assertEquals(actAccountPageTitle, AppConstants.ACCOUNT_PAGE_TITLE); 
        alp = ap.logout();
        String actLoggedOutPageTitle = alp.getAccountLogOutPageTitle();
        Assert.assertEquals(actLoggedOutPageTitle, AppConstants.ACCOUNT_LOGOUT_PAGE_TITLE);   
    }

    

}
