package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webautosimulators {

    private RemoteWebDriver driver;
//    private IOSDriver driver;
//       private AppiumDriver driver;
//    private AndroidDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", "sam");
        caps.setCapability("name", "test 1");
        caps.setCapability("autoAcceptAlerts", true); // for auto alerts
//        caps.setCapability("autoDissmissAlerts", true);
//        caps.setCapability("autoGrantPermissions", "true"); // for auto premission
        caps.setCapability("platformName", "ios");
        caps.setCapability("deviceName", "iPhone 13");
        caps.setCapability("platformVersion","15");
//        caps.setCapability("app", "stock");
//        caps.setCapability("bundleId","com.apple.mobilesafari");
//        caps.setCapability("platform", "Windows 11");
//        caps.setCapability("browserName", "MicrosoftEdge");
//        caps.setCapability("browserVersion", "105");
//        caps.setCapability("fixedIP","RF8M30TH73D");
//        caps.setCapability("geoLocation", "US");
//        caps.setCapability("app", "stock");
//        caps.setCapability("bundleId","com.apple.news");
        //caps.setCapability("tunnel", true);
//        caps.setCapability("fixedIP", "10.65.50.162");
        //caps.setCapability("enableNetworkThrottling", true);
        //caps.setCapability("networkThrottling", "Offline");
        //capabilities.setCapability("bundleId", "com.android.chrome");
//
        //capabilities.setCapability("app", "stock");
        //capabilities.setCapability("appPackage", "com.android.chrome");
//        String[] command = {"setValues", "setCookies", "getCookies"};
//        caps.setCapability("lambdaMaskCommands", command);
        //capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        caps.setCapability("console",true);
//        caps.setCapability("network",true);
        caps.setCapability("visual",true);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//        driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + hub), caps);

//        driver = new IOSDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//        driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + hub), caps);


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
        Thread.sleep(1000);
//        driver.manage().window().maximize();
        {

            driver.get("https://the-internet.herokuapp.com/geolocation");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
            Thread.sleep(25000);


//
//            driver.get("https://www.hightailfishing.com");
//            Thread.sleep(5000);
//
////            driver.findElement(By.xpath("nav[@class='layout_navbarContainer__5QNDP newNavBar']//span)[2]\\")).click();
////            Thread.sleep(5000);
//            driver.findElement(By.id("react-burger-menu-btn")).click();
//            Thread.sleep(5000);
//
////            driver.findElement(By.xpath("//*[@id=\"PageNavbarHeader\"]/a[2]/span")).click();
////            Thread.sleep(5000);
//            driver.findElement(By.xpath("//*[@id=\"mobile-header\"]/div/div[3]/div[1]/nav/nav/a[2]/span")).click();
//            Thread.sleep(5000);
//


//                driver.get("https://www.nike.com");
//                String a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.flipkart.com");
//                a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.tesla.com");
//                a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.lambdatest.com");
//                Thread.sleep(5000);
//                a = driver.getTitle();
//                System.out.println(a);
//
//               driver.get("https://www.lambdatest.com/pricing");
//               Thread.sleep(5000);
//               a = driver.getTitle();
//               System.out.println(a);



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