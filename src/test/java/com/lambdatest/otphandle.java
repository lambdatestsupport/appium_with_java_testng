package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class otphandle {

    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public String status = "passed";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void testSimple() throws Exception {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","Java TestNG Android");
            capabilities.setCapability("name","otphandle");
            capabilities.setCapability("deviceName", "Galaxy.*");
            capabilities.setCapability("platformVersion","12");
            capabilities.setCapability("platformName", "android");

            capabilities.setCapability("deviceName", "iphone.*");
            capabilities.setCapability("platformVersion","14");
            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP10160631101690473384104929"); //for android
            capabilities.setCapability("app", "lt://APP10160571901690830033522636"); //for ios

            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            //capabilities.setCapability("geoLocation", "HK");

            String hub = "https://" + username + ":" + authkey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);


            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Enter mobile number\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("/android.widget.EditText")).sendKeys("7860505813");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send OTP\"]")).click();
            Thread.sleep(5000);

            ((AndroidDriver) driver).openNotifications();



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

//            driver.findElement(By.id("com.msf.angelmobile:id/edtOtpVerify")).click();
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("command", "keyevent");
//            params.put("text", 1);
//            driver.executeScript("lambda-adb", params);
//            Thread.sleep(5000);

//
//            driver.findElement(By.id("com.msf.angelmobile:id/btnOtpProceed")).click();
//            Thread.sleep(5000);


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
