package com.lambdatest;
import io.appium.java_client.AppiumDriver;
import okhttp3.*;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
public class throttling_ecto {
    String username = "deepanshulambdatest";
    String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    private AppiumDriver driver;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";
    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("build", "ECTO DEC 15th");
        capabilities.setCapability("name", "Ecto Vanilla android");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel 5");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion","11");
//        capabilities.setCapability("app", "lt://APP10160571881668597599753406");
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("deviceName", "iPhone 13");
//        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("app","lt://APP10160621161671105015438710");
        //capabilities.setCapability("networkThrottling", "Offline");
        //capabilities.setCapability("deviceOrientation", "LANDSCAPE");
        //capabilities.setCapability("geoLocation", "US");
        //capabilities.setCapability("enableNetworkThrottling", "true");
        //capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("console",true);
        //capabilities.setCapability("network",true);
        //capabilities.setCapability("visual",true);
        try
        {
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
//        System.out.println(session);
//        String A = "https://automation.lambdatest.com/logs/?sessionID=" + session;
//        System.out.println(A);
    }

    @Test
    public void testSimple() throws Exception
    {
        try
        {
            Thread.sleep(10000);
            //driver.findElement(By.xpath("//android.widget.EditText[@text=\"Username\"]")).sendKeys("dmytro.malkin@ecto.com");
            driver.findElement(By.xpath("//android.widget.EditText[@text=\"Username\"]")).sendKeys("dmytro.malkin@ecto.com");
//            driver.findElement(By.xpath("//*[@text=\\\"Username\\\"]|//*[@name=\\\"Username\\\"]")).sendKeys("dmytro.malkin@ecto.com");
//            Thread.sleep(9000);
//
//            driver.findElement(By.xpath("//*[@text=\\\"Password\\\"]|//*[@name=\\\"Password\\\"]")).sendKeys("dmytro.malkin@ecto.com");
//            //driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("$obaka_Zabiyaka");
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("//*[@text=\\\"SIGN IN\\\"]|//XCUIElementTypeOther[@name=\\\"SIGN IN\\\" and @index=2]")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Completed\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).click();

            OkHttpClient client = new OkHttpClient().newBuilder().build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n    \"mode\": \"offline\"\n}");
            String A = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/"+driver.getSessionId().toString()+"/update_network";
            System.out.println(A);
            Request request = new Request.Builder()
                    .url(A)
                    .method("POST", body)
                    .addHeader("Authorization", "Basic ZGVlcGFuc2h1bGFtYmRhdGVzdDpmOHhyOGVWN2hwSkppeE82c2JWbVBhekFINEM4Vm9BVWhFQU5QamlrYXlMVFhObEpLcw==")
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.code());
            gridURL = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/" + driver.getSessionId() + "/update_network";
            Thread.sleep(30000);

//            ZGVlcGFuc2h1bGFtYmRhdGVzdDpyc29IVFR4dlJHUU9WN2p2UUpKd1B6S1lRU3lYWUhLcUMzU09nSVdnS0o5RzlzV1piaw==
            OkHttpClient client2 = new OkHttpClient().newBuilder().build();
            MediaType mediaType2 = MediaType.parse("application/json");
            RequestBody body2 = RequestBody.create(mediaType2, "{\n    \"mode\": \"online\"\n}");
            String B = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/"+driver.getSessionId().toString()+"/update_network";
            System.out.println(B);
            Request request2 = new Request.Builder()
                    .url(A)
                    .method("POST", body2)
                    .addHeader("Authorization", "Basic ZGVlcGFuc2h1bGFtYmRhdGVzdDpmOHhyOGVWN2hwSkppeE82c2JWbVBhekFINEM4Vm9BVWhFQU5QamlrYXlMVFhObEpLcw==")
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response2 = client2.newCall(request2).execute();
            System.out.println(response2.code());
            gridURL = "https://mobile-api.lambdatest.com/mobile-automation/api/v1/sessions/" + driver.getSessionId() + "/update_network";

            Thread.sleep(15000);

            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign in with Google\"]")).click();
            Thread.sleep(10000);

//            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.View/android.view.View[3]/android.view.ViewGroup")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]/android.view.ViewGroup/android.view.ViewGroup")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Completed\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]/android.view.ViewGroup/android.view.ViewGroup")).click();
//            Thread.sleep(5000);
//

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
