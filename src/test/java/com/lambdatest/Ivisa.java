package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Ivisa {

    public RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "deepanshulambdatest";
        String authkey = "rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";

        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", "28th oct");
        caps.setCapability("name", "Java JUnit android");
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "Galaxy Note10 5G");
        caps.setCapability("app","lt://APP10160521021666957817172900");
        caps.setCapability("isRealMobile", true);
        caps.setCapability("platformVersion","12");
        //caps.setCapability("isAppAutomate",true);
        //caps.setCapability("fixedIP",  "00008020-001E65540A2A402E");
        caps.setCapability("console",true);
        caps.setCapability("network",true);
        //caps.setCapability("visual",true);
        HashMap<String, Object> playstorelogin = new HashMap<String, Object>();
//        playstorelogin.put("useremail", "varunp0211@gmail.com");
//        playstorelogin.put("password", "Varun@123");
//        caps.setCapability("playStoreLogin", playstorelogin);
        caps.setCapability("playStoreLogin", "{'email': 'varunp0211@gmail.com','password': 'Varun@123'}");
        //caps.setCapability("tunnel",true);
        caps.setCapability("devicelog",true);

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        //driver.manage().window().maximize();

//        driver.get("https://self-signed.badssl.com/");
//        Thread.sleep(5000);
         driver.findElement(By.id("com.mpokket.app:id/btn_next")).click();
         Thread.sleep(3000);
//        //driver.findElement(By.className("//XCUIElementTypeStaticText[@name=\"Start a New Application\"]")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Start a New Application\"]")).click();
         driver.findElement(By.id("com.mpokket.app:id/btn_next")).click();
         Thread.sleep(3000);

        driver.findElement(By.id("com.mpokket.app:id/btn_get_started")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("com.mpokket.app:id/cb")).click();
        Thread.sleep(3000);
//        Thread.sleep(10000);

        driver.findElement(By.id("com.mpokket.app:id/btn_continue")).click();
        Thread.sleep(50000);

        driver.findElement(By.id("com.mpokket.app:id/tv_google_login")).click();
        Thread.sleep(50000);
//        //driver.findElement(By.className("//XCUIElementTypeImage[@name=\"icon__forward-blue\"]")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeImage[@name=\"icon__forward-blue\"]")).click();
//
//        Thread.sleep(5000);
//
//        driver.refresh();
//        driver.swipe(400, 800, 400, 200, 2000);
//        //driver.findElement(By.className("//XCUIElementTypeStaticText[@name=\"American Samoa\"]")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"American Samoa\"]")).click();
//
//        Thread.sleep(5000);
//        //driver.findElement(By.className("//XCUIElementTypeStaticText[@name=\"Australia\"]")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Australia\"]")).click();
//
//        Thread.sleep(5000);
//        //driver.findElement(By.className("//XCUIElementTypeStaticText[@name=\"Home\"]")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Home\"]")).click();
//
//        Thread.sleep(5000);
//        MobileElement element= (MobileElement) driver.findElement(MobileBy.className("//XCUIElementTypeStaticText[@name=\"Bahrain\"]"));
//        //TouchAction swipe1 =  new TouchAction(driver).press(PointOption.point(196, 659)).moveTo(PointOption.point(194, 250)).release().perform();
//        TouchActions action = new TouchActions(driver);
//        action.scroll(element, 0, 100);
//        action.perform();
//
//        element.click();




        //Let's also assert that the todo we added is present in the list.

        //Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
        Status = "passed";
        // Thread.sleep(150);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}
