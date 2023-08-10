package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class dropdown
{
    //private RemoteWebDriver driver;
    //private AndroidDriver driver;
    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        String hub = "@hub-virginia.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "104");
//        caps.setCapability("platformVersion", "12");
//        caps.setCapability("platformName", "android");
//        caps.setCapability("deviceName", "Galaxy S20 Ultra");
        //caps.setCapability("tunnel",true);
        //caps.setCapability("isRealMobile", true);
        caps.setCapability("build", "27th dec");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        //caps.setCapability("fixedIP", "10.243.32.46");
        caps.setCapability("geoLocation", "US");
        //caps.setCapability("autoGrantPermissions", true);
        //caps.setCapability("network", true);
        //caps.setCapability("terminal", true);

        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);

        //driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);


        ChromeOptions options = new ChromeOptions();
        Map < String, Object > prefs = new HashMap < String, Object > ();
        Map < String, Object > profile = new HashMap < String, Object > ();
        Map < String, Object > contentSettings = new HashMap < String, Object > ();

        contentSettings.put("geolocation", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        caps.setCapability(ChromeOptions.CAPABILITY, options);


    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();


//        driver.get("https://onlinedegrees.purdue.edu/purdue-global/");
//          Select Dropdown=  new Select(driver.findElement(By.xpath("//*[@id=\"aos\"]")));
//            Dropdown.selectByVisibleText("Education");
//
//
//             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
//          Select Dropdown1 = new Select(driver.findElement(By.xpath("/html/body/main/form/section/div[2]/div/div/section[1]/section[1]/div[2]/select")));
//    //  Select Dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"degree\"]")));
//
//            Dropdown1.selectByVisibleText("Associate's");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//
//          Select Dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"program\"]")));
//
//     Dropdown2.selectByVisibleText("Early Childhood Development");
//
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//       //driver.findElement(By.id("btnContinue")).click();
//       driver.findElement(By.xpath("/html/body/main/form/section/div[2]/div/div/section[1]/section[1]/button")).click();
//
//        Status = "passed";
//        Thread.sleep(800);
//        System.out.println("TestFinished");


       // driver.get("https://americanservicepets.com/pet-info/da00f1b8-9245-48b4-82c2-ec4a04922daa");
         //Thread.sleep(10000);

         driver.get("https://americanservicepets.com/pet-info/7926ba29-a563-4213-a435-4ad7d9380e7c");
         Thread.sleep(10000);


//        driver.context("NATIVE_APP");
//        driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
//        Thread.sleep(5000);
//        driver.context("CHROMIUM");
//
//        driver.findElement(By.id("ltkpopup-close-button")).click();
//        Thread.sleep(3000);
//        Select Dropdown=  new Select(driver.findElement(By.id("SIZE_NAME231435")));
//            Dropdown.selectByValue("ADULT SMALL");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        Select objSelect = new Select(driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div[1]/form/div/div[2]/div[1]/div/div[3]/div/div/button")));
        objSelect.selectByVisibleText("Cat");

//        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div[1]/form/div/div[2]/div[1]/div/div[3]/div/div")).click();
//        Thread.sleep(3000);
//        Select Dropdown=  new Select(driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div[1]/form/div/div[2]/div[1]/div/div[3]/div/div/button")));
//        Dropdown.selectByValue("cat");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div[1]/form/div/div[2]/div[3]/div/div[2]/div/div")).click();
        Thread.sleep(20000);

//            Select Dropdown1 = new Select(driver.findElement(By.xpath("viewPageChoice")));
//            Dropdown1.selectByVisibleText("48 per page");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//
//          Select Dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"program\"]")));
//
//     Dropdown2.selectByVisibleText("Early Childhood Development");
//
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//       //driver.findElement(By.id("btnContinue")).click();
//       driver.findElement(By.xpath("/html/body/main/form/section/div[2]/div/div/section[1]/section[1]/button")).click();
//
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
