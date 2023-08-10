package com.lambdatest;

import com.sun.media.sound.SoftFilter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Set;

public class parking {
    String username = "Your_LT_username";
    String authkey = "Your_LT_access_key";
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "test 1");
        capabilities.setCapability("build", "parking");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","16");
        capabilities.setCapability("app","lt://APP1016033751688985221887886");
        capabilities.setCapability("network", "true");
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts",true);


        try
        {
            driver = new AppiumDriver(new URL("http://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(5000);


        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testSimple() throws Exception
    {
        try
        {



            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"loginButton\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\\\"Sign in with email\\")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"EmailCellAccessibilityID\"]/XCUIElementTypeTextField")).sendKeys("vqhnrgob@gmail.com");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"NextButtonAccessibilityID\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.id("NameSignUpCellAccessibilityID")).sendKeys("enter your name here");
            Thread.sleep(5000);

            driver.findElement(By.id("PasswordSignUpCellAccessibilityID")).sendKeys("enter your password here");
            Thread.sleep(5000);

            driver.findElement(By.id("SaveButtonAccessibilityID")).click();
            Thread.sleep(5000);


           driver.getContext();
           driver.context("Native");

            driver.navigate().back();
            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
    }
    @AfterTest
    public void tearDown() throws Exception
    {
        if (driver != null)
        {
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
