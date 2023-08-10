package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class locationPopup {

    //private RemoteWebDriver driver;
    private AppiumDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {

        String username = "deepanshulambdatest";
        String authkey = "rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "MacOS Catalina");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("version", "104");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "Galaxy S10");
        //caps.setCapability("tunnel",true);
        caps.setCapability("isRealMobile", true);
        caps.setCapability("build", "7th oct");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        //caps.setCapability("fixedIP", "10.243.32.46");
        caps.setCapability("autoGrantPermissions", true);
        //caps.setCapability("network", true);
        //caps.setCapability("terminal", true);

        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);

        driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        //driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/geolocation");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        Thread.sleep(5000);

        // To accept/block the popup, you need to switch the context to “NATIVE_APP“ and click on the Allow/Block button.
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
        Thread.sleep(5000);
        driver.context("CHROMIUM");

//        Select Dropdown=  new Select(driver.findElement(By.xpath("//*[@id=\"aos\"]")));
//        Dropdown.selectByVisibleText("Education");
//
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
//        Select Dropdown1 = new Select(driver.findElement(By.xpath("/html/body/main/form/section/div[2]/div/div/section[1]/section[1]/div[2]/select")));
//        //  Select Dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"degree\"]")));
//
//        Dropdown1.selectByVisibleText("Associate's");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//
//        Select Dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"program\"]")));
//
//        Dropdown2.selectByVisibleText("Early Childhood Development");
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //driver.findElement(By.id("btnContinue")).click();
//        driver.findElement(By.xpath("/html/body/main/form/section/div[2]/div/div/section[1]/section[1]/button")).click();

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



