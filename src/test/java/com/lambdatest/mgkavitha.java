package com.lambdatest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class mgkavitha {



    public static String userName = "deepanshulambdatest";
    public static String accessKey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";
    public static String status = "passed";
    public static AndroidDriver driver;

    public static <string> void main(String args[]) throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "MagellanHealth script");
        capabilities.setCapability("test", "Test 1");

        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel.*");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("app","lt://APP1016045801683556559937282");

        //  capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("console",true);
        // capabilities.setCapability("network",true);
        capabilities.setCapability("visual",true);
        capabilities.setCapability("w3c", true);
//        capabilities.setCapability("region", "US");
        driver = new AndroidDriver(new URL("http://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);

        try {

            WebDriverWait wait = new WebDriverWait(driver, 30);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(@class,'android.widget.EditText')])[1]")));
            driver.findElementByXPath("(//*[contains(@class,'android.widget.EditText')])[1]").click(); // clicking on username text box to focus
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "kavi26+1121@gmail.com")); //option 1 to enter USERNAME(should work with iOS too)
//            shivbvjcl@gmail.com


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(@class,'android.widget.EditText')])[2]")));
            driver.findElementByXPath("(//*[contains(@class,'android.widget.EditText')])[2]").click(); // clicking on password text box to focus
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Testing123!"));  //option 1 to enter PASSWORD(should work with iOS too)

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Sign in\"]").click(); //clicking on signing button
            Thread.sleep(5000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]").click(); // clicking on next button

            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]").click(); // clicking on next button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Get started\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Get started\"]").click(); //clicking on get started button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Go to Rx search\"]")));

            MobileElement element = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Go to Rx search\"]");
            String elText = element.getAttribute("content-desc");
            String elTextExpected = "Go to Rx search";
            System.out.println("Content-desc value"+ elText);
            assertEquals(elTextExpected, elText);


            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Go to Rx search\"]").click(); //clicking on Rx Search button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(@class,'android.widget.EditText')])")));
            driver.findElementByXPath("(//*[contains(@class,'android.widget.EditText')])").click(); // clicking on Enter Rx name text box to focus
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "amoxicillin"));  //option 1 to enter drug name(should work with iOS too)

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Amoxicillin\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Amoxicillin\"]").click(); //clicking on Rx Search drug name

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Show details\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Show details\"]").click(); //clicking on Show Details
//            wait.until(ExpectedConditions.visibilityOf()
            MobileElement element3 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Search summary\"]");
            String elText3 = element3.getAttribute("content-desc");
            String elTextExpected3 = "Search summary";
            System.out.println(" value  "+ elText3);
            assertEquals(elTextExpected3, elText3);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Close Search\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Close Search\"]").click(); //clicking on Close Search

//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc, 'Learn more')]")));
//            driver.findElementByXPath("//android.widget.Button[contains(@content-desc, 'Learn more')]").click(); //clicking on Learn more link
//            Thread.sleep(3000);
//
//
//            MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.view.View[contains(@content-desc, 'Chromaturia')]");
//            String elText2 = element2.getAttribute("content-desc");
//            System.out.println("Chromaturia value  "+ elText2);

//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Show all side effects\"]")));
//            driver.findElementByXPath("//android.view.View[@content-desc=\"Show all side effects\"]").click(); //clicking on Show all side effects

//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'Chromaturia')]")));
//WebElement element =  driver.findElementByXPath("//android.view.View[contains(@content-desc, 'Chromaturia')]");
//            System.out.println("printing element" + element);
//            String actualtext = driver.findElement(By.xpath("//android.view.View[contains(@content-desc, 'Chromaturia')]")).getText(); //clicking on Show all side effects
//            System.out.println(actualtext);
////            String expectedtext = "1 Chromaturia Very common";
////            Assert.assertEquals(actualtext, expectedtext);

