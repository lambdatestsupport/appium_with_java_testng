package com.lambdatest;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


public class mousehover {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Monterey");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "108");
        caps.setCapability("build", "March 22 test");
        caps.setCapability("name", "test1");
//        caps.setCapability("selenium_version", "4.0.0");
        // To view performance metrics
//        caps.setCapability("performance", true);
//        caps.setCapability("geoLocation", "GB");
        caps.setCapability("idleTimeout", 900);
//        caps.setCapability("DisableXFHeaders",true);
//        caps.setCapability("terminal", true);
//        caps.setCapability("tunnel", true);

//        caps.setCapability("name", m.getName() + this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");

        caps.setCapability("network", true);
        //caps.setCapability("network.har", true);
//        String[] Tags = new String[]{"Feature", "Tag", "Moderate"};
//        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
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


//            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
//            Thread.sleep(90000);
//
//            driver.findElement(By.xpath("/html/body/p[2]/a/img")).click();
//            Thread.sleep(10000);
//
//            driver.switchTo().alert().accept();
            driver.get("https://www.lambdatest.com");
                Thread.sleep(5000);
            String a = driver.getTitle();
                System.out.println(a);

            WebElement ele = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div[2]/div/div/div[1]/a[2]"));

//Creating object of an Actions class
            Actions action = new Actions(driver);

//Performing the mouse hover action on the target element.
            action.moveToElement(ele).perform();

//            await driver.wait(RemoteWebDriver.until.alertIsPresent());
//  const alertWindow = await driver.switchTo().alert();
//            await alertWindow.accept();
////              driver.refresh();
//              Thread.sleep(8000);

//            driver.get("http://ipinfo.io/");
//            Thread.sleep(80000);
//
//            driver.findElement(By.xpath("/html/body/div[7]/limespot-box/div/div[1]/ul/li[1]/div/div/button")).click();
//            Thread.sleep(5000);
//

//                //URL
//                driver.get("https://www.nike.com");
//                String a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.flipkart.com");
//                a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.tesla.com");
//                a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.myntra.com");
//                a = driver.getTitle();
//                System.out.println(a);
//
//                driver.get("https://www.lambdatest.com");
//                Thread.sleep(5000);
//                a = driver.getTitle();
//                System.out.println(a);
//
//               driver.get("https://www.lambdatest.com/pricing");
//               Thread.sleep(5000);
//               a = driver.getTitle();
//               System.out.println(a);

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