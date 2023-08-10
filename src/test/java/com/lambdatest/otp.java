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

public class otp {
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
//        capabilities.setCapability("platformName", "android");
//        capabilities.setCapability("deviceName", "Galaxy S22 5G");
//        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformVersion","13");
//        capabilities.setCapability("app","stock");
//        capabilities.setCapability("bundleId","com.apple.mobileslideshow");
//        capabilities.setCapability("app","lt://APP10160631101688629520264477");
        capabilities.setCapability("app", "lt://APP1016033751688985221887886");
        capabilities.setCapability("build", "parking");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","16");

//        capabilities.setCapability("platformVersion", "13");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Pixel 6 Pro");
//        caps.setCapability("platformName", "ios");
//        caps.setCapability("deviceName", "iPhone 13 Pro Max");
//        caps.setCapability("platformVersion", "15");
//        caps.setCapability("network", false);
//        caps.setCapability("browserName", "Safari");
//        caps.setCapability("browserVersion", "latest");
//        caps.setCapability("platformName", "OS X Mountain Lion");
//        capabilities.setCapability("app","lt://APP10160531401676365873738936");
//        caps.setCapability("platform", "macOS Monterey");

//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("browserVersion", "106");
//        caps.setCapability("version", "latest");
        capabilities.setCapability("build", "otp");
//        capabilities.setCapability("region", "AP");
//        caps.setCapability("name", "attempt_2 with safari 6");
//        capabilities.setCapability("fixedIP",  "00008101-0019504A0228001E");
        //capabilities.setCapability("bundleId", "com.android.chrome");
        //capabilities.setCapability("app", "stock");
        //capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts", true);
//        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("visual",true);
//        capabilities.setCapability("timezone", "UTC+03:00");
        //capabilities.setCapability("region","eu");

        try
        {
//            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
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

//
//            driver.findElement(By.id("com.msf.angelmobile:id/btnLogin")).click();
//            Thread.sleep(5000);
//
//
//            System.out.println(driver.getSessionId());
//
//            driver.findElement(By.id("com.msf.angelmobile:id/edtLoginMobileNumber")).sendKeys("7860505813");
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("com.msf.angelmobile:id/btnLoginProceed")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("tvDeny")).click();
//            Thread.sleep(5000);
////
//            driver.findElement(By.id("ccom.msf.angelmobile:id/edtOtpVerify")).sendKeys("");
////            Thread.sleep(5000);
//            driver.hideKeyboard();
//
//            driver.findElement(By.id("com.msf.angelmobile:id/btnOtpProceed")).click();
//            Thread.sleep(5000);


            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"loginButton\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Sign in with email\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"EmailCellAccessibilityID\"]/XCUIElementTypeTextField")).sendKeys("vqhnrgob@gmail.com");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"NextButtonAccessibilityID\"]")).click();
            Thread.sleep(5000);

//            driver.findElement(By.id("NameSignUpCellAccessibilityID")).sendKeys("Cuenta Prueba");
//            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value=\"Enter your password\"]")).sendKeys("prueba123");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign in\"]")).click();
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
