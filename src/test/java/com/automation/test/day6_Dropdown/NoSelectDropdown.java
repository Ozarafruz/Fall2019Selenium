package com.automation.test.day6_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(1000);

        driver.findElement(By.id("dropdownMenuLink")).click();//to expand dropdown
        Thread.sleep(1000);

        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>


        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText()+" : "+eachLink.getAttribute("href"));
        }

        driver.findElement(By.linkText("Amazon")).click();//click on option

        driver.quit();
    }
}
