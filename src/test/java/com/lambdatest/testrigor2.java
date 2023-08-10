package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSBatteryInfo;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class testrigor2 {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static AppiumDriver driver = null;

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "Testrigor with region"+ LocalDate.now());
        capabilities.setCapability("name","Test"+ (Calendar.DAY_OF_MONTH));

        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app","lt://APP1016033751687326239842714");
        capabilities.setCapability("deviceName", "iPhone.*");
        capabilities.setCapability("platformVersion","16");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("region","US");
//        capabilities.setCapability("w3c","true");
        capabilities.setCapability("console",true);
        capabilities.setCapability("visual",true);
        capabilities.setCapability("network",false);

        driver = new AppiumDriver(new URL("http://"+username+":"+authkey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);
        Thread.sleep(6000);
        System.out.println(gridURL);



    }

    @Test
    public void testSimple() throws Exception
    {
        try
        {
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log in\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"email_field\"]\n")).sendKeys("test+e07fbdf1-1043-4b0e-89ca-b0d1ad0af74b+17.07.23_14.36_25@ynab.com");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password_field\"]\n")).sendKeys("ynabynab");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"sign_in_button\"]\n")).click();
            Thread.sleep(20000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"navigation_account\"]")).click();
            Thread.sleep(20000);

            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
    }
    @AfterTest
    public void tearDown(ITestResult result) throws Exception
    {
        if (driver != null)
        {
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
