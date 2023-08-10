package com.lambdatest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.util.Strings;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class throttling {


    public static final String userName = "deepanshulambdatest";
    public static final String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


    public static void main (String[] args) throws MalformedURLException, InterruptedException {


//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("browserVersion", "93.0");
//        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//        browserstackOptions.put("os", "Windows");
//        browserstackOptions.put("osVersion", "10");
//        browserstackOptions.put("local", "false");
//       // browserstackOptions.put("seleniumVersion", "3.14.0");
//        capabilities.setCapability("bstack:options", browserstackOptions);



        DesiredCapabilities capabilities = new DesiredCapabilities();
        //  capabilities.setCapability("browserName", "Chrome");
        //  capabilities.setCapability("browserVersion", "101.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "deepanshulambdatest");
        ltOptions.put("accessKey", "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("browserName","chrome");
        ltOptions.put("name","windows10");
        ltOptions.put("browserVersion","108.0");
        //  ltOptions.put("project", "Untitled");
        //  ltOptions.put("geoLocation", "US");
        ltOptions.put("enableNetworkThrottling",true);
        // ltOptions.put("deviceName","iPad Air");
        // ltOptions.put("platformVersion","10.3");
        // ltOptions.put("region","us");
        capabilities.setCapability("LT:Options", ltOptions);

        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);




        ArrayList<Object> networkProfile =new ArrayList();
        HashMap<String,Object> condition= new HashMap<String, Object>();
        HashMap<String,Object> condition2= new HashMap<String, Object>();
        condition.put("download",500);
        condition.put("latency",30);
        condition.put("upload",100);
        // condition2.put("condition",condition);

        networkProfile.add(condition);

        System.out.println(networkProfile);

        driver.get("https://www.apple.com/");


        Thread.sleep(8000);


        ((JavascriptExecutor) driver).executeScript("lambda-throttle-network","offline");


        Thread.sleep(5000);

        driver.get("https://www.amazon.com/");


        Thread.sleep(5000);




        //  driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div[2]/div[3]/div[1]/a/span[4]")).click();

        //   ((JavascriptExecutor) driver).executeScript("lambda-throttle-network","Regular 4G");




//        driver.get("https://fast.com/");
//
//        Thread.sleep(8000);
//
//
//        ((JavascriptExecutor) driver).executeScript("lambda-throttle-network","Regular 2G");

        // driver.get("https://fast.com/");

        // Thread.sleep(8000);
//        driver.get("https://www.apple.com/");
//        ((JavascriptExecutor) driver).executeScript("lambda-throttle-network","offline");


        // driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/main/div[1]/div/button")).click();

//        driver.manage().addCookie(name);
//        driver.manage().addCookie(name1);
//        driver.manage().addCookie(name2);



        // driver.get("https://www.instagram.com/accounts/login/");
//
//        driver.findElement(By.xpath("//*[@id=\"enterprise-fatFooter\"]/div[1]/div/a[1]")).click();
//        Thread.sleep(4000);
//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        Thread.sleep(2000);
//        driver.findElement(By.name("username")).sendKeys("rathoreshub22@gmail.com");
//        driver.findElement(By.name("password")).sendKeys("Shub@123456789");
//
//        driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div[2]/form/div/div[3]/button")).click();


        Thread.sleep(50000);
        driver.quit();
    }
}