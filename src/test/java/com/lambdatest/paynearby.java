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

public class paynearby {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //    public static RemoteWebDriver driver = null;
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "test 1");
        capabilities.setCapability("build", "borngroup");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion", "16");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appProfiling", true);
        capabilities.setCapability("app","lt://APP1016045801684404228061622");
        capabilities.setCapability("network", false);
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts",true);


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
            Thread.sleep(30000);

//           driver.findElement(By.xpath("//android.widget.Button[@text=\"CONTINUE IN ENGLISH\"]")).click();
//           Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.Button[@text=\"GET STARTED\"]")).click();
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.Button[@text=\"Cancel\"]")).click();
//            Thread.sleep(10000);
//
//            if (driver.findElement(By.xpath("//android.widget.EditText[@text=\"Mobile Number\"]")).isDisplayed())
//            {
//            driver.findElement(By.xpath("//android.widget.EditText[@text=\"Mobile Number\"]")).sendKeys("7021530275");
//            Thread.sleep(10000);
//            }
////            7021530275 user number
////            driver.findElement(By.xpath("//android.widget.Button[@text=\"VERIFY\"]")).click();
////            Thread.sleep(10000);
//
//            if (driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).isDisplayed())
//            {
//                driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("Admin@123");
//
//                Thread.sleep(19000);
//            }
////            com.bnb.paynearby.staging:id/password_et
//
//            driver.findElement(By.xpath("//android.widget.Button[@text=\"LOGIN\"]")).click();
//            Thread.sleep(10000);
//
////            com.bnb.paynearby.staging:id/btnLogin
////            driver.findElement(By.xpath("//android.widget.Button[@text= While using the app]")).click();
////            Thread.sleep(10000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"navigation_account\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"et_email\"]")).sendKeys("01100000110");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"et_password\"]\n")).sendKeys("Test@123");
            Thread.sleep(5000);

            driver.findElement(By.xpath("\t\n" + "//XCUIElementTypeButton[@name=\"mb_continue\"]")).click();
            Thread.sleep(25000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"navigation_account\"]")).click();

            Thread.sleep(5000);

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
