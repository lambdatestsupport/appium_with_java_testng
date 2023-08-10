package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 {

    private AppiumDriver driver;
//    private AppiumDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";

//        String username = "amitkslambdatest";
//        String authkey = "ZK27KD00E5dag50FKkodeVLGXQSUwGlM8AW6SKbc5o4UElpLmv";

//
        String hub = "@mobile-hub.lambdatest.com/wd/hub";
////        /String hub = "@hub.lambdatest.com/wd/hub";
//        String hub = "http://\" + username + \":\" + authkey + \"@localhost:9688/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
////        caps.setCapability("platformVersion", "11");
////        caps.setCapability("platformName", "Android");
////        caps.setCapability("deviceName", "OnePlus 9");
//        caps.setCapability("platformName", "ios");
//        caps.setCapability("deviceName", "iPhone 13 Pro Max");
//        caps.setCapability("platformVersion", "15");
////        caps.setCapability("network", false);
////        caps.setCapability("browserName", "Safari");
////        caps.setCapability("browserVersion", "latest");
////        caps.setCapability("platformName", "OS X Mountain Lion");
//        caps.setCapability("isRealMobile", true);
////        caps.setCapability("platform", "macOS Monterey");
////        caps.setCapability("browserName", "Chrome");
////        caps.setCapability("browserVersion", "106");
////        caps.setCapability("version", "latest");
//        caps.setCapability("build", "firstcry");
//        caps.setCapability("region", "AP");
////        caps.setCapability("name", "attempt_2 with safari 6");
////        caps.setCapability("selenium_version","2.45.0");
////        caps.setCapability("geoLocation", "US");
        caps.setCapability("autoAcceptAlerts","true");
////        caps.setCapability("autoGrantPermissions","true");
////        caps.setCapability("isRealMobile", true);
////        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
////        caps.setCapability("plugin", "git-testng");
////        caps.setCapability("timezone", "UTC+10:00");
////        caps.setCapability("fixedIP", "ce091829b1719c070c7e");

        caps.setCapability("build", "march 10 testsigma");
        caps.setCapability("name", "Java JUnit iOS iPhone 12");
        caps.setCapability("platformName", "ios");
        caps.setCapability("deviceName", "iPhone 13");
        caps.setCapability("isRealMobile", true);
        caps.setCapability("platformVersion","15");
        caps.setCapability("app","lt://APP10160531401676986692885897");
//        caps.setCapability("autoAcceptAlerts",true);
        caps.setCapability("autoDismissAlerts", true);
        caps.setCapability("network", true);


        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

//      driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + hub), caps);


    }

    @Test
    public void basicTest() throws InterruptedException
    {

        //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Login\"]"));
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LandingPageVC.buttonLogin\"]")).click();
        Thread.sleep(3000);
        System.out.println("1");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue as a Job Seeker\"]")).click();
        Thread.sleep(3000);
        System.out.println("1");
//        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]")).click();
//        Thread.sleep(3000);
//        System.out.println("1");
        driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"JobGet\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")).sendKeys("tester313906@jobgetmobile.msdc.co");
        Thread.sleep(3000);
        System.out.println("1");
//            driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"JobGet\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")).sendKeys("tester");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LOG IN\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"LOG IN\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Profile\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Experience\"]")).click();
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Start Date\"]")).sendKeys("2021");
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"End Date\"]")).sendKeys("August");
//            Thread.sleep(3000);


//            List<MobileElement> els1 = (MobileElement) driver.findElementsByXPath("//XCUIElementTypeTextField[@value=Email address]");
//            (new TouchAction(driver)).press(PointOption.point(238, 224})).moveTo(PointOption.point(226, 607})).release().perform();
//
//
//


//            driver.navigate().back();

        Status = "passed";

    }


//        driver.manage().window().maximize();

//        driver.get("https://www.amazon.in/"); //a

