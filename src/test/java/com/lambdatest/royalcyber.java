package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class royalcyber {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Monterey");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "105");
        caps.setCapability("build", "royalcyber");
        caps.setCapability("name", "test1 ");


        caps.setCapability("network", true);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//        WebDriver driver = new ChromeDriver;
//                SessionId session = driver.getSessionId();
//                System.out.println(session);
//                String SL = "https://automation.lambdatest.com/logs/?sessionID=" + session;
//                System.out.println(SL);
//

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

            driver.get("https://www.soccer.com/shop/footwear");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"layoutContainers\"]/div/div/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[2]/div/ul/li[4]")).click();
            Thread.sleep(5000);


//
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

