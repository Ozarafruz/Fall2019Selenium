package com.automation.tests.day6_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        Thread.sleep(2000);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();//to click on the first button
        Thread.sleep(2000);

        String popUpText = driver.switchTo().alert().getText();
        System.out.println(popUpText);

        driver.switchTo().alert().accept();//to click OK

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //if will fail, because there is a typo ##BUG##
        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected : "+expected);
            System.out.println("Actual : "+actual);
        }
        Thread.sleep(2000);

        //=====================================2nd=====================================//
        System.out.println("TEST #2");
        buttons.get(1).click();//to click on the 2nd button
        Thread.sleep(2000);
        //to click cancel
        driver.switchTo().alert().dismiss(); //result must be : You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected : "+expected2);
            System.out.println("Actual : "+actual2);
        }
        //==========================3rd============================================//
        System.out.println("TEST #3");
        buttons.get(2).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello, World!");
        alert.accept();

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";

        if (actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected : "+expected3);
            System.out.println("Actual : "+actual3);
        }



        Thread.sleep(2000);
        driver.quit();
    }
}
