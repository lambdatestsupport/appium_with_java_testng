package com.lambdatest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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
import java.util.concurrent.TimeUnit;

public class arable {
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
        capabilities.setCapability("app", "lt://APP10160631101689066985590959");
        capabilities.setCapability("build", "july_27");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("appiumVersion","2.0");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","16");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("idleTimeout","300");
        capabilities.setCapability("autoAcceptAlerts", false);
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
        try {


            driver.findElement(new MobileBy.ByAccessibilityId("gettingStartedButton")).click();
            Thread.sleep(5000);

            driver.findElement(new MobileBy.ByAccessibilityId("SI-EmailInput")).sendKeys("test.automation@arable.com");
            Thread.sleep(5000);


            driver.findElement(new MobileBy.ByAccessibilityId("SI-PasswordInput")).sendKeys("arable2022@");
            Thread.sleep(5000);

            driver.findElement(new MobileBy.ByAccessibilityId("SI-SignInBtn")).click();
            Thread.sleep(5000);


            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement scrollable_element = driver.findElement(By.xpath("your_xpath_for_scrollable_element"));


            Dimension size = driver.manage().window().getSize();
            int start_x = size.getWidth() / 2;
            int start_y = size.getHeight() / 2;
            int end_y = size.getHeight() / 4;
            TouchActions action = new TouchActions(driver);
//            action.press(start_x, start_y).moveTo(start_x, end_y).release().perform();


            for (int i = 0; i < 3; i++) {

                Thread.sleep(1000);
            }

            driver.quit();

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
