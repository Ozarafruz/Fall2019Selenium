package com.automation.tests.day6_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(1000);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByIndex(9);//District Of Columbia perhaps
        Thread.sleep(2000);

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);

        List<WebElement> stateLst = stateSelect.getOptions();
        int count = 0;
        for (WebElement eachState: stateLst) {
            count++;
            System.out.println( count + " = " +eachState.getText());
        }



        Thread.sleep(1000);
        driver.quit();
    }
}
