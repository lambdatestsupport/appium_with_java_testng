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





         String username = "your_lt_user_name";
         String authkey = "your_lt_access_key";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "VisualUI");
        capabilities.setCapability("name", "Visual Ui Testing");

        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel 6");
        capabilities.setCapability("visual",true);
        capabilities.setCapability("smartUI.project","your_project_name");
     
        capabilities.setCapability("smartUI.build","your_build_name");
        capabilities.setCapability("isRealMobile", true);


        driver = new AppiumDriver(new URL("http://" + username + ":" + access_key + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);


        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com");
        Thread.sleep(5000);
        driver.executeScript("smartui.takeScreenshot=pic1");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/support/docs/");
        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pic2");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/pricing");
        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pic3");
        Thread.sleep(1000);

        driver.executeScript("lambda-status=passed");
        Thread.sleep(1000);
        driver.quit();



    }
}
