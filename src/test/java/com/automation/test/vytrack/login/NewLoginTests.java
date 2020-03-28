package com.automation.test.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.test.vytrack.TestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends TestBase {
    /**
     * Login and verify that page title is a "Dashboard"
     */


    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");

    }
}
