package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import java.net.URL;
import java.util.Set;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class capgemini
{
    //private AndroidDriver driver;
    private IOSDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {

        String username = "deepanshulambdatest";
        String authkey = "rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformVersion", "15.0");
//        caps.setCapability("platformName", "ios");
//        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "104");
        //caps.setCapability("tunnel",true);
        //caps.setCapability("isRealMobile", true);
        caps.setCapability("build", "9th nov capegemini");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("geoLocation", "IN");
        caps.setCapability("autoAcceptAlerts", true);
        //caps.setCapability("autoGrantPermissions", true);
        //caps.setCapability("network", true);
        //caps.setCapability("terminal", true);

        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);

        //driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        driver = new IOSDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        //IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("https://" + username + ":" + authkey + hub), caps);


    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
//
//        driver.get("https://www.spencersonline.com/product/scary-movies-and-chill-t-shirt-steven-rhodes/231435.uts");
//        Thread.sleep(20000);


//        driver.context("NATIVE_APP");
//        driver.findElement(By.name("Allow")).click();
        //driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
       // Thread.sleep(5000);
        //driver.context("CHROMIUM");
//        driver.findElement(By.cssSelector("#ltkpopup-close-button")).click();
//        Thread.sleep(5000);
//        Select Dropdown=  new Select(driver.findElement(By.xpath("//*[@id=\"SIZE_NAME231435\"]")));
//        Dropdown.selectByValue("ADULT SMALL");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        driver.get("https://www.spencersonline.com/product/adult-byte-off-t-shirt-stranger-things/237460.uts");
        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement flag=driver.findElement(By.id("goto_desc"));
        js.executeScript("arguments[0].scrollIntoView();",flag);
        System.out.println("1");
            Select Dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"SIZE_NAME237460\"]")));
        System.out.println("2");
            Dropdown1.selectByValue("ADULT MEDIUM");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