//        driver.get("https://ofmweb-vipsafeqaat04.orpheusdev.ne");
//        Thread.sleep(5000);
//        driver.get("https://www.google.com/");
//        Thread.sleep(19000);
//
//        driver.findElement(By.name("q")).sendKeys("lambdatest");
//        Thread.sleep(19000);
////        driver.get("https://www.google.com/");
////
////        Thread.sleep(12000);
//
//        driver.get("https://www.lambdatest.com/intl/en-in"); //a
//////
////        Thread.sleep(80000);
//        driver.get("https://lambdatest.github.io/sample-todo-app/");
//
//
//        System.out.println("Checking Box");
//
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li2")).click();
//
//        System.out.println("Checking Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li4")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li7")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li8")).click();
//
//        System.out.println("Entering Text");
//        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li9")).click();
//
//        // Let's also assert that the todo we added is present in the list.
//
//        spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
//        Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
//
//        driver.get("https://www.nike.com");
//        Thread.sleep(20000);
//        //GET TITLE
//        String a = driver.getTitle();
//        //PRINT TITLE
//        System.out.println(a);
//        driver.get("https://www.flipkart.com");
//        Thread.sleep(20000);
//        a = driver.getTitle();
//
//        System.out.println(a);
//        driver.get("https://www.tesla.com");
//        Thread.sleep(20000);
//        a = driver.getTitle();
//
//        System.out.println(a);
//        driver.get("https://www.myntra.com");
//        Thread.sleep(20000);
//        a = driver.getTitle();
//
//        System.out.println(a);

//       driver.get("https://americanservicepets.com/checkout/da00f1b8-9245-48b4-82c2-ec4a04922daa");
//       driver.findElementByName("address").sendKeys("123");
//       Thread.sleep(3000);
//       driver.findElementByName("next").click();
//       Thread.sleep(9000);
//
////        Select Dropdown2=  new Select(driver.findElement(By.id("card_type")));
////        Dropdown2.selectByVisibleText("Visa");
////        Thread.sleep(5000);
////        driver.findElement(By.xpath("//*[@id=\"card_type\"]")).click();
////        Thread.sleep(3000);
////        driver.findElementByCssSelector("#bs2D select2D 22D 1").click();
////        Thread.sleep(3000);
//        WebElement dropdown = driver.findElement(By.id("card_type"));
//        Select select = new Select(dropdown);
//        select.selectByVisibleText("Master Card");
//
////        JavascriptExecutor js = (JavascriptExecutor)driver;
////        js.executeScript("return $(\"#card_type\").val(\"master\").change();");
////        Thread.sleep(15000);
//
//       driver.findElementByName("card_number").sendKeys("12345678901234");
//       Thread.sleep(5000);
//
//        Select Dropdown=  new Select(driver.findElement(By.xpath("//*[@id=\"bill-info2\"]/div[2]/div[1]/div[1]/div/div/div/div/select")));
//            Dropdown.selectByVisibleText("March");
//            Thread.sleep(5000);
//
//        Select Dropdown1=  new Select(driver.findElement(By.name("exp_year")));
//        Dropdown1.selectByVisibleText("2026");
//        Thread.sleep(5000);

//        driver.get("https://dev-borrower.certain.app/login");
//        Thread.sleep(5000);
//
//        driver.findElementByName("email").sendKeys("e2e+borrowertest@vontive.com");
//        Thread.sleep(5000);
//
//        driver.findElementById("current-password").sendKeys("testpassword123");
//        Thread.sleep(5000);
//
//        driver.findElementByCssSelector(".v-btn--is-elevated > .v-btn__content").click();
//        Thread.sleep(5000);
//
//        driver.get("https://dev-borrower.certain.app/login");
//        Thread.sleep(5000);
//
//        driver.findElementByCssSelector("#email").sendKeys("e2e+borrowertest@vontive.com");
//        Thread.sleep(5000);
//
//        driver.findElementByCssSelector("#current-password").sendKeys("testpassword123");
//        Thread.sleep(5000);
//
//        driver.findElementByCssSelector(".v-btn--is-elevated > .v-btn__content").click();
//        Thread.sleep(5000);
//
////        driver.findElementByCssSelector("#app > div > main > div > div.container.pa-0.mt-4 > div > div.col.pb-0.pr-3.left-col-desktop.grow > div.row.d-flex.align-center.mx-1.no-gutters > div.col.grow.headline").click();
////        Thread.sleep(15000);
//        driver.findElementByXPath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/div[1]").click();
//        Thread.sleep(5000);

//        JavascriptExecutor js1 = (JavascriptExecutor)driver;
//        js1.executeScript("return $(\"#card_number\").val(\"3\").change();");
//        Thread.sleep(3000);
//
//        JavascriptExecutor js3 = (JavascriptExecutor)driver;
//        js3.executeScript("return $(\"#exp_year\").val(\"2026\").change();");
//        Thread.sleep(3000);

//        driver.findElement(By.xpath("//*[@id=\"bill-info2\"]/div[2]/div[1]/div[3]/div/div/input")).sendKeys("123");
//        Thread.sleep(5000);
//
//        driver.findElement(By.id("complete_checkout")).click();
//        Thread.sleep(10000);
//
//        //Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}