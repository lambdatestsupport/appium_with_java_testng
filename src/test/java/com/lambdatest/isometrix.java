package com.lambdatest;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isometrix {

        private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", "ISOMETRIX");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);
        // caps.setCapability("name", "Java JUnit iOS iPhone");
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "105");
        //caps.setCapability("fixedIP", "10.65.32.39");
//        caps.setCapability("geoLocation", "US");
        caps.setCapability("console",true);
//        caps.setCapability("network",true);
        caps.setCapability("visual",true);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);



//        SessionId session = driver.getSessionId();
//        System.out.println(session);
//        String A = "https://automation.lambdatest.com/logs/?sessionID=" + session;
//        System.out.println(A);
//
//
//        MessageDigest z =MessageDigest.getInstance("MD5");
//        String s = "deepanshulambdatest:rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
//        z.update(s.getBytes(),0,s.length());
//        String Y = new BigInteger(1,z.digest()).toString(16);
//        System.out.println("MyOutputValue: "+ Y);
//
//
//        //"ebcc6cf979e0e2bc35633080643de01b";
//
//        String X = "https://automation.lambdatest.com/public/video?sessionID=" + session + "&auth=" + Y;
//        System.out.println(X);


    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {

            driver.get("https://test-auth.isometrix.net/login.html");
            Thread.sleep(5000);
            driver.findElement(By.id("acceptCookie")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("email")).sendKeys("senzoautomation.testuser@gmail.com");
            Thread.sleep(5000);
            driver.findElement(By.id("processButton")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("password")).sendKeys("Cag87164");
            Thread.sleep(5000);
            driver.findElement(By.id("processButton")).click();
            Thread.sleep(15000);

            driver.findElement(By.xpath("//*[@aria-label='Navigation Panel'])[1]\\")).click();
            Thread.sleep(10000);





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