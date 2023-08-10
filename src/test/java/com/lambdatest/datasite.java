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


public class datasite {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "107");
        caps.setCapability("build", "7th dec");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        //caps.setCapability("fixedIP", "10.130.34.1");
        caps.setCapability("network", true);
        caps.setCapability("network.full.har", true);
        //caps.setCapability("geoLocation", "US");
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
//
//            driver.get("https://lambdatest.github.io/sample-todo-app/");
//
//
//            System.out.println("Checking Box");
//
//            driver.findElement(By.name("li1")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li2")).click();
//
//            System.out.println("Checking Box");
//            driver.findElement(By.name("li3")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li4")).click();
//
//            driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//            driver.findElement(By.id("addbutton")).click();
//
//            driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//            driver.findElement(By.id("addbutton")).click();
//
//            driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//            driver.findElement(By.id("addbutton")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li1")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li3")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li7")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li8")).click();
//
//            System.out.println("Entering Text");
//            driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//
//            driver.findElement(By.id("addbutton")).click();
//
//            System.out.println("Checking Another Box");
//            driver.findElement(By.name("li9")).click();
//
//            // Let's also assert that the todo we added is present in the list.
//
//            spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
//            Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
//
//            //URL
//            driver.get("https://www.nike.com");
//            //GET TITLE
//            String a = driver.getTitle();
//            //PRINT TITLE
//            System.out.println(a);
//            driver.get("https://www.flipkart.com");
//            a = driver.getTitle();
//
//            System.out.println(a);
//            driver.get("https://www.tesla.com");
//            a = driver.getTitle();
//
//            System.out.println(a);
//            driver.get("https://www.myntra.com");
//            a = driver.getTitle();
//
//            System.out.println(a);

            driver.get("https://login.dev.datasite.com/login/");
            Thread.sleep(4000);

            driver.findElement(By.id(":r0:")).sendKeys("apiops_dev_ssodrmuser@ssodatasite.mailinator.com");
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]")).click();
            Thread.sleep(3000);

//            driver.get("merrill-poc.okta.com");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("okta-signin-username")).sendKeys("apiops_dev_ssodrmuser@ssodatasite.mailinator.com");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("okta-signin-password")).sendKeys("Test@1234");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("okta-signin-submit")).click();
//            Thread.sleep(30000);

            //GET TITLE
//            String a = driver.getTitle();
//            //PRINT TITLE
//            System.out.println(a);
//            driver.get("https://www.flipkefdcsdd.com");
//            a = driver.getTitle();
//
//            System.out.println(a);
//            driver.get("https://www.tesla.com");
//            a = driver.getTitle();
//
//            System.out.println(a);
//            driver.get("https://www.myntra.com");
//            a = driver.getTitle();
//
//            System.out.println(a);

        }
        Status = "passed";
        Thread.sleep(800);
        System.out.println("TestFinished");


    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
//        driver.quit();
    }

}