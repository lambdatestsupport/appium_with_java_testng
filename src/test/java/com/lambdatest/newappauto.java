package com.lambdatest;

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

public class newappauto {
    String username = "deepanshulambdatest";
    String authkey = "vvI4dCayA0O65Pzpj2mUqdOtwPIYfVlpEnX3OQtzLJDgQdAJME";
    //    public static RemoteWebDriver driver = null;
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "test 1");
        capabilities.setCapability("app", "lt://APP10160571901691403786462723"); //for ios
        capabilities.setCapability("app","lt://APP10160571901691407245406630"); //for android proverbial
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformVersion","15");

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel.*");
        capabilities.setCapability("platformVersion","12");

        capabilities.setCapability("build", "sample-build");
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts", true);


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

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("color"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("geoLocation"))).click();
            Thread.sleep(5000);
            driver.navigate().back();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("Text"))).click();
            Thread.sleep(5000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("notification"))).click();
            Thread.sleep(5000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("toast"))).click();
            Thread.sleep(5000);

//            driver.closeApp();
            driver.terminateApp("proverbial");

            driver.navigate().back();
            status="passed";
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
