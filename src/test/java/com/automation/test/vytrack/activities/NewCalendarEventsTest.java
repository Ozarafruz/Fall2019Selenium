package com.automation.test.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.test.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTest extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Test
    public void defaultOptionsTest(){


        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());

        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");

        Assert.assertEquals(actualStartDate,expectedStartDate);
      //  Assert.assertEquals(calendarEventsPage.getStartDate(), DateTimeUtilities.getCurrentDate("MMM dd, yyyy")); //one shot


    }
    @Test
    public void timeDifferenceTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime = calendarEventsPage.getStartTime(); //get start time
        String endTime = calendarEventsPage.getEndTime(); // get end time
        String format = "h:m a"; //format 5:15 AM for example

        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);

        Assert.assertEquals(actual, 1 , "Time difference is not correct");


    }

    @Test
    public void verifyColumnNames(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");


        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");

        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);

    }


}
