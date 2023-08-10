package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class xcui {

    private AppiumDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "deepanshulambdatest";
        String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("build", "xcui march");
        capabilities.setCapability("name", "test 1");

        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("devicelog",true);
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app","lt://APP10160531401677675327217508");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);

        driver = new AppiumDriver(new URL("https://" + username + ":" + accessKey + hub), capabilities);



    }

    @Test
    public void basicTest() throws InterruptedException {


        WebDriverWait Wait = new WebDriverWait(driver,30);

        //Changes the color of the text
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("color"))).click();
        Thread.sleep(1000);

        //Changes the text to "Proverbial"
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Text"))).click();
        Thread.sleep(1000);

        //Toast will be visible
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("toast"))).click();
        Thread.sleep(1000);

        //Notification will be visible
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("notification"))).click();
        Thread.sleep(4000);

        //Opens the geolocation page
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("geoLocation"))).click();
        Thread.sleep(4000);

        //Takes back
        driver.navigate().back();

        //Takes to speedtest page
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("speedTest"))).click();
        Thread.sleep(4000);

        driver.navigate().back();

        //Opens the browser
        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Browser"))).click();
        Thread.sleep(1000);

        MobileElement url = (MobileElement) driver.findElementByAccessibilityId("url");
        url.click();
        url.sendKeys("https://www.lambdatest.com");

        Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("find"))).click();
        Thread.sleep(1000);


        // Let's also assert that the todo we added is present in the list.

        Status ="passed";
        // Thread.sleep(150);

        System.out.println("TestFinished");
    }



    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}