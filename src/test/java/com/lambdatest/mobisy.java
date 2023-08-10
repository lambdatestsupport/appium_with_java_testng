package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mobisy {


    private IOSDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException
    {
        String username = "deepanshulambdatest";
        String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";

//        String username= "mobileautoservic_w86Uka";
//        String accessKey= "SeW8HQo2LzzoUw9qsDK8";


        String HUB_URL = "@mobile-hub.lambdatest.com/wd/hub";
//        String HUB_URL= "@hub-cloud.browserstack.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build","mobisy with accessibility id:allow while using the app");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app", "lt://APP10160531401676973786908416");
//        capabilities.setCapability("app", "bs://290e36ad5de8083ef6adefb80ca52445a6659829");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("xcodeOrgId", "CM3KBTB68A");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoDismissAlerts",true);
        capabilities.setCapability("autoGrantPermissions", true);

        capabilities.setCapability("appiumVersion", "2.0");
//        capabilities.setCapability("noReset",true);
        capabilities.setCapability("fullReset",false);
        capabilities.setCapability("bundleId", "com.mobisy.bizom");


        driver = new IOSDriver(new URL("https://" + username + ":" + accessKey + HUB_URL), capabilities);
        System.out.println("iOS Driver Initiated Successfully.");


    }

    @Test
    public void basicTest() throws InterruptedException {


        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Sign in Enter your credentials to login I agree to the terms and conditions\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")).sendKeys("apptestuser");
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Sign in Enter your credentials to login I agree to the terms and conditions\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")).sendKeys("mobisy");
        Thread.sleep(5000);



        driver.findElement(By.id("Sign in")).click();
        Thread.sleep(5000);

        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Sign in Enter your credentials to login I agree to the terms and conditions\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther")).click();

        }
        Thread.sleep(8000);

        // selecting dev environment
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='edittext_undefined dropdown_icon_undefined'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='list_item_Development'])[2]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"I agree to the terms and conditions\"])[2]/XCUIElementTypeOther")).click();
        //this above code is for the checkbox that got unchecked after selecting the development profile
        Thread.sleep(10000);

//        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]")).click();
//        Thread.sleep(10000);

        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Submit'])[last()]")).click();

        Thread.sleep(10000);
        driver.findElement(MobileBy.AccessibilityId("Allow While Using App")).click();
        Thread.sleep(25000);

        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"\uF3FE\"])[2]")).click();
        Thread.sleep(10000);

    }
        @AfterMethod
        public void tearDown()
    {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}