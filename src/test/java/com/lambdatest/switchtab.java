package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class switchtab {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Ventura");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("browserVersion", "16");
        caps.setCapability("build", "switch tab");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
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
//            driver.get("https://www.nike.com");
//
//          Thread.sleep(5000);
////            psdbComponent.clickDocumentLink();
//            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//            driver.switchTo().window(tabs2.get(1));
//            driver.close();
//            driver.switchTo().window(tabs2.get(0));
//
//            driver.get("https://www.flipkart.com");
//            Thread.sleep(9000);
//
//            String parentWindow = driver.getWindowHandle();

            //Open a new Windows(Mailtrap)
            String a = "window.open('https://google.com);";
            ((JavascriptExecutor)driver).executeScript(a);


            //Take control over new browser
            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            //Make the same actions over new window
//            driver.manage().window().maximize();

            driver.switchTo().defaultContent();
            driver.close();
//            driver.switchTo().window(parentWindow);
            driver.switchTo().defaultContent();


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