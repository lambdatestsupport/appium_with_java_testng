package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class masking {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "104");
        caps.setCapability("build", "14th nov");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        String[] command = {"setValues", "setCookies", "getCookies"};
        caps.setCapability("lambdaMaskCommands", command);

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
            driver.get("https://accounts.lambdatest.com/login");


            Thread.sleep(5000);

            driver.findElement(By.id("email")).sendKeys("deepanshu@lambdatest.com");

            Thread.sleep(8000);

            driver.findElement(By.id("password")).sendKeys("ZELda@48iiXm");
            Thread.sleep(100);

            driver.findElement(By.id("login-button")).click();
            Thread.sleep(8000);

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