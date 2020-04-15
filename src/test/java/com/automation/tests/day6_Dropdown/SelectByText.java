package com.automation.tests.day6_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(3000);

        //create a webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide weblement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        Thread.sleep(3000);
        //and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectDay = new Select(driver.findElement(By.id("day")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectYear = new Select(driver.findElement(By.id("year")));

        selectDay.selectByVisibleText("25");
        selectYear.selectByVisibleText("2005");
        selectMonth.selectByVisibleText("February");


        Thread.sleep(1000);

        //select all months one by one
        //.getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth : months){
            //get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            Thread.sleep(1000);
        }


        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        //option that is currently selected
        //getFirstSelectOption() -- returns a webElement, that's why we need to call getText()
        //getText() retrieves visible text from the webElement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        List<WebElement> states = stateSelect.getOptions();

        for (WebElement stateOption : states) {
            System.out.println(stateOption.getText());
        }



        driver.quit();
    }
}
