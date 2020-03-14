package com.automation.test.day8_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNGTests {

    //RUNS BEFORE EVERY TEST AUTOMATICALLY
    //WORKS AS A pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }
    //Runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }


@Test
public void test1(){

    System.out.println("TEST1");
    String expected = "apple";
    String actual = "apple";
    Assert.assertEquals(actual,expected);
}
@Test
public void test2(){

    System.out.println("TEST2");
    int num1 = 5 ;
    int num2 =10 ;
     //it calls hard assertion
    //if assertion fails - it stop the execution (due to exception)
    Assert.assertTrue(num1<num2);
}

}
