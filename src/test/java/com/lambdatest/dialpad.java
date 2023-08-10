package com.lambdatest;
import io.appium.java_client.AppiumDriver;
import okhttp3.*;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.*;

import io.appium.java_client.MobileBy;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
public class dialpad {
    String username = "deepanshulambdatest";
    String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    //public static RemoteWebDriver driver = null;
    private AppiumDriver driver;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "Dialpad Dec 15th");
        capabilities.setCapability("name", "Dialpad iOS");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","15");
        //capabilities.setCapability("lambdaTest.maskCommands", "setValues, getValues, setCookies, getCookies");
        capabilities.setCapability("app", "lt://APP10160621161671097911651597");
        //capabilities.setCapability("deviceOrientation", "PORTRAIT");
        //capabilities.setCapability("fixedIP", "RFCN102VK0D");
        //capabilities.setCapability("networkThrottling", "Offline");
        //capabilities.setCapability("geoLocation", "US");
        //capabilities.setCapability("enableNetworkThrottling", "true");
        //capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("console",true);
        capabilities.setCapability("network",true);
        //capabilities.setCapability("visual",true);

        try
        {
            //driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + gridURL), capabilities);
            driver = new AppiumDriver(new URL("https://" + username + ":" + accessKey + gridURL), capabilities);

        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        SessionId session = driver.getSessionId();
    }

    @Test
    public void testSimple() throws Exception
    {
        try
        {
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Start making calls\"]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//XCUIElementTypeTextField[@value=\"Email\"]")).sendKeys("sogecop234@nicoimg.com");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value=\"Password\"]")).sendKeys("Password123@@");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"LOG IN\"]")).click();
            Thread.sleep(10000);
//            driver.findElement(By.id("com.uberconference.beta:id/login")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("com.uberconference.beta:id/email")).sendKeys("histemirte@biyac.com");
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("com.uberconference.beta:id/password")).sendKeys("test1234!!");
//            Thread.sleep(3000);

//            OkHttpClient client = new OkHttpClient().newBuilder().build();
//            MediaType mediaType = MediaType.parse("application/json");
//            RequestBody body = RequestBody.create(mediaType, "{\n    \"mode\": \"offline\"\n}");
//            String A = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/"+driver.getSessionId().toString()+"/update_network";
//            System.out.println(A);
//            Request request = new Request.Builder()
//                    .url(A)
//                    .method("POST", body)
//                    .addHeader("Authorization", "Basic ZGVlcGFuc2h1bGFtYmRhdGVzdDpyc29IVFR4dlJHUU9WN2p2UUpKd1B6S1lRU3lYWUhLcUMzU09nSVdnS0o5RzlzV1piaw==")
//                    .addHeader("Content-Type", "application/json")
//                    .build();
//            Response response = client.newCall(request).execute();
//            System.out.println(response.code());
//            gridURL = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/" + driver.getSessionId() + "/update_network";
////            driver.findElement(By.id("android:id/button1")).click();
//            Thread.sleep(20000);
//
//            OkHttpClient client2 = new OkHttpClient().newBuilder().build();
//            MediaType mediaType2 = MediaType.parse("application/json");
//            RequestBody body2 = RequestBody.create(mediaType2, "{\n    \"mode\": \"online\"\n}");
//            String B = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/"+driver.getSessionId().toString()+"/update_network";
//            System.out.println(B);
//            Request request2 = new Request.Builder()
//                    .url(A)
//                    .method("POST", body2)
//                    .addHeader("Authorization", "Basic ZGVlcGFuc2h1bGFtYmRhdGVzdDpyc29IVFR4dlJHUU9WN2p2UUpKd1B6S1lRU3lYWUhLcUMzU09nSVdnS0o5RzlzV1piaw==")
//                    .addHeader("Content-Type", "application/json")
//                    .build();
//            Response response2 = client2.newCall(request2).execute();
//            System.out.println(response2.code());
//            gridURL = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/" + driver.getSessionId() + "/update_network";
//
//            Thread.sleep(5000);

//            driver.findElement(By.id("com.uberconference.beta:id/login")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("android:id/button1")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("com.uberconference.beta:id/startConference")).click();
//            Thread.sleep(2000);
//
//            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
//            Thread.sleep(2000);
//
//            driver.findElement(By.id("com.uberconference.beta:id/joinNow")).click();
//            Thread.sleep(8000);
//
////            driver.findElement(By.id("com.uberconference.beta:id/emptyRoomView")).click();
////            Thread.sleep(5000);
////
////            driver.findElement(By.id("com.uberconference.beta:id/emptyRoomView")).click();
////            Thread.sleep(5000);
//
//            driver.findElement(By.id("com.uberconference.beta:id/hangUp")).click();
//            Thread.sleep(9000);
//
//            driver.findElement(By.id("com.uberconference.beta:id/primaryAction")).click();
//            Thread.sleep(10000);


            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
        System.out.println("TestFinished");
    }
    @AfterTest
    public void tearDown() throws Exception
    //public void tearDown()
    {
        if (driver != null)
        {
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
