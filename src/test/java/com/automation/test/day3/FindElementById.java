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

    String expected = "Welcome to the Secure Area. When you are done click logout below.";

    String actual = driver.findElement(By.tagName("h4")).getText();

    if (expected.equals(actual)){
        System.out.println("TEST PASSED");
    }else {
        System.out.println("TEST FAILED");
    }

    //lets click on Logout button. It looks like a button, but it's actually a link
    //every element with <a> tag is link
    //if you have couple spaces in the text, just use partialLinkedText instead of linkedText
    //linkedText - equals()
    //partialLinkedText- contains() - complete match doesn't required
    //don't put space
   // WebElement logout = driver.findElement(By.linkText("Logout"));
    WebElement logout = driver.findElement(By.partialLinkText("Logout"));


    String href = logout.getAttribute("href");
    String className = logout.getAttribute("class");

    System.out.println(href);
    System.out.println(className);


    logout.click();
    Thread.sleep(2000);

    //lets enter invalid credentials
    driver.findElement(By.name("username")).sendKeys("wrong");
    driver.findElement(By.name("password")).sendKeys("wrong");
    driver.findElement(By.id("wooden_spoon")).click();

    Thread.sleep(2000);

    WebElement errorMessage = driver.findElement(By.id("flash-messages"));

    System.out.println(errorMessage.getText());


    Thread.sleep(2000);
    driver.quit();

}


//


}
