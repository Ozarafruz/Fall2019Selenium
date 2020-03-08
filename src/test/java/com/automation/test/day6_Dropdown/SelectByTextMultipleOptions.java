package com.automation.test.day6_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        Thread.sleep(1000);

        Select languageSelect = new Select(driver.findElement(By.name("Languages")));
        //Whether this select element support selecting multiple options at the same time? This
//                is done by checking the value of the "multiple" attribute.
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple);//if it's true, you can select more than one option


        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");


        List<WebElement> selectLanguages = languageSelect.getAllSelectedOptions();

        for (WebElement selectLanguage : selectLanguages) {
            System.out.println(selectLanguage.getText());
        }





         driver.quit();

    }
}
