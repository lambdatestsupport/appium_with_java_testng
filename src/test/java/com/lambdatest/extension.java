package com.lambdatest;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class extension {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("C:\\Users\\deepanshu\\Downloads\\Note-BoardSticky-Notes-App.crx"));
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "106");
        caps.setCapability("build", "13th dec");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        String[]chromeextention={"https://prod-magicleap-user-files-us-east-1-v1.s3.amazonaws.com/extensions/orgId-588659/Note-BoardSticky-Notes-App.zip"};
        caps.setCapability("loadExtension",chromeextention);

        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {

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
            //GET TITLE
            String a = driver.getTitle();
            //PRINT TITLE
            System.out.println(a);
            driver.get("https://www.flipkart.com");
            a = driver.getTitle();

            System.out.println(a);
            driver.get("https://www.tesla.com");
            a = driver.getTitle();

            System.out.println(a);
            driver.get("https://www.myntra.com");
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