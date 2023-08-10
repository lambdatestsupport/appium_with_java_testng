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


public class webdesktop {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String url = "https://" + username+ ":"+ authkey+ "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "108");
//        caps.setCapability("platform", "MacOS Monterey");
//        caps.setCapability("browserName", "Safari");
//        caps.setCapability("browserVersion", "15");
//        caps.setCapability("build", "tunnel test");
        caps.setCapability("name", "test1");
//        caps.setCapability("network.full.har", true);
//        caps.setCapability("fixedIP", "10.243.32.10");
        // To view performance metrics
        caps.setCapability("performance", true);
//        caps.setCapability("geoLocation", "GB");
        caps.setCapability("idleTimeout", 900);
        caps.setCapability("console", "true");

//        caps.setCapability("build", "BUILD NAME"); //Passing build name
//        caps.setCapability("name", platform +"/"+ deviceName); //Passing test name dynamically
//        caps.setCapability("tunnel", true);
//        caps.setCapability("tunnelName","bestegg");
//        caps.setCapability("DisableXFHeaders",true);
//        caps.setCapability("terminal", true);
//        caps.setCapability("tunnel", true);
//        caps.setCapability("headless", true);

//        caps.setCapability("name", m.getName() + this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");

        caps.setCapability("network", true);
//        caps.setCapability("network.har", true);
//        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
//        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL(url), caps);
//        WebDriver driver = new ChromeDriver;
//                SessionId session = driver.getSessionId();
//                System.out.println(session);
//                String SL = "https://automation.lambdatest.com/logs/?sessionID=" + session;
//                System.out.println(SL);
//
//
//        MessageDigest z =MessageDigest.getInstance("MD5");
//        String s = "deepanshulambdatest:rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
//        z.update(s.getBytes(),0,s.length());
//        String Y = new BigInteger(1,z.digest()).toString(16);
//        System.out.println("MyOutputValue: "+ Y);
//
//
//                //"ebcc6cf979e0e2bc35633080643de01b";
//
//        String X = "https://automation.lambdatest.com/public/video?sessionID=" + session + "&auth=" + Y;
//        System.out.println(X);

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

////
//            driver.get("http://localhost/varunwa/module1.html");
//            Thread.sleep(20000);
//
//            driver.findElement(By.xpath("/html/body/div[2]/button")).click();
//            Thread.sleep(10000);
//
//
//            driver.findElement(By.xpath("/html/body/div[7]/div[3]/button")).click();
//            Thread.sleep(10000);
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
                Thread.sleep(3000);
//                String a = driver.getTitle();
//                System.out.println(a);

                driver.get("https://www.flipkart.com");
            Thread.sleep(3000);
//                a = driver.getTitle();
//                System.out.println(a);

                driver.get("https://www.tesla.com");
            Thread.sleep(3000);
//                a = driver.getTitle();
//                System.out.println(a);

                driver.get("https://www.youtube.com");
            Thread.sleep(3000);
//                a = driver.getTitle();
//                System.out.println(a);

                driver.get("https://www.lambdatest.com");
            Thread.sleep(3000);
//                a = driver.getTitle();
//                System.out.println(a);






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