package com.lambdatest;
//package com.browserstack;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class bs {

    public static String userName = "mobileautoservic_w86Uka";
    public static String accessKey = "SeW8HQo2LzzoUw9qsDK8";
    public static String status = "passed";
    public static AppiumDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "qapi");
        capabilities.setCapability("test", "Test 1");

        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 11");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("app", "bs://c7bbe26caeee770a2972243de34b1c36af30714a");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("automationName","flutter");
        capabilities.setCapability("console",true);

//        capabilities.setCapability("device", true);
        capabilities.setCapability("appiumVersion","2.0");

        capabilities.setCapability("console", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("w3c", true);

        try {
            driver = new AppiumDriver(new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            status = "failed";
            e.printStackTrace();
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


//                driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"navigation_account\"]")).click();
//                Thread.sleep(5000);
//
//                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"et_email\"]")).sendKeys("01100000110");
//                Thread.sleep(5000);
//
//                driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"et_password\"]\n")).sendKeys("Test@123");
//                Thread.sleep(5000);

//                driver.findElement(By.xpath("\t\n" + "//XCUIElementTypeButton[@name=\"mb_continue\"]")).click();
//                Thread.sleep(50000);

//                driver.findElement(By.xpath("mb_continue")).click();
//                Thread.sleep(50000);

//                driver.findElement(driver.findElementsByIosUIAutomation("collectionViews()[0].cells().withPredicate(\"ANY staticTexts.isVisible == TRUE\")");)
//
//                driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign in with SMS\"]\n")).click();
//                Thread.sleep(5000);
//
//                driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"navigation_account\"]")).click();
//                Thread.sleep(50000);


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
                driver.quit();
            }
        }
    }
