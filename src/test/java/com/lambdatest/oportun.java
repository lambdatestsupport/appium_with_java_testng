package com.lambdatest;
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


public class oportun {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "108");
        caps.setCapability("build", "oportun");
        caps.setCapability("name", "test1");
//        caps.setCapability("fixedIP", "10.243.32.10");
        // To view performance metrics
//        caps.setCapability("geoLocation", "GB");
        caps.setCapability("idleTimeout", 900);
        caps.setCapability("console", "true");
//        caps.setCapability("DisableXFHeaders",true);
//        caps.setCapability("terminal", true);
//        caps.setCapability("tunnel", true);
//        caps.setCapability("headless", true);

//        caps.setCapability("name", m.getName() + this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");

        caps.setCapability("network", true);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
//
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {

//
         driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_table_hover");
         Thread.sleep(3000);
//
//            WebElement ele = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]"));
//
////Creating object of an Actions class
//            Actions action = new Actions(driver);
//
////Performing the mouse hover action on the target element.
//            action.moveToElement(ele).perform();
//
//
//            WebElement ele1 = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[1]"));
//
////Creating object of an Actions class
//            Actions action1 = new Actions(driver);
//
////Performing the mouse hover action on the target element.
//            action1.moveToElement(ele1).perform();
////
//            driver.findElement(By.xpath("/html/body/table/tbody/tr[2]")).click();
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[1]")).click();
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[1]")).click();
//            Thread.sleep(3000);


        }
        Status = "passed";
        Thread.sleep(800);
        System.out.println("TestFinished");


    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}