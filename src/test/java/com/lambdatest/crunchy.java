package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
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

public class crunchy {
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
//
        capabilities.setCapability("isRealMobile", true);
//

        capabilities.setCapability("appiumVersion", "2.0");
        capabilities.setCapability("platformVersion", "16");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("autoAcceptAlerts","true");

        capabilities.setCapability("app","lt://APP1016045801684404228061622");

        capabilities.setCapability("console",true);
//        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
//

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
