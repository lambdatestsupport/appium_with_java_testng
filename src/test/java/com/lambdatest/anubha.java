package com.lambdatest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.testng.annotations.Test;


public class anubha {

    public AndroidDriver driver;
    public String gridURL =  "@mobile-hub.lambdatest.com/wd/hub";
    String username = "deepanshulambdatest";
    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {

        //setup
        //UiAutomator2Options capabilities = new UiAutomator2Options();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("deviceName", "Galaxy S23");
        ltOptions.put("platformVersion", "13");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("app", "lt://APP1016033751689150153188799");
        capabilities.setCapability("lt:options", ltOptions);

        //options.setDeviceName("Pixel 4 API 33");
        //options.setChromedriverExecutable("/home//sz-test//Documents//Automation//chromedriver_linux64//chromedriver mobile");

        //options.setApp("//home//sz-test//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
        //options.setApp("//home//sz-test//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
        //options.setApp("//home//sz-test//eclipse-workspace//Appium//src//test//java//resources//15.0.3-1568-app-development.apk");

        //capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);

        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver = new AndroidDriver(new URL("http://" + username + ":" + authkey + gridURL), capabilities);

    }

    @Test
    public void testSimple() throws Exception
    {


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

        //Login
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("playground");
        driver.findElement(By.xpath("//android.widget.Button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.EditText)[2]")).isDisplayed());
        driver.findElement(By.xpath("(//android.widget.EditText)")).sendKeys("leo.muring+pg1@squadzip.com");
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("t$oyhwSks9");
    }
    public void LongpressAction(WebElement ele) {

        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",
                        ((RemoteWebElement)ele).getId(),
                        "duration",2000));

    }

    public void InputDateTimeZiptag() {

        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();

        //input date ziptag
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        new Actions(driver)
                .sendKeys("#"+dtf.format(now))
                .sendKeys(Keys.SPACE)
                .perform();

        //waiting for the create new ziptag modal and click Tag
        Assert.assertTrue(driver.findElement(By.id("com.digitalspaceexplorer.squadzip.development:id/textViewCreateZiptagTitle")).isDisplayed());
        driver.findElement(By.xpath("//android.widget.TextView[@text='Tag']")).click();

    }

    public void SwipeAction(WebElement ele, String direction) {

        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));

    }

    @AfterClass
    public void tearDown()
    {
        //quit device upon finishing testing
        driver.quit();
    }
}
