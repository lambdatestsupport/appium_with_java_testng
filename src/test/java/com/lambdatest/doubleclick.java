package com.lambdatest;
import java.awt.*;
import java.awt.event.InputEvent;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


public class doubleclick {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 11");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("browserVersion", "110");
        caps.setCapability("build", "Double click test");
        caps.setCapability("name", "On safari 15");
        caps.setCapability("platform", "MacOS Monterey");
        caps.setCapability("browserVersion", "15");
        caps.setCapability("browserName", "Safari");

        caps.setCapability("performance", true);

        caps.setCapability("idleTimeout", 900);
        caps.setCapability("console", "true");



        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);


    }

    @Test
    public void basicTest() throws InterruptedException, AWTException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {

            driver.get("https://demoqa.com/buttons");
            Thread.sleep(15000);
            Actions act = new Actions(driver);

//Double click on element
            WebElement ele = driver.findElement(By.id("doubleClickBtn"));
            Thread.sleep(3000);
            act.doubleClick(ele).perform();
            Thread.sleep(20000);


//            WebElement elementToDoubleClick = driver.findElement(By.id("doubleClickBtn"));

// Create an instance of the Actions class and perform a double click
//            Actions actions = new Actions(driver);
//            actions.doubleClick(elementToDoubleClick).build().perform();
//        }

//            driver.findElement(By.id("doubleClickBtn"));
//            Thread.sleep(20000);
//
//        Robot robot = new Robot();
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Status = "passed";
//        Thread.sleep(8000);
//        System.out.println("TestFinished");


    }


}
    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}