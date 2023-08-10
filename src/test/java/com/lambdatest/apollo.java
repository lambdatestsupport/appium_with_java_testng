package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

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

public class apollo {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "test 1 with network true and patched app");
        capabilities.setCapability("build", "apollo");
        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("app","stock");
//        capabilities.setCapability("bundleId","com.apple.mobileslideshow");

        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Galaxy.*");
//        capabilities.setCapability("appiumVersion", "1.22.0");
//        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("resignApp",true);
        capabilities.setCapability("app","lt://APP1016046941679316104030355");
//        capabilities.setCapability("resignApp", false);
//        capabilities.setCapability("app","lt://APP1016046941678714630991380");
//        String[] customOtherApps = {"lt://APP1016046941678886558544881"};
//        capabilities.setCapability("otherApps",customOtherApps);


        //capabilities.setCapability("bundleId", "com.android.chrome");
        //capabilities.setCapability("app", "stock");
        //capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
//        capabilities.setCapability("visual",true);
//        capabilities.setCapability("timezone", "UTC+03:00");
        //capabilities.setCapability("region","eu");

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

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("notification"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("toast"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("Browser"))).click();
            Thread.sleep(10000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("url"))).sendKeys("https://www.lambdatest.com/");;

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("find"))).click();



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
