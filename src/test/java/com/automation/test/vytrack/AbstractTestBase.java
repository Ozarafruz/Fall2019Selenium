package com.automation.test.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)

    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test ;

    //@Optional - to make parameter Optional
    //if you don't specify it, testing will require to specify this parameter for every test, in xml runner

    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){
        System.out.println("Report name: "+reportName);
        report = new ExtentReports();
        reportName = reportName == null ? "report.html" : reportName;

      //  String reportPath = System.getProperty("user.dir")+"/test-output/report.html";
        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")){
            reportPath = System.getProperty("user.dir")+"\\test-output\\"+reportName;
        }else {
            reportPath = System.getProperty("user.dir")+"/test-output/"+ reportName;
        }
        //is a HTML itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Result");
    }
@AfterTest
    public void afterTest(){
        report.flush(); // to release report

    }


    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        //no failure no screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshotPath);//attach screenshot
            BrowserUtils.wait(5);
            test.fail(iTestResult.getName());//attach test name that failed
            test.fail(iTestResult.getThrowable());//attach console output
        }

        BrowserUtils.wait(2);
        Driver.closeDriver();
    }


}
