package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class imageInjection {

    String userName = System.getenv("LT_USERNAME") == null ?
            "username" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ?
            "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public static final int KEYCODE_CAMERA          = 27;

    //    AppiumDriver driver;
    AndroidDriver driver;


    @Test
    public void AndroidImg() throws InterruptedException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "imageInjection");
            capabilities.setCapability("deviceName", "Pixel.*");
            capabilities.setCapability("platformVersion", "12");
            capabilities.setCapability("platformName", "ANDROID");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("app", "lt://APP10160571901690882030958767");
//            capabilities.setCapability("appPackage", "com.google.android.GoogleCamera");
//            capabilities.setCapability("appActivity","com.android.camera.CameraLauncher");
//            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("autoGrantPermissions",true);
//            capabilities.setCapability("autoAcceptAlerts", true);

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Pixel. *");
//            ltOptions.put("platformVersion", "11");
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("appProfiling",true);2
//            ltOptions.put("app","lt://APP10160531401680790523819989");
//            capabilities.setCapability("lt:options", ltOptions);
//            HashMap<String, String> playstorelogin = new HashMap<>();
//            playstorelogin.put("email", "varunp0211@gmail.com"); //Add in your Google account ID
//            playstorelogin.put("password", "Varun@123");
//            capabilities.setCapability("playStoreLogin", playstorelogin);


            String hub = "https://" + userName + ":" + accessKey + gridURL;
//            driver = new AppiumDriver(new URL(hub), capabilities);
            driver = new AndroidDriver(new URL(hub), capabilities);



            driver.findElement(By.id("com.bsstag.cameraimage:id/button")).click();
            Thread.sleep(3000);


            driver.findElement(By.id("com.google.android.GoogleCamera:id/shutter_button")).click();
            Thread.sleep(3000);


            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")).click();
            Thread.sleep(3000);


            driver.findElement(By.id("com.bsstag.cameraimage:id/button")).click();
            Thread.sleep(3000);

//            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Camera\"]")).click();
//            Thread.sleep(10000);
//            above command is same for both oneplus and pixel

////android.widget.ImageButton[@content-desc="Switch camera"] one plus
//            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Switch to front camera\"]")).click();
//            Thread.sleep(5000);

//            driver.findElement(By.xpath("com.oneplus.camera:id/primary_button_icon_container")).click(); one plus
//            Thread.sleep(10000);



//            driver.findElement(By.id("com.sec.android.app.camera:id/normal_center_button")).click();


//            MobileElement el1 = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
//            el1.click();

//            driver.sendKeyEvent(KeyEvent.KEYCODE_CAMERA);

//            MobileElement el1 = (MobileElement) driver.findElement(By.id("google"));
//            el1.click();

            driver.findElement(By.xpath("//android.widget.Button[@text=\"Done\"]")).click();
            Thread.sleep(9000);
//
//            driver.press_keycode(27);
//            android:id/button1 id of above locator
//            ((AndroidDriver)driver).pressKey(new KeyEvent(code));
//              driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Take Night Sight photo\"]")).click();
//              Thread.sleep(10000);
//              above command is for pixel

//            try {
//                Runtime.getRuntime().exec("adb shell input `keyevent` 27");
//                Thread.sleep(2000);
//            } catch (Throwable t) {
//                t.printStackTrace();
//            }
//            Thread.sleep(30000);

            driver.quit();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}