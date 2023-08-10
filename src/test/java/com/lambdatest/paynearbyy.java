package com.lambdatest;

import com.sun.media.sound.SoftFilter;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

public class paynearbyy {
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //    public static RemoteWebDriver driver = null;
    public static AppiumDriver driver = null;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("name", "sample");
        capabilities.setCapability("build", "2");
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("deviceName", "Galaxy S22 5G");
        capabilities.setCapability("fixedIP","RZCW129C2DW");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appProfiling", true);
        capabilities.setCapability("app","lt://APP1016045801682580694475216");
        capabilities.setCapability("network", false);
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");

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
            Thread.sleep(30000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"A\"]")).click();
            Thread.sleep(10000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue\"]")).click();
            Thread.sleep(10000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
            Thread.sleep(10000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
            Thread.sleep(10000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Get Started\"]")).click();
            Thread.sleep(10000);

            driver.findElement(By.id("com.paynearby.saathi.staging:id/et_mobile")).sendKeys("8356956180");
            Thread.sleep(10000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
            Thread.sleep(10000);

            Actions actions = new Actions(driver);
//
//            actions.keyDown("1");
//
//            actions.keyUp("1");
//
//            actions.keyDown("2");
//
//            actions.keyUp("2");
//
//            actions.keyDown("3");
//
//            actions.keyUp("3");
//
//            actions.keyDown("4");
//
//            actions.keyUp("4");
//
//            actions.keyDown("5");
//
//            actions.keyUp("5");
//
//            actions.keyDown("6");
//
//            actions.keyUp("6");
//            actions.build().perform();
            actions.click(driver.findElement(By.id("com.paynearby.saathi.staging:id/til_login_pin"))).keyDown("1").keyUp("1").keyDown("1").keyUp("2").keyDown("2").keyUp("3").keyDown("3").keyUp("4").keyDown("4").keyUp("5").keyDown("5").keyUp("6").keyDown("6").perform();

//            driver.findElement(By.id("com.paynearby.saathi.staging:id/otp_cnf_pin")).sendKeys("1");
//            driver.findElement(By.id("com.paynearby.saathi.staging:id/til_login_pin")).sendKeys("123456");
            Thread.sleep(10000);

//            driver.findElement(By.xpath("//android.widget.LinearLayout[@index=\"1\"]")).sendKeys("123456");
            Thread.sleep(10000);


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
//            String p= driver.getPageSource();
//            System.out.println(p);
            driver.quit();
        }
    }
}
