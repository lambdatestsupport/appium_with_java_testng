package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


public class spencer {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "Galaxy S22 5G");
        caps.setCapability("platformVersion", "13");
//        caps.setCapability("platform", "Windows 11");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("browserVersion", "108");
        caps.setCapability("build", "spencer");
        caps.setCapability("name", "test1");
        caps.setCapability("idleTimeout", 900);
        caps.setCapability("console", "true");
//        caps.setCapability("DisableXFHeaders",true);
//        ca

        caps.setCapability("network", true);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//        WebDriver driver = new ChromeDriver;
//
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
//        driver.manage().window().maximize();
        {

            driver.get("https://www.spencersonline.com");
            Thread.sleep(30000);


            if(driver.findElement(By.xpath("//div[@id='ltkpopup-close-button']")).isDisplayed())
            {
                driver.findElement(By.xpath("//div[@id='ltkpopup-close-button']")).click();
                Thread.sleep(10000);
            }

            if(driver.findElement(By.cssSelector("#signInContainer > div > span > a")).isDisplayed())
            {
                driver.findElement(By.cssSelector("#signInContainer > div > span > a")).click();
                Thread.sleep(18000);
            }

            if(driver.findElement(By.cssSelector("#userName")).isDisplayed())
            {
                driver.findElement(By.cssSelector("#userName")).sendKeys("deepanshu@lambdatest.com");
                Thread.sleep(18000);
            }

            driver.findElement(By.cssSelector("password")).sendKeys("Test@124");
            Thread.sleep(18000);

            if(driver.findElement(By.cssSelector("#loginForm > div > input[type=submit]")).isDisplayed())
            {
                driver.findElement(By.cssSelector("#loginForm > div > input[type=submit]]")).click();
                Thread.sleep(18000);
            }
////            driver.findElement(By.xpath("//*[@id=\"signInContainer\"]")).click();
////            Thread.sleep(8000);
//
////            driver.findElement(By.id("signInContainer")).click();
////            Thread.sleep(3000); //*[@id="signInContainer"], //*[@id="signInContainer"]/div, //*[@id="signInContainer"]/div/span, //*[@id="signInContainer"]/div/span/a
//
//
//            if(driver.findElement(By.xpath("//*[@id=\"signInContainer\"]")).isDisplayed())
//            {
//                driver.findElement(By.id("userName")).sendKeys("deepanshu@lambdatest.com");
//                Thread.sleep(8000);
//            }
//
//            driver.findElement(By.id("password")).sendKeys("Test@124");
//            Thread.sleep(8000);
//
//            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div/div[2]/form/div/input\n")).click();
//            Thread.sleep(8000);
//
//            driver.findElement(By.xpath("/html/body/div[3]/div/header/div[1]/div[3]/div[2]/ul/li[5]/a")).click();
//            Thread.sleep(8000);
//
//            driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div[2]/dl/dt[2]/a")).click();
//            Thread.sleep(8000);
//
//
//            driver.findElement(By.id("firstName")).sendKeys("ABc");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("lastName")).sendKeys("DEf");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("address1")).sendKeys("asdfg");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("city")).sendKeys("delhi");
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