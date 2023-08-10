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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

public class contextswitch {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //    public static RemoteWebDriver driver = null;
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "with auto dismiss true and appiumversion 2 and autoaccept false");
        capabilities.setCapability("app", "lt://APP10160631101689066985590959");
        capabilities.setCapability("build", "arable");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("appiumVersion","2.0");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","16");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts", false);
        capabilities.setCapability("appPackage", "your_app_package"); // Replace with your app package
        capabilities.setCapability("appActivity", "your_app_activity");
//        capabilities.setCapability("noReset",false);
        capabilities.setCapability("autoDismissAlerts", true);



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


            driver.findElement(new MobileBy.ByAccessibilityId("gettingStartedButton")).click();
            Thread.sleep(5000);

            driver.findElement(new MobileBy.ByAccessibilityId("SI-EmailInput")).sendKeys("test.automation@arable.com");
            Thread.sleep(5000);


            driver.findElement(new MobileBy.ByAccessibilityId("SI-PasswordInput")).sendKeys("arable2022@");
            Thread.sleep(5000);

            driver.findElement(new MobileBy.ByAccessibilityId("SI-SignInBtn")).click();
            Thread.sleep(5000);

//            driver.pressKeyCode(AndroidKeyCode.BACK);


//            driver.executeScript("lambda-uninstall-app=com.arable");
//            Thread.sleep(15000);
//
//
//            driver.executeScript("lambda-install-app=lt://APP10160631101689066985590959");
//            Thread.sleep(5000);
//
//            driver.activateApp("com.arable");
//            Thread.sleep(5000);
//


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
