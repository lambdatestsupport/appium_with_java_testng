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

public class ecolab {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //    public static RemoteWebDriver driver = null;
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "test1");
        capabilities.setCapability("app", "lt://APP1016033751689147500345758");
        capabilities.setCapability("build", "ecolab_app_crash");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","16");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts", true);
//        capabilities.setCapability("autoDismissAlerts", true);



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


            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow Once\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"CompanySelectionEntry\"]")).sendKeys("XYZ");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"CompanySelectionTitleLabel\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"CompanySelectionNextButton_Container\"]")).click();
            Thread.sleep(5000);


            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"LoginPageUsernameEntry\"]")).sendKeys("manager@xyzrestaurants.com");
            Thread.sleep(5000);

            driver.findElement(By.id("LoginPagePasswordEntry")).sendKeys("Ecolab@123");
            Thread.sleep(5000);

            driver.findElement(By.id("LoginPageLogInButton")).click();
            Thread.sleep(25000);

            driver.findElement(By.xpath("//XCUIElementTypeSearchField[@name=\"Search by Store Number\"]")).sendKeys("XYZ");
            Thread.sleep(15000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Search\"]")).click();
            Thread.sleep(15000);

            driver.findElement(By.id("StoreAssignmentPageStoreList")).click();
            Thread.sleep(15000);



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
