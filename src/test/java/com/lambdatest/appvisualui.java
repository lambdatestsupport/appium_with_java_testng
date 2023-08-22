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
import java.util.Set;

public class appvisualui {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static AppiumDriver driver = null;
    //    public String gridURL = "@localhost:9688/wd/hub";
    public String gridURL =  "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "proverbial");
        capabilities.setCapability("build", "sample_build");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("app","lt://APP1016033751687504225305988");
        capabilities.setCapability("network", "false");
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("smartUI.project","demo");
        capabilities.setCapability("smartUI.build","build 2");



        try
        {
            driver = new AppiumDriver(new URL("http://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(5000);

//            driver= http://" + username + ":" + authkey + "@localhost:9688/wd/hub";

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

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("color"))).click();
            driver.executeScript("smartui.takeScreenshot=pic1");
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("geoLocation"))).click();
            driver.executeScript("smartui.takeScreenshot=pic2");
            Thread.sleep(1000);

            driver.navigate().back();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("Text"))).click();
            driver.executeScript("smartui.takeScreenshot=pic3");
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("notification"))).click();
            driver.executeScript("smartui.takeScreenshot=pic4");
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("toast"))).click();
            driver.executeScript("smartui.takeScreenshot=pic5");
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("Browser"))).click();
            driver.executeScript("smartui.takeScreenshot=pic6");
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("url"))).sendKeys("https://www.lambdatest.com/");;
            driver.executeScript("smartui.takeScreenshot=pic7");
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("find"))).click();
            driver.executeScript("smartui.takeScreenshot=pic8");
            Thread.sleep(1000);

//            driver.closeApp();
            driver.terminateApp("proverbial");

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
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
