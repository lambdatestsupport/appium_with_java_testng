//package magicleapTesting;
package com.lambdatest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import javafx.scene.control.cell.TextFieldListCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class magellen {



    public static String userName = "deepanshulambdatest";
    public static String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static String status = "passed";
    public static AndroidDriver driver;

    public static <string> void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "MagellanHealth script");
        capabilities.setCapability("test", "Test 1");
        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformName", "android");
//        capabilities.setCapability("deviceName", "Pixel 6");
//        capabilities.setCapability("platformVersion", "12");
//        capabilities.setCapability("app","lt://APP1016045801683556559937282");
        capabilities.setCapability("app","lt://APP1016059741685714739807217");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("platformName", "ios");


        capabilities.setCapability("console",true);
        capabilities.setCapability("visual",true);
        capabilities.setCapability("w3c", true);
//        capabilities.setCapability("region", "US");
        driver = new AndroidDriver(new URL("http://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);



        Thread.sleep(6000);


        driver.findElementByXPath("(//*[contains(@class,'android.widget.EditText')])[1]").click(); // clicking on username text box to focus
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "shivbvjcl@gmail.com")); //option 1 to enter USERNAME(should work with iOS too)
            Thread.sleep(5000);

            driver.findElementByXPath("(//*[contains(@class,'android.widget.EditText')])[2]").click(); // clicking on password text box to focus
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Testing123!"));  //option 1 to enter PASSWORD(should work with iOS too)


            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Sign in\"]").click(); //clicking on signing button
            Thread.sleep(5000);


            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Skip tutorial\"]")).click();
            Thread.sleep(6000);
            driver.findElementByXPath("//android.view.View[@content-desc=\"More tab. 3 of 3. Tap for settings, support and other options.\"]").click(); // clicking on next button
            Thread.sleep(6000);

try {
    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"FAQs & Contact\").instance(0))"));
    } catch (Exception e)

   {
    System.out.println(e);
    }

            Thread.sleep(9000);

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"FAQs & Contact\"]")).click();
            Thread.sleep(6000);

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"back\"]\n")).click();
            Thread.sleep(6000);

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Terms & Conditions\"]")).click();
            Thread.sleep(6000);

            status="passed";

        driver.executeScript("lambda-status=" + status);
        driver.quit();
    }
}