package com.lambdatest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.List;

public class jobget {
    public static String username = "deepanshulambdatest";
    public static String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static RemoteWebDriver driver;
    public static String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public static String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "location popup check");
        capabilities.setCapability("name", "Java JUnit iOS iPhone 12");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("app","lt://APP10160531401676986692885897");
//        capabilities.setCapability("autoAcceptAlerts",true);
        //capabilities.setCapability("fixedIP",  "00008020-001E65540A2A402E");
        //capabilities.setCapability("bundleId", "com.android.chrome");
        //capabilities.setCapability("app", "stock");
        //capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",false);
        capabilities.setCapability("visual",true);
        //capabilities.setCapability("region","eu");

        try
        {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            System.out.println("Invalid Grid URL");
        }

    }

    @Test
    public void basicTest() throws InterruptedException {

        {
            try {
                Thread.sleep(20000);
                //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Login\"]"));
                driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LandingPageVC.buttonLogin\"]")).click();
                Thread.sleep(3000);
                System.out.println("1");
                driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue as a Job Seeker\"]")).click();
                Thread.sleep(3000);
                System.out.println("1");
                driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]")).click();
                Thread.sleep(3000);
                System.out.println("1");
                driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"JobGet\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")).sendKeys("tester313906@jobgetmobile.msdc.co");
                Thread.sleep(3000);
                System.out.println("1");
//            driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"JobGet\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")).sendKeys("tester");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LOG IN\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"LOG IN\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Profile\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Experience\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Start Date\"]")).sendKeys("2021");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"End Date\"]")).sendKeys("August");
//            Thread.sleep(3000);


//            List<MobileElement> els1 = (MobileElement) driver.findElementsByXPath("//XCUIElementTypeTextField[@value=Email address]");
//            (new TouchAction(driver)).press(PointOption.point(238, 224})).moveTo(PointOption.point(226, 607})).release().perform();
//
//
//


//            driver.navigate().back();

                status = "passed";
            } catch (Exception e) {
                System.out.println(e.getMessage());
                status = "failed";
            }
        }

    }
    @AfterTest
        public void tearDown()
        {
            driver.executeScript("lambda-status=" + status);
            driver.quit();

        }
}
