package com.automation.officeHour;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OH_03_25_2020_iframe {

    private WebDriver driver;

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");

        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));

        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */

        for (WebElement each : frameList){
            driver.switchTo().frame(each);
            String bodyText = driver.findElement(By.tagName("body")).getText();
        }

         /*
        Iframe - webdocument inside of other webdocument (html inside of html doc)
     */

    }
}
class iframePractice{

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        Thread.sleep(2000);
        //we landed to red webdocument - default content
        driver.switchTo().frame("frame-top");
        //we are landed to blue web-doc
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop to get index for each frame
            2. swithch to each frame
                a. get test from body
                b. switch to parent - just so you are able to switch to next frame in next iteration
         */
        for (int i = 0; i<frameList.size(); i++){
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent(); //will always take you to the main html - default (red in the schema)
        driver.switchTo().frame("frame-bottom"); // switched to bottom frame
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);
        driver.switchTo().defaultContent(); //switch back to default after you finished your iteraction with frame content
    }
}



