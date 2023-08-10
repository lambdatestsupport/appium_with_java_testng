package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.SQLOutput;

public class deferit {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static AppiumDriver driver = null;
//    public static RemoteWebDriver driver = null;

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "deferit with ios 15");
        capabilities.setCapability("name", " TEST WITH IPHONE 15");
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("deviceName", "iPhone 13 Pro");
        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("app","lt://APP10160621161675693496756734");
//        capabilities.setCapability("appiumVersion", "2.0");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13 Pro Max");


//        capabilities.setCapability("w3c", true);
//        capabilities.setCapability("isXcuiEspressoTest",true);
//        capabilities.setCapability("appiumVersion ","2.0");

//        capabilities.setCapability("fixedIP",  "00008110-001E7494229B801E");
        //capabilities.setCapability("bundleId", "com.android.chrome");
        //capabilities.setCapability("app", "stock");
        //capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",false);
        capabilities.setCapability("visual",true);
        capabilities.setCapability("AllowInvisibleElements", true);
//        capabilities.setCapability("region","US");

        try
        {
            driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
//            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(5000);
            String pageSource = driver.getPageSource();
            System.out.println(pageSource);
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
//            String context = driver.getContext();
//            System.out.println(context);
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"test:id/login-with-credentials-button\"]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Your email\"]")).sendKeys("imoness@deferit.com");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Your password\"]")).sendKeys("123qweASD1abc");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Login\"]")).click();
            Thread.sleep(9000);


//            driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"+1 We'll send a verification code to this number\"]")).sendKeys("2555528047");
//            Thread.sleep(15000);
//            driver.findElement(MobileBy.AccessibilityId("+1 We'll send a verification code to this number")).sendKeys("2555528047");
//            Thread.sleep(15000);
////
//            driver.findElement(By.id("+1 We'll send a verification code to this number")).sendKeys("2555528047");
//            Thread.sleep(15000);

            driver.findElement(By.id("test:id/phone-number-field")).sendKeys("2555528047");
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
