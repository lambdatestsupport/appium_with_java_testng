package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Cookie;
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
import java.util.Set;

public class cookie {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //    public static RemoteWebDriver driver = null;
    public static AndroidDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "cookie");

        capabilities.setCapability("build", "cookie");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Galaxy.*");
        capabilities.setCapability("appiumVersion","2.0");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","12");
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");



        try
        {
            driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
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



            driver.get("https://www.lambdatest.com");
            Thread.sleep(5000);

            Cookie cookie = new Cookie("number_check", "1234567");
            driver.manage().addCookie(cookie);
            Thread.sleep(5000);

            driver.get("https://www.lambdatest.com/pricing");
            Thread.sleep(5000);



            Set<Cookie> cookies = driver.manage().getCookies();
            for (Cookie cookie2 : cookies) {
                System.out.println(cookie.getName() + " : " + cookie2.getValue());
            }

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
