//package com.lambdatest;
//
//import com.sun.media.sound.SoftFilter;
//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
////import org.junit.Test;
//import io.appium.java_client.ios.IOSDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.SessionId;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.Keys;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.math.BigInteger;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.security.MessageDigest;
//
//public class pny {
//    String username = "deepanshulambdatest";
//    String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
//
//    private AppiumDriver driver;
//    private String status = "failed";
//
////    public static AppiumDriver driver = null;
//    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
////    public String status = "passed";
//    @BeforeTest
//    public void setUp() throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("name", "test 1");
//        capabilities.setCapability("build", "paynearby fixed IP");
//
//        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformVersion", "12");
//        capabilities.setCapability("platformName", "android");
//        capabilities.setCapability("deviceName", "Galaxy S22 5G");
//        capabilities.setCapability("geoLocation", "IN");
//        capabilities.setCapability("autoDismissAlerts", true);
//        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("appProfiling", true);
//        capabilities.setCapability("app","lt://APP1016045801682580694475216");
//        capabilities.setCapability("fixedIP","R5CT432AB9M");
//        //same caps as user
//        capabilities.setCapability("network", false);
//        capabilities.setCapability("console",true);
//        capabilities.setCapability("idleTimeout","180");
//        capabilities.setCapability("w3c", true);
//        capabilities.setCapability("noReset",false);
//        capabilities.setCapability("acceptSslCerts",true);
//        capabilities.setCapability("appPackage","com.paynearby.saathi.staging");
//        capabilities.setCapability("locationServicesAuthorized",true);
//        capabilities.setCapability("newCommandTimeout","5000");
//        capabilities.setCapability("resetKeyboard",true);
//        capabilities.setCapability("unicodeKeyboard",true);
//        capabilities.setCapability("deviceOrientation","PORTRAIT");
//        capabilities.setCapability("devicelog",true);
//
//
//
//        try
//        {
//            driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
//            Thread.sleep(5000);
//
//        }
//        catch (MalformedURLException e)
//        {
//            System.out.println("Invalid grid URL");
//        } catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    @Test
//    public void testSimple() throws Exception
//    {
//        try
//        {
//            Thread.sleep(30000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"A\"]")).click();
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue\"]")).click();
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Get Started\"]")).click();
//            Thread.sleep(10000);
//
//            driver.findElement(By.id("com.paynearby.saathi.staging:id/et_mobile")).sendKeys("8356956180");
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
//            Thread.sleep(10000);
//
//
//            WebElement button = driver.findElement(By.id("com.paynearby.saathi.staging:id/til_login_pin"));
//            Actions action = new Actions(driver);
//            action.click(driver.findElementById("com.paynearby.saathi.staging:id/til_login_pin")).sendKeys("123456").perform();
////            Actions actions = new Actions(driver);
////            actions.keyDown("1").keyUp("1").keyUp("2").keyDown("2").keyUp("3").keyDown("3").keyUp("4").keyDown("4").keyUp("5").keyDown("5").keyUp("6").keyDown("6").click(button).perform();
//
////            Actions actions = new Actions(driver);
//
////            actions.click(driver.findElement(By.id("com.paynearby.saathi.staging:id/til_login_pin"))).keyDown("1").keyUp("1").keyDown("2").keyUp("2").keyDown("3").keyUp("3").keyDown("4").keyUp("4").keyDown("5").keyUp("5").keyDown("6").keyUp("6").perform();
//
////            driver.findElement(By.id("com.paynearby.saathi.staging:id/otp_cnf_pin")).sendKeys("1");
////            driver.findElement(By.id("com.paynearby.saathi.staging:id/til_login_pin")).sendKeys("123456");
//            Thread.sleep(10000);
//
////            driver.findElement(By.xpath("//android.widget.LinearLayout[@index=\"1\"]")).sendKeys("123456");
//
//
//            status="passed";
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            status="failed";
//        }
//    }
//    @AfterTest
//    public void tearDown() throws Exception
//    {
////        if (driver != null)
////        {
//            driver.executeScript("lambda-status=" + status);
//            driver.quit();
//        }
//    }
//
