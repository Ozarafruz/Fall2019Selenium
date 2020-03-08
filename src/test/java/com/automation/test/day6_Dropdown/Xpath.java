package com.automation.test.day6_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        //value can be inside '' or ""
        //if you don't know the tag name, or want to skip tag name, use *
        //for example //*[@onclick='button1()']  | * means any tag name
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        Thread.sleep(3000);

        //==================Button2===============================================

        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();

        WebElement result2 = driver.findElement(By.id("result"));
        System.out.println(result2.getText());

        Thread.sleep(3000);

        //=================Button3=============

        WebElement btn3 = driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        btn3.click();

        WebElement result3 = driver.findElement(By.id("result"));
        System.out.println(result3.getText());

        Thread.sleep(3000);

        //=================Button4=============

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        btn4.click();

        WebElement result4 = driver.findElement(By.id("result"));
        System.out.println(result4.getText());

        Thread.sleep(3000);

        //=================Button3=============

        WebElement btn5 = driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn5.click();

        WebElement result5 = driver.findElement(By.id("result"));
        System.out.println(result5.getText());





        Thread.sleep(1000);
        driver.quit();
    }
}
