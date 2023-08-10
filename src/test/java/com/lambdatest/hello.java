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

public class hello {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "sample");
        capabilities.setCapability("name", "proverbial");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Galaxy S22 5G");
        capabilities.setCapability("fixedIP","RZCW129C2DW");
        capabilities.setCapability("platformVersion","13");

        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app","lt://APP1016033751687848437774676");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",false);
        capabilities.setCapability("visual",true);

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


            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("color"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("geoLocation"))).click();
            Thread.sleep(5000);
            driver.navigate().back();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("Text"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("notification"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("toast"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("Browser"))).click();
            Thread.sleep(10000);

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("url"))).sendKeys("https://www.lambdatest.com/");;

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("find"))).click();

//            driver.closeApp();
            driver.terminateApp("proverbial");

            driver.navigate().back();
//            driver.resetApp();
//            Thread.sleep(15000);
//            //Thread.sleep(2000);
////            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Login\"]"));
////            Thread.sleep(3000);
//            driver.findElement(By.xpath("//*[@resource-id=\"com.modanisa.debug:id/startShopping\"]")).click();
//            Thread.sleep(10000);
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LandingPageVC.buttonLogin\"]")).click();
//            Thread.sleep(3000);
//            System.out.println("1");
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue as a Job Seeker\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeTextField[@value = \"Email Address\"]")).sendKeys("tester313906@jobgetmobile.msdc.co");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value = \"Password\"]")).sendKeys("tester");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LOG IN\"]")).click();
//            Thread.sleep(3000);
////
////            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"LOG IN\"]")).click();
////            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Profile\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Ok\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Ok\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Ok\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Ok\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"JobGet\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeButton[1]")).click();
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Experience\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Start Date\"]")).sendKeys("August");
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Start Date\"]")).sendKeys("2019");
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"End Date\"]")).sendKeys("August");
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"End Date\"]")).sendKeys("2022");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"NAddExperienceVC.buttonSaveExp\"]")).click();
//            Thread.sleep(3000);

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
