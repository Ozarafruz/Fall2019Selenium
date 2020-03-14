package com.automation.test.day8_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {


        //runs only once before @BeforeClass and @BeforeMethod
        @BeforeTest
        public void beforeTest(){
            System.out.println("BEFORE TEST");
        }

        //runs only once after @AfterClass after @AfterMethod
        @AfterTest
        public void afterTest(){
            System.out.println("AFTER TEST");
        }

    //Runs only once in the class before @BeforeMethod and before any test
    //regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    //something that should be done  only once in the class before all tests
    @AfterClass
    public void AfterClass(){
        System.out.println("AFTER CLASS");
    }

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
