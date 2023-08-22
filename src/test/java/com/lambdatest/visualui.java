package com.lambdatest;
import java.time.LocalDate;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

public class visualui {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver = null;

    @BeforeTest
    public void setUp() throws Exception {
        Hashtable<String, Integer> errorColor= new Hashtable<>();
        errorColor.put("red",255);
        errorColor.put("green",0);
        errorColor.put("blue",0);

        HashMap<String,Object> output= new HashMap<String, Object>();
        output.put("errorColor",errorColor);//Output Difference error color
        output.put("transparency",0.1);// Set transparency of Output
        output.put("largeImageThreshold",1200);// the granularity to which the comparison happens(the scale or level of detail in a set of data.)Range-100-1200


        HashMap<String, Object> sm=new HashMap<String, Object>();
        sm.put("output",output);
        sm.put("scaleToSameSize",true);//scale to same size, when baseline image and comparision image is of different size, use true


       String username = "your_lt_user_name";
       String authkey = "your_lt_access_key";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "VisualUI"+ LocalDate.now());
        capabilities.setCapability("name", "Visual Ui Testing");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformName", "Windows 11");
        capabilities.setCapability("browserVersion", "114.0");
        capabilities.setCapability("visual",true);
        capabilities.setCapability("smartUI.project","your_project_name");
        capabilities.setCapability("smartUI.build","your_build_name");

         try
        {
            driver = new AppiumDriver(new URL("http://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(5000);


        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

     @Test
    public void testSimple() throws Exception
    {
        try
        {
            Thread.sleep(3000);

        driver.get("https://www.lambdatest.com");
        Thread.sleep(5000);
        driver.executeScript("smartui.takeScreenshot=pic1");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/support/docs/");
        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pic2");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/pricing");
        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pic3");
        Thread.sleep(1000);

          driver.navigate().back(); 
            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
    }
    @AfterTest
    public void tearDown() throws Exception
    {
        if (driver != null)
        {
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
