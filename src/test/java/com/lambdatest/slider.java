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


public class slider<IWebElement> {

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
        caps.setCapability("build", "slider march_28");
        caps.setCapability("name", "test1");
        // To view performance metrics
//        caps.setCapability("performance", true);
//        caps.setCapability("geoLocation", "GB");
        caps.setCapability("idleTimeout", 900);

        caps.setCapability("network", true);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {

//
              driver.get("https://jqueryui.com/resources/demos/slider/default.html");
              Thread.sleep(90000);

//            WebElement slider = driver.findElement(By.xpath("/html/body/div[1]"));
//
//              Thread.sleep(10000);
//
//            driver.switchTo().alert().accept();
//
//            //URL
//            driver.get("https://www.nike.com");
//            String a = driver.getTitle();
//            System.out.println(a);
//
//            IWebElement Slider = driver.findElement(By.xpath("//*[@id='abc']"))
//            Actions SliderAction = new Actions(driver);
//            Object Pixels;
//            SliderAction.ClickAndHold(Slider)
//                    .MoveByOffset((-(int)Slider.Size.Width / 2), 0)
//                    .MoveByOffset(Pixels, 0).Release().Perform();
//

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