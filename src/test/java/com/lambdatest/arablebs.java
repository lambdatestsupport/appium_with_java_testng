package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.ios.IOSDriver;
import javafx.scene.web.WebView;
import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;
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
import java.lang.annotation.Native;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

public class arablebs {
    public static String userName = "mobileautoservic_w86Uka";
    public static String accessKey = "SeW8HQo2LzzoUw9qsDK8";
    public static String status = "passed";
    public static AppiumDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "1");
        capabilities.setCapability("app", "bs://c50ea55548bf57ce9a7ca4bcda0cc549501c7ad7");
        capabilities.setCapability("build", "arable");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","16");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
//        capabilities.setCapability("autoAcceptAlerts", true);
//        capabilities.setCapability("noReset",false);
        capabilities.setCapability("autoDismissAlerts", false);



        try
        {
            driver = new AppiumDriver(new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
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
            driver.quit();
        }
    }
}
