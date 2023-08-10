package com.lambdatest;
import java.time.LocalDate;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

public class vui {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver = null;


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
//        String username = "deepanshu";
//        String access_key = "OVjlD7B0yBPZAAoA9HhBGXz51CFDq2c9lSWa7G9hFKmaHTQ6Ic";
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("build", "VisualUI"+ LocalDate.now());
        capabilities.setCapability("name", "Visual Ui Testing");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformName", "Windows 11");
        capabilities.setCapability("browserVersion", "105.0");
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("deviceName", "iPad Air 2");
//        capabilities.setCapability("platformVersion", "14.5");

        capabilities.setCapability("visual",true);
        capabilities.setCapability("smartUI.project","july7");
        //capabilities.setCapability("smartUI.build","10689a4");
//        capabilities.setCapability("smartUI.options",sm);
        //multiple baseline images for your project
        capabilities.setCapability("smartUI.build","build 1");
//        capabilities.setCapability("selenium_version", "4.0.0");
//        capabilities.setCapability("isRealMobile", true);


        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), capabilities);




        driver.get("https://www.lambdatest.com");
//        Thread.sleep(5000);
        driver.executeScript("smartui.takeScreenshot=pic4");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/support/docs/");
//        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pic5");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/pricing");
//        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pic6");
        Thread.sleep(1000);

//
////        driver.findElement(By.xpath("//*[@id=\"mobile-header\"]/div/div[3]/div[1]/nav/nav/a[2]/span")).click();
////        Thread.sleep(5000);
////
//       driver.executeScript("smartui.takeFullPageScreenshot,{\"screenshotName\": \"pic4\", \"smartScroll\": true}");
//        Thread.sleep(1000);
//
//
//
//        driver.get("https://www.lambdatest.com/support/docs/");
////        Thread.sleep(5000);
//        driver.executeScript("smartui.takeScreenshot=pic3");
//        Thread.sleep(1000);


//        driver.get("https://www.lambdatest.com/webinar/building-selenium");
//        Thread.sleep(5000);
//        driver.executeScript("smartui.takeScreenshot,{\"screenshotName\":\"dom-screenshot\",\"ignoreDOM\":{\"id\":[],\"class\":[\"py-30 webinar_custom bg-purple-12 py-50 lg:py-70 xxl:py-100\"]}}");
//        Thread.sleep(1000);
//
//        driver.get("https://www.lambdatest.com/webinar/effective-test-automation-strategy");
//        Thread.sleep(5000);
//        driver.executeScript("smartui.takeScreenshot,{\"screenshotName\":\"dom-screenshot\",\"ignoreDOM\":{\"id\":[],\"class\":[\"mt-70 smtablet:mt-30\"]}}");
////        Thread.sleep(1000);
////        driver.executeScript("smartui.takeScreenshot,{\"screenshotName\":\"dom-screenshot\",\"ignoreDOM\":{\"id\":[],\"class\":[]}}");
////        Thread.sleep(1000);
//        driver.get("https://www.lambdatest.com/");
//        Thread.sleep(5000);


//        driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[1]/div[3]/button")).click();
//        driver.executeScript("smartui.takeScreenshot=pic4");
//        Thread.sleep(1000);
//        driver.executeScript("smartui.fetchScreenshotStatus");

        driver.executeScript("lambda-status=passed");
        driver.quit();



    }
}