//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"1 Chromaturia Very common\"]")));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Chromaturia')]")));
//            String actualtext = driver.findElementByXPath("//android.view.View[contains(@content-desc, 'Chromaturia')]").getText(); //clicking on Show all side effects
//            System.out.println("test"+ actualtext);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'More tab.')]")));
            driver.findElementByXPath("\t\n" + "//android.view.View[contains(@content-desc, 'More tab.')]").click(); //clicking on more button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"My ID Card\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"My ID Card\"]").click(); //clicking on My ID Card

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'Individual Benefits')]")));
            driver.findElementByXPath("//android.view.View[contains(@content-desc, 'Individual Benefits')]").click(); //expanding Individual Benefits
////            Thread.sleep(5000);
////            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Individual Benefits - button, expanded\"]")));
////            driver.findElementByXPath("//android.view.View[@content-desc=\"Individual Benefits - button, expanded\"]").click(); //collapsing Individual Benefits
////
////            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Individual Benefits - button, collapsed\"]")));
////            driver.findElementByXPath("//android.view.View[@content-desc=\"Family Benefits - button, collapsed\"]").click(); //expanding Family Benefits
////
////            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Individual Benefits - button, expanded\"]")));
////            driver.findElementByXPath("//android.view.View[@content-desc=\"Family Benefits - button, expanded\"]").click(); //collapsing Family Benefits
//
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"back\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"back\"]").click(); //Clicking on Back button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Request physical ID Card\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Request physical ID Card\"]").click(); //Clicking on Request ID Card

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"back\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"back\"]").click(); //Clicking on Back button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\n" + "//android.widget.Button[@content-desc=\"Terms & Conditions\"]")));
            driver.findElementByXPath("\n" + "//android.widget.Button[@content-desc=\"Terms & Conditions\"]").click(); //Clicking on Terms and Conditions

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"back\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"back\"]").click(); //Clicking on Back button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\n" + "//android.widget.Button[@content-desc=\"Privacy Policy\"]")));
            driver.findElementByXPath("\n" + "//android.widget.Button[@content-desc=\"Privacy Policy\"]").click(); //Clicking on Privacy Policy

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"back\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"back\"]").click(); //Clicking on Back button

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\n" + "\t\n" + "//android.widget.Button[@content-desc=\"Acknowledgements\"]")));
            driver.findElementByXPath("\n" + "\t\n" + "//android.widget.Button[@content-desc=\"Acknowledgements\"]").click(); //Clicking on Acknowledgements

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'android.widget.Button')]")));
            driver.findElementByXPath("//*[contains(@class,'android.widget.Button')]").click(); //Clicking on Back button

//            String actualtext = driver.findElement(By.xpath("//android.view.View[@content-desc=\"More options\"]")).getText(); //clicking on Show all side effects
//            System.out.println("test" + actualtext);
//            // Define the scroll parameters
//            Map<String, Object> scrollParams = new HashMap<>();
//            scrollParams.put("direction", "down");
//            scrollParams.put("duration", "2000");
//
//// Scroll the screen
            WebElement location = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                    MobileBy.AccessibilityId("Notifications, Active, You can change your notification preferences on your device settings.")));
            location.click();
            System.out.println("Before Swipe");
            Thread.sleep(5000);

            Actions actions = new Actions(driver);
            actions.moveToElement(location).perform();

            System.out.println("Swiped");

//            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Acknowledgements\"]").click();
//            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\\\"FAQs & Contact\\\").instance(0))").click(); //scroll down to the element and click
//
//            Thread.sleep(10000);


            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"FAQs & Contact\").instance(0))"));


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"FAQs & Contact\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"FAQs & Contact\"]").click(); //Clicking on FAQs

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'dependants prescriptions')]")));
            driver.findElementByXPath("//android.view.View[contains(@content-desc, 'dependants prescriptions')]").click(); //Clicking on FAQ Question 1

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"back\"]")));
            driver.findElementByXPath("//android.widget.Button[@content-desc=\"back\"]").click(); //Clicking on back button
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Sign out\"]")));
//            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Sign out\"]").click(); //Clicking on Sign out
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]")));
//            driver.findElementByXPath("//android.widget.Button[@content-desc=\"Cancel\"]").click(); //Clicking on Cancel

            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
            e.printStackTrace();
        }
        driver.executeScript("lambda-status=" + status);
        driver.quit();
    }
}