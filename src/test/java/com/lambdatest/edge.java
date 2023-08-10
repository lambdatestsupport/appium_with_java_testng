package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


public class edge {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Edge");
        caps.setCapability("browserVersion", "112");
        caps.setCapability("build", "test LE");
        caps.setCapability("name", "test1");
        caps.setCapability("seleniumVersion", "4.0.0");
//        caps.setCapability("fixedIP", "10.243.32.10");
        // To view performance metrics
        caps.setCapability("performance", true);
//        caps.setCapability("geoLocation", "GB");
        caps.setCapability("idleTimeout", 900);
        caps.setCapability("console", "true");


//        caps.setCapability("network", true);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
//        System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32 (1)//chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {

//
//              driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
//              Thread.sleep(90000);
//
//              driver.findElement(By.xpath("/html/body/p[2]/a/img")).click();
//              Thread.sleep(10000);
//
//            driver.switchTo().alert().accept();
//////
//            await driver.wait(RemoteWebDriver.until.alertIsPresent());
//  const alertWindow = await driver.switchTo().alert();
//            await alertWindow.accept();
////              driver.refresh();
//              Thread.sleep(8000);

//            driver.get("http://ipinfo.io/");
//            Thread.sleep(80000);
//
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

            //URL
            driver.get("https://www.nike.com");
            String a = driver.getTitle();
            System.out.println(a);

            driver.get("https://www.flipkart.com");
            a = driver.getTitle();
            System.out.println(a);

            driver.get("https://www.tesla.com");
            a = driver.getTitle();
            System.out.println(a);

            driver.get("https://www.youtube.com");
            a = driver.getTitle();
            System.out.println(a);

            driver.get("https://www.lambdatest.com");
            Thread.sleep(5000);
            a = driver.getTitle();
            System.out.println(a);


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