//package magicleapTesting;
package com.lambdatest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import javafx.scene.control.cell.TextFieldListCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class trivago {



    public static String userName = "deepanshulambdatest";
    public static String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static String status = "passed";
    public static AppiumDriver driver;

    public static <string> void main(String args[]) throws MalformedURLException, InterruptedException {
        Date m1 = new Date();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "Qapitol");
        capabilities.setCapability("name", "Visual Ui Testing");
        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformName", "android");
//        capabilities.setCapability("deviceName", "Pixel 6");
//        capabilities.setCapability("platformVersion", "12");
//        capabilities.setCapability("app","lt://APP1016045801683556559937282");
        capabilities.setCapability("app","lt://APP1016039251686046256370382");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("platformName", "ios");

        capabilities.setCapability("automationName","flutter");

        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("appiumVersion","2.0");
//        capabilities.setCapability("w3c","true");



        capabilities.setCapability("name",m1.getTime() );
        capabilities.setCapability("console",true);
        capabilities.setCapability("visual",true);
        driver = new AppiumDriver(new URL("http://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);


        Thread.sleep(6000);


        driver.findElement(By.xpath("")).click();
        Thread.sleep(6000);

        status="passed";

        driver.executeScript("lambda-status=" + status);
        driver.quit();
    }
}