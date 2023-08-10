import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class dotdash {

    public static String userName = System.getenv("LT_USERNAME") == null ? "rajesh.balu"  //Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "XnB00K6tjtKowr4bxLApcGIto2t0wH27sp1cus8eMZTEzW3uf1" //Add accessKey here
            : System.getenv("LT_ACCESS_KEY");

    public static final String URL = "https://" + userName + ":" + accessKey + "hub.lambdatest.com/wd/hub";
    public static IOSDriver driver = null;
    public static String deeplink= "https://apple.news/TgVhnKIXhRYW8gaicHfeVBA"; //"https://apple.news/T3ql2QXaiTpWaBFIOUD8nUA"
    public static String brandName="Brides";
    public static String appFooter="Visit www.brides.com";
    private static String Status="failed";
    private static ArrayList<String>  exceptionCapture = new ArrayList<>();
    public static int articleIndex=0;
    // public static void main(String[] args) throws Exception {
    @Test(invocationCount = 1)
    public static void test1() throws Exception {
        exceptionCapture.clear();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "AppleNews");
        capabilities.setCapability("test", "Test1");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 13 Mini");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("region", "US");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("commandLog", true);
//        capabilities.setCapability("terminalLog", true);

        try {
            driver = new IOSDriver(new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);
            driver.get(deeplink);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            if (!driver.findElements(By.name("Enable Notifications")).isEmpty())
                driver.findElementByName("Enable Notifications").click();
            if (!driver.findElements(By.name("View")).isEmpty())
                driver.findElementByName("View").click();
            String webContext = driver.getContext();
            driver.context("NATIVE_APP");
            if (!driver.findElements(By.name("Not Now")).isEmpty())
                driver.findElementByName("Not Now").click();
            // Thread.sleep(5000);
            if (!driver.findElements(By.name("Continue")).isEmpty())
                driver.findElementByName("Continue").click();
            //Thread.sleep(5000);
            if (!driver.findElements(By.name("Turn Off Personalized Ads")).isEmpty())
                driver.findElementByName("Turn Off Personalized Ads").click();
            if (!driver.findElements(By.name("Don't Allow")).isEmpty())
                driver.findElementByName("Don't Allow").click();
            if (!driver.findElements(By.name("Don't Allow")).isEmpty())
                driver.findElementByName("Don't Allow").click();
            HashMap<String, String> scrollUp = new HashMap<String, String>();scrollUp.put("direction", "up");
            HashMap<String, String> scrollDown = new HashMap<String, String>();scrollDown.put("direction", "down");
            WebElement sandboxArticle = driver.findElement(By.xpath("(//XCUIElementTypeOther[starts-with(@name,'" + brandName + " (Sandbox),')])["+articleIndex+"]"));  articleIndex++;
            String label = sandboxArticle.getAttribute("label");
            System.out.println("label : "+label);
            String[] articleName = label.split(",");
            if(label.split(",").length>0) {
                label=articleName[1];
                System.out.println(label);
            }
            driver.executeScript("lambda-name="+label);
            //System.out.println(driver.getPageSource());
            sandboxArticle.click();
            Thread.sleep(2000);
            String appData="";
            scrollIos(.10,.40);
            scrollIos(.10,.40);
            Thread.sleep(3000);
           /* driver.executeScript("mobile:scroll", scrollDown); // Syed : Add for loop & scroll all pages
            linkValidation(webContext);
            //Syed - add hashmap vs hashmap key comparison at the end
            //System.out.println(driver.getPageSource());
         /*    ----------------------------------------Rough==============
         driver.findElement(By.xpath("(//XCUIElementTypeLink[@type='XCUIElementTypeLink'])[1]")).click();
            Thread.sleep(5000);
            System.out.println("---------------2--------------");
            Set<String> contextNames1 = driver.getContextHandles();
            for (String contextName : contextNames1) {
                System.out.println(contextName);
                System.out.println(contextName.equalsIgnoreCase("NATIVE_APP"));
                if(!contextName.equalsIgnoreCase("NATIVE_APP") && !contextName.equalsIgnoreCase(webContext)){
                    driver.context(contextName);
                    System.out.println(driver.getCurrentUrl());
                }
            }
            driver.context("NATIVE_APP");
            driver.findElement(By.xpath("(//XCUIElementTypeLink[@type='XCUIElementTypeLink'])[2]")).click();
            Thread.sleep(5000);
            for (String contextName : contextNames1) {
                System.out.println(contextName);
                System.out.println(contextName.equalsIgnoreCase("NATIVE_APP"));
                if(!contextName.equalsIgnoreCase("NATIVE_APP") && !contextName.equalsIgnoreCase(webContext)){
                    driver.context(contextName);
                    System.out.println(driver.getCurrentUrl());
                }
            }
            //System.out.println(driver.getCurrentUrl());
        linkValidation(webContext);
        ----------------------------------------Rough==============
        for(int i = 0; i<15; i++) {
            //System.out.println(">>>>>>>>>>>>>>>>Loop>>>>>>>>>>>>>>>>>>>>>>>>> "+i);
            String line=getAppData(appData);
            appData=appData+ " " +line;
            if(line.contains("Visit www.brides.com")){
                break;
            }
            driver.executeScript("mobile:scroll", scrollDown);
            System.out.println(driver.getPageSource());
        }
        //System.out.println(driver.getPageSource());
        //System.out.println("-------Final-----------");
        //System.out.println(appData);
        driver.activateApp("com.apple.mobilesafari");
        driver.context(webContext);
        driver.get("https://www.brides.com");
        //driver.get("https://www.bhg.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label='Open search form']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys(label);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        //System.out.println(label.split(",")[1]);
        driver.findElement(By.id("card_1-0")).click();   // mntl-card-list-items_1-0
        //System.out.println(" :[Web]------------------------------------------------------------------------");
        //System.out.println(driver.findElement(By.tagName("article")).getText());
        String pdfData="";
        pdfData=driver.findElement(By.xpath("//article//div[@class='loc article-header']")).getText();
        pdfData=pdfData+ " "+driver.findElement(By.xpath("//article//div[@class='loc article-content']")).getText();
        Thread.sleep(3000);
        //System.out.println(" :[Comparison]------------------------------------------------------------------------");
        comparePdfVsAnf(label,appData.toLowerCase(),pdfData.toLowerCase());
        //exceptionCapture.add("Failed due to reason 123");
*/
            Status = "passed";
        }catch(Exception e){
            Status = "failed";
            exceptionCapture.add(e.getMessage());
            ((JavascriptExecutor) driver).executeScript("lambda-exceptions", exceptionCapture);
        }finally{
            exceptionCapture.add("Failed due to reason y");
            ((JavascriptExecutor) driver).executeScript("lambda-exceptions", exceptionCapture);
            driver.executeScript("lambda-status=" + Status);
            driver.quit();
        }
    }

    public static String getAppData(String Data) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> allOptions=driver.findElements(By.cssSelector("XCUIElementTypeOther[accessible='true']"));
        int count=allOptions.size();
        String appData="";
        //System.out.println("------------------------------------------App Data Count : "+count);
        for ( WebElement we: allOptions) {
            try {
                //System.out.println(we.getAttribute("value"));
                appData = appData + " " + we.getAttribute("value");
            }catch(Exception e){

            }
        }
        return appData;
    }
    public static void linkValidation(String webContext) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> allOptions = driver.findElements(By.cssSelector("XCUIElementTypeLink:value"));
        System.out.println(allOptions.size());
        WebElement we = driver.findElement(By.xpath("(//XCUIElementTypeLink[@value])[1]"));
        // for ( WebElement we:allOptions) {
        System.out.println("Link name : " + we.getAttribute("value"));
        we.click();
        Thread.sleep(5000);
        Set<String> contextNames1 = driver.getContextHandles();
        for (String contextName : contextNames1) {
            if(!contextName.equalsIgnoreCase("NATIVE_APP") && !contextName.equalsIgnoreCase(webContext)){
                driver.context(contextName);

            }
        }
        Thread.sleep(5000); // wait for page to load.
        System.out.println("Link Url : "+driver.getCurrentUrl());
        //driver.findElement(By.name("Done")).click();
        driver.activateApp("com.apple.news");
        driver.context("NATIVE_APP");
        // Thread.sleep(3000);

        // }
        System.out.println(driver.getPageSource());
        // scrollIos(.10,.40);
        // scrollIos(.10,.40);
        // }
    }
    private static String comparePdfVsAnf(String articleName, String previewAnfText, String pdfData) {
        String verifiedSentences = "";
        verifiedSentences = "";
        String[] pdfLines = pdfData.split("\\r?\\n");
        for (String line : pdfLines) {
            if (!previewAnfText.toLowerCase().contains(line.trim())) {
                String missingText = findMissingWordInSentence(line, previewAnfText);
                if (!missingText.equalsIgnoreCase("NA")) {
                    exceptionCapture.add("[Fail]:" + missingText.replaceAll(",", ";")+ " is missing in the app for the expected line : " + line);

                } else {
                    //exceptionCapture.add("Pass :"+line.replaceAll("[\n\r]", "").replaceAll(",", " "));
                }
            } else {
                verifiedSentences = verifiedSentences + "\n" + line;
            }
        }
        //exceptionCapture.add("[Pass]:"+verifiedSentences.replaceAll("[\n\r]", "").replaceAll(",", ","));
        return verifiedSentences;
    }



    private static String findMissingWordInSentence(String pdfLine, String previewAnfText) {
        String newPdfValue = pdfLine.replaceAll("\\W", " ").replaceAll("\\s\\s+", " ");
        String newAnfValue = previewAnfText.replaceAll("\\W", " ").replaceAll("\\s\\s+", " ");
        String matchingSentence = "", missingSentence = "", finalMissingSentence = "";
        if (!newAnfValue.toLowerCase().contains(newPdfValue)) {
            String[] arrayPdfWords = newPdfValue.split(" ");
            switch (arrayPdfWords.length) {
                case 0:
                    return "NA";
                case 1:
                    finalMissingSentence = newPdfValue;
                    return newPdfValue;
                case 2:
                    String[] words = newPdfValue.split(" ");
                    for (String word : words) {
                        if (!newAnfValue.contains(word)) {
                            if (finalMissingSentence.length() != 0) {
                                finalMissingSentence = finalMissingSentence + "," + word;
                            } else {
                                finalMissingSentence = word;
                            }
                        }
                    }
                    if (finalMissingSentence.length() == 0) {
                        return "NA";
                    } else {
                        return finalMissingSentence;
                    }
                default:
                    int wordsMedian = arrayPdfWords.length / 2;
                    StringBuilder rightSentence = new StringBuilder();
                    StringBuilder leftSentence = new StringBuilder();
                    for (int rightTraverse = wordsMedian; rightTraverse < arrayPdfWords.length; rightTraverse++) {
                        rightSentence.append(arrayPdfWords[rightTraverse] + " ");
                    }
                    for (int leftTraverse = 0; leftTraverse <= wordsMedian - 1; leftTraverse++) {
                        leftSentence.append(arrayPdfWords[leftTraverse] + " ");
                    }
                    if (!newAnfValue.contains(leftSentence) && !newAnfValue.contains(rightSentence)) {
                        String rightMissingSentence = findMissingWordInSentence(rightSentence.toString(), previewAnfText);
                        String leftMissingSentence = findMissingWordInSentence(leftSentence.toString(), previewAnfText);
                        if (rightMissingSentence.equalsIgnoreCase("NA"))
                            rightMissingSentence = "";
                        if (leftMissingSentence.equalsIgnoreCase("NA"))
                            leftMissingSentence = "";
                        if (rightMissingSentence.length() == 0 && leftMissingSentence.length() == 0) {
                            return "NA";
                        } else if (rightMissingSentence.length() == 0) {
                            finalMissingSentence = leftMissingSentence;
                            return finalMissingSentence;
                        } else if (leftMissingSentence.length() == 0) {
                            finalMissingSentence = rightMissingSentence;
                            return finalMissingSentence;
                        } else {
                            finalMissingSentence = leftMissingSentence + "," + rightMissingSentence;
                            // matchingSentence="NA";
                            return finalMissingSentence;
                        }
                    } else if (newAnfValue.contains(leftSentence.toString())
                            && !newAnfValue.contains(rightSentence.toString())) {
                        matchingSentence = leftSentence.toString();
                        missingSentence = rightSentence.toString();
                        finalMissingSentence = findMissingWordInSentence(missingSentence, previewAnfText);
                        return finalMissingSentence;
                    } else if (newAnfValue.contains(rightSentence.toString())
                            && !newAnfValue.contains(leftSentence.toString())) {
                        missingSentence = leftSentence.toString();
                        matchingSentence = rightSentence.toString();
                        finalMissingSentence = findMissingWordInSentence(missingSentence, previewAnfText);
                        return finalMissingSentence;
                    } else if (newAnfValue.contains(leftSentence) && newAnfValue.contains(rightSentence)) {
                        return "NA";
                    }
            }
        } else {
            return "NA";
        }
        return finalMissingSentence;
    }

    public static void scrollIos( double scrollPercentageStart, double scrollPercentageEnd)
    {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth()/2;
        int starty = (int) (size.getHeight() * scrollPercentageStart);
        int endy = (int) (size.getHeight() * scrollPercentageEnd);
        (new TouchAction(driver)).press(PointOption.point(x, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(20)))
                .moveTo(PointOption.point(x, endy))
                .release()
                .perform();
    }
}

