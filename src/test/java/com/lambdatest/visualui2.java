package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

public class visualui2 {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = null;


        Hashtable<String, Integer> errorColor= new Hashtable<>();
        errorColor.put("red",255);
        errorColor.put("green",0);
        errorColor.put("blue",0);

        HashMap<String,Object> output= new HashMap<String, Object>();
        output.put("errorColor",errorColor);//Output Difference error color
        output.put("transparency",0.1);// Set transparency of Output
        output.put("largeImageThreshold",1200);// the granularity to which the comparison happens(the scale or level of detail in a set of data.)Range-100-1200


        HashMap<String, Object> sm=new HashMap<String, Object>();
        sm.put("output",output);
        sm.put("scaleToSameSize",true);//scale to same size, when baseline image and comparision image is of different size, use true





        String username = "deepanshulambdatest";
        String access_key = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "VisualUI");
        capabilities.setCapability("name", "Visual Ui Testing");



        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel.*");
        capabilities.setCapability("app","lt://APP10160501221679565658309799");

        capabilities.setCapability("visual",true);
        capabilities.setCapability("smartUI.project","app automation 15 may");
        //capabilities.setCapability("smartUI.build","10689a4");
//        capabilities.setCapability("smartUI.options",sm);
        //multiple baseline images for your project
        capabilities.setCapability("smartUI.build","build 1");
//        capabilities.setCapability("selenium_version", "4.6.0");
        capabilities.setCapability("isRealMobile", true);


//        driver = new AppiumDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), capabilities);

        driver = new AppiumDriver(new URL("http://" + username + ":" + access_key + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);


        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("color"))).click();
        driver.executeScript("smartui.takeScreenshot=pic1");
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("geoLocation"))).click();
        driver.executeScript("smartui.takeScreenshot=pic2");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(1000);

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
        Thread.sleep(10000);

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("url"))).sendKeys("https://www.lambdatest.com/");;
        driver.executeScript("smartui.takeScreenshot=pic7");
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("find"))).click();
        driver.executeScript("smartui.takeScreenshot=pic8");
        Thread.sleep(1000);

        driver.executeScript("lambda-status=passed");
        Thread.sleep(1000);
        driver.quit();



    }
}