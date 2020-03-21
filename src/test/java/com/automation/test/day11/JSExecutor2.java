package com.automation.test.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.jar.JarException;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();


    }
    @Test
    public void verifyTitle(){
        String expected = "Practice";
        //we create javaScriptExecutor object by casting webDriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //ExecutorScript - this method executes javaScript code
        //we provide js code as a String
        //return document.title - javaScript code
        //document - represent HTML page
        //.toString() - to avoid additional casting from Object to String
        //String actual = (String) js.executeScript("return document.title"); //1st way
        String actual = js.executeScript("return document.title").toString();// 2nd way


        Assert.assertEquals(actual,expected);

    }

    @Test
    public void clickTest(){

        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        //disable this click action , to perform it with js executor
        //link.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webElement that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        // varargs works as array(int... a)
        //arguments - listed after , coma
        //used index to get specific webElement
        //WebElement arguments = {element,link,link2};
        //from left to right
        js.executeScript("arguments[0].click()",link);
    }






    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();

    }



}
