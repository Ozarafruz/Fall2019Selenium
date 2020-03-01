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

        driver.close();//to close browser






    }
}
