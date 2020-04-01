package com.automation.test.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.test.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {
    /**
     * Login and verify that page title is a "Dashboard"
     */


    @Test
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        test = report.createTest("Verify page title");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //Like System.out, but it goes to report as well
        test.info("Login as store manager");//log some steps

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        //if assertion passed, it will set the test status in report to passed
        test.pass("Page title Dashboard was verified");
    }

    /**
     * Enter wrong credentials and verify warning message
     */
    @Test
    public void verify(){
        test = report.createTest("Verify warning message");

        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");

        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");

        //take a screenshot
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning message is displayed");
    }
}
