package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webautord {

//    public RemoteWebDriver driver;
     private AppiumDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "deepanshulambdatest";
        String accessKey = "vvI4dCayA0O65Pzpj2mUqdOtwPIYfVlpEnX3OQtzLJDgQdAJME";


        String hub = "@mobile-hub.lambdatest.com/wd/hub";


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "august 7");
        capabilities.setCapability("name", "test 1");

        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel.*");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("devicelog",true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("autoDismissAlerts", true);





//        capabilities.setCapability("deviceName", "Galaxy.*");
//        capabilities.setCapability("platformVersion","12");
//        capabilities.setCapability("networkThrottling", "Regular 2G");

//        capabilities.setCapability("app","lt://APP10160531401673866238048707");

//        capabilities.setCapability("platformVersion", "12");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", ".*");

//        caps.setCapability("browserName", "Safari");
//        caps.setCapability("browserVersion", "latest");
//        caps.setCapability("platformName", "OS X Mountain Lion");

//        capabilities.setCapability("fixedIP", "");
//        proverbial app link above
//        caps.setCapability("platform", "macOS Monterey");

//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("browserVersion", "106");
//        caps.setCapability("version", "latest"); capabilities.setCapability("build", "rapido ap region");
//        capabilities.setCapability("region", "AP");
//        caps.setCapability("name", "attempt_2 with safari 6");
//        capabilities.setCapability("fixedIP",  "00008103-000E246C36E8801E");
        //capabilities.setCapability("bundleId", "com.android.chrome");
        //capabilities.setCapability("app", "stock");
        //capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("console",true);

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setCapability("platformName", "Windows 10");
//        browserOptions.setCapability("browserVersion","107.0");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "deepanshulambdatest");
//        ltOptions.put("accessKey", "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs");
//        ltOptions.put("project", "Conduent with selenium 4");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        browserOptions.setCapability("LT:Options", ltOptions);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("w3c", true);
//        ltOptions.put("platformName", "android");
//        ltOptions.put("deviceName", "Pi");
//        ltOptions.put("platformVersion", "11");
//        ltOptions.put("isRealMobile", true);
//        capabilities.setCapability("lt:options", ltOptions);
//        ltOptions.put("username", "deepanshulambdatest");
//        ltOptions.put("accessKey", "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs");
//        ltOptions.put("project", "Conduent with selenium 4");
//        ltOptions.put("app","lt://APP10160531401673437586127671");
//        ltOptions.put("enableCustomTranslation", true);
//
//        ltOptions.put("selenium_version", "4.1.2");
//        ltOptions.put("timezone", "UTC+10:00");

        //  ltOptions.put("geoLocation", "US");
//        ltOptions.put("enableNetworkThrottling",true);
        // ltOptions.put("region","us");
//        browserOptions.setCapability("LT:Options", ltOptions);

//        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + authKey + "@hub.lambdatest.com/wd/hub"), browserOptions);
        driver = new AppiumDriver(new URL("https://" + username + ":" + accessKey + hub), capabilities);


    }

    @Test
    public void basicTest() throws InterruptedException {

        String spanText;
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        System.out.println("Checking Box");

        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li4")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
        driver.findElement(By.id("addbutton")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li7")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li8")).click();

        System.out.println("Entering Text");
        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");

        driver.findElement(By.id("addbutton")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li9")).click();

        // Let's also assert that the todo we added is present in the list.

        spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
        Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);


      driver.get("https://www.nike.com");
     Thread.sleep(5000);

      driver.get("https://www.flipkart.com");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div")).click();
        Thread.sleep(3000);


        driver.get("https://www.tesla.com");
        Thread.sleep(5000);


      driver.get("https://www.lambdatest.com");
      Thread.sleep(5000);


     driver.get("https://www.lambdatest.com/pricing");
     Thread.sleep(5000);



    // Let's also assert that the todo we added is present in the list.

    Status ="passed";
    // Thread.sleep(150);

        System.out.println("TestFinished");
}



    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}