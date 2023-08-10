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

public class pw {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
//    public static AppiumDriver driver = null;
    public static IOSDriver driver = null;

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

        capabilities.setCapability("app","lt://APP1016039251686046256370382");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("automationName","Flutter");
        capabilities.setCapability("appiumVersion","2.0");

        System.out.println(gridURL);



        try
        {
            driver = new IOSDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
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
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"navigation_account\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"et_email\"]")).sendKeys("01100000110");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"et_password\"]\n")).sendKeys("Test@123");
            Thread.sleep(5000);

            driver.findElement(By.xpath("\t\n" + "//XCUIElementTypeButton[@name=\"mb_continue\"]")).click();
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
