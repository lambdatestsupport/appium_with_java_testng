package com.lambdatest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class contrast {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {

        String username = "deepanshulambdatest";
        String authkey = "rsoHTTxvRGQOV7jvQJJwPzKYQSyXYHKqC3SOgIWgKJ9G9sWZbk";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "102");
        caps.setCapability("lambdatest.highContrast", "true");
        caps.setCapability("build", "11TH OCT");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("network", true);
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("geoLocation", "IN");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        caps.setCapability(ChromeOptions.CAPABILITY, options);


        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }
    @Test
    public void basicTest() throws InterruptedException {

        driver.get("https://www.google.com");
        Thread.sleep(20000);
        // find the search edit box on the google page
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Lambdatest");
        element.submit();
        System.out.println(driver.getTitle());

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