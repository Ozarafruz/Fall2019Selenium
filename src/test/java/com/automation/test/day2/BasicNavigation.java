package com.automation.test.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {
        //to start selenium script we need :
        //setup webDriver (browser driver) and create webDriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
      //  RemoteWebDriver driver = new SafariDriver();
        //In selenium, everything starts from WebDriver interface
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");//to open a website

        Thread.sleep(3000); //for demo, ait 3 seconds
        //method that return page title
        //you can also see it as tab name, in the browser

        String title = driver.getTitle();// returns <title>Some titile</title> text

        String expectedTitle = "Google";

        System.out.println("title = " + title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //MUST BE AT THE END
        driver.close();//to close browser
        //browser cannot cole itself






    }
}
