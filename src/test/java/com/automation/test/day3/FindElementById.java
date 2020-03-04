package com.automation.test.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

//    WebDriver driver = DriverFactory.createADriver("chrome");
//
public static void main(String[] args) throws Exception{

    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();

    driver.get("http://practice.cybertekschool.com/login");

    //1 short way
    driver.findElement(By.name("username")).sendKeys("tomsmith");
    Thread.sleep(2000);
   // driver.findElement(By.name("password"));

    //2 second way
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("SuperSecretPassword");

    driver.findElement(By.id("wooden_spoon")).click();

    Thread.sleep(2000);

    driver.quit();

}





}
