package com.lambdatest;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tripadvisor {

    //    private RemoteWebDriver driver;
    private IOSDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", "DOTDASH");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);
        caps.setCapability("platformName", "ios");
        caps.setCapability("deviceName", "iPhone XR");
        caps.setCapability("isRealMobile", true);
        caps.setCapability("platformVersion","14");
        caps.setCapability("autoAcceptAlerts", true); // for auto alerts
//        caps.setCapability("autoDissmissAlerts", "true");
        caps.setCapability("app", "lt://APP10160531401673884973380425");
        caps.setCapability("console",true);
        caps.setCapability("visual",true);

        driver = new IOSDriver(new URL("https://" + username + ":" + authkey + hub), caps);



    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
//        driver.manage().window().maximize();
        {
            //XCUIElementTypeTextField[@name="TabBarItemTitle"] url bar ka xpath
//             driver.get("https://apple.news/T3ql2QXaiTpWaBFIOUD8nUA");
//             Thread.sleep(20000);
            System.out.println(1);

            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"I Accept\"]")).click();
            Thread.sleep(5000);

//            driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Skip\"])[2]")).click();
//            Thread.sleep(8000);
            driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Skip\"])[1]")).click();
            Thread.sleep(8000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]")).click();
            Thread.sleep(5000);



        }
        Status = "passed";
        Thread.sleep(800);
        System.out.println("TestFinished");


    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}