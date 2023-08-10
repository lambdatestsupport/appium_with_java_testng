package com.lambdatest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class fileupload {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "deepanshulambdatest";
        String authkey = "f8xr8eV7hpJJixO6sbVmPazAH4C8VoAUhEANPjikayLTXNlJKs";


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "105");
        caps.setCapability("build", "elsevier file upload");
        caps.setCapability("name", "test1");
        caps.setCapability("network", true);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);


    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;

        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();
        {


            try {

                String fileName = "D:/file/testing.txt";
                String data = "123456789abcdefghijkl";


                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(data);
                bufferedWriter.close();

                System.out.println("File Write successfully");

                Thread.sleep(2000);

                //    -----------------------Upload updated file from the system--------------------
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("text/plain");
                RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("files","testing.txt",
                                RequestBody.create(MediaType.parse("application/octet-stream"),
                                        new File("D:/file/testing.txt")))
                        .build();
                Request request = new Request.Builder()
                        .url("https://api.lambdatest.com/automation/api/v1/user-files")
                        .method("POST", body)
                        .addHeader("Authorization", "Basic ZGVlcGFuc2h1bGFtYmRhdGVzdDpmOHhyOGVWN2hwSkppeE82c2JWbVBhekFINEM4Vm9BVWhFQU5QamlrYXlMVFhObEpLcw==")
                        .build();
                Response response = client.newCall(request).execute();
                String responseBody= response.headers().toString();

                Thread.sleep(2000);

                //  System.out.println("----------Response of upload file over lambdatest storage-----> "+responseBody);

                Thread.sleep(5000);



                OkHttpClient client1 = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType1 = MediaType.parse("application/json");
                RequestBody body1 = RequestBody.create(mediaType, "{\n  \"key\": \"testing.txt\"\n}");
                Request request1 = new Request.Builder()
                        .url("https://api.lambdatest.com/automation/api/v1/user-files/download")
                        .method("PUT", body1)
                        .addHeader("Authorization", "Basic ZGVlcGFuc2h1bGFtYmRhdGVzdDpmOHhyOGVWN2hwSkppeE82c2JWbVBhekFINEM4Vm9BVWhFQU5QamlrYXlMVFhObEpLcw==")
                        .addHeader("Content-Type", "application/json")
                        .build();
                Response response1 = client1.newCall(request1).execute();

                String Responsebody1= response1.body().string();

                System.out.println("Response Body"+Responsebody1);


                System.out.println("Successful------------***********--------");



                //------------Check how the updated data inside the file




            }
            catch (IOException e){
                e.printStackTrace();

            }

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