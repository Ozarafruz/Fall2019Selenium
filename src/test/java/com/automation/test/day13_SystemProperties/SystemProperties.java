package com.automation.test.day13_SystemProperties;

import org.testng.annotations.Test;

public class SystemProperties {



    @Test
    public void test(){

        //System.out.println(System.getProperties());
        //System.getProperty("user.dir") + "/pom.xml"
        System.out.println(System.getProperty("user.dir")); ///Users/ozarafruz/IdeaProjects/Fall2019Selenium
        System.out.println(System.getProperty("os.name")); //Mac OS X
        System.out.println(System.getProperty("user.home"));///Users/ozarafruz

        String pathToDownloads = System.getProperty("user.home")+"/Downloads";

        System.out.println(pathToDownloads);///Users/ozarafruz/Downloads


        System.out.println(System.getProperty("os.arch")); //x86_64


    }


}
