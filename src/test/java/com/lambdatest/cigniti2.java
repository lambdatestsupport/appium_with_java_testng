package com.lambdatest;

import bsh.org.objectweb.asm.Constants;
import com.sun.media.sound.SoftFilter;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.ios.IOSDriver;
import javafx.scene.web.WebView;
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
import java.util.Set;

public class cigniti2 {
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
        capabilities.setCapability("build", "sos");
        capabilities.setCapability("platformName","ios");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("deviceName", "iPhone.*");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app","lt://APP1016033751689684970633485");
        capabilities.setCapability("network", false);
        capabilities.setCapability("console",true);
        capabilities.setCapability("idleTimeout","300");
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

        Set<String> availableContexts = driver.getContextHandles();
        System.out.println("Available Contexts::"+availableContexts.toString());
        availableContexts.stream().filter(context -> context.toUpperCase().contains("WEBVIEW"))
                .forEach(newcontext -> driver.context(newcontext));

        Thread.sleep(20000);

        driver.findElement(By.xpath("(//XCUIElementTypeButton)[2]")).click();
        Thread.sleep(15000);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Get Started\"]")).click();
        Thread.sleep(15000);

        Set<String> availableContexts1 = driver.getContextHandles();
        System.out.println("Available Contexts::"+availableContexts1.toString());
        availableContexts1.stream().filter(context -> context.toUpperCase().contains("WEBVIEW_1"))
                .forEach(newcontext -> driver.context(newcontext));

        driver.findElement(By.xpath("//input[contains(@id,'wtUserNameInput')]")).sendKeys("chattest@amazon.com");
        Thread.sleep(25000);

        driver.findElement(By.xpath("//*[contains(@id,'wtLoginButton')]")).click();
        Thread.sleep(15000);

        driver.findElement(By.xpath("//input[contains(@id,'PasswordInput')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[contains(@id,'PasswordInput')]")).sendKeys("MyPassword123%");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[contains(@id,'LoginButton')]")).click();
        Thread.sleep(25000);


        String currentContext = driver.getContext();

        Set<String> availableContexts2 = driver.getContextHandles();
        System.out.println("Available Contexts::" + availableContexts2.toString());
        availableContexts2.stream().filter(context -> (context.toUpperCase().contains("WEBVIEW_2") && !context.toUpperCase().contains(currentContext)))
                .forEach(newcontext -> driver.context(newcontext));

        driver.getContext();
        Thread.sleep(25000);


        driver.findElement(By.xpath("//span[text()='Read Terms and Conditions']/..")).click();
        Thread.sleep(15000);

        status="passed";
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
