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

public class qapitol {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //    public static RemoteWebDriver driver = null;
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "Native App Qapitol");
        capabilities.setCapability("test", "Test Parallel");
        capabilities.setCapability("isRealMobile", true);

        capabilities.setCapability("video", true);
        capabilities.setCapability("console", false);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("network",false);
        capabilities.setCapability("devicelog", false);

        capabilities.setCapability("app","lt://APP1016033751686741085371473");
        capabilities.setCapability("deviceName", "iPhone.*");
        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("automationName","Flutter");
        capabilities.setCapability("appiumVersion","2.0");


        try
        {
            driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
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
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"English\"]")).click();
            Thread.sleep(6000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Phone Number\"]\n")).sendKeys("1234567890");

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
