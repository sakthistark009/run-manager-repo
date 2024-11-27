package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.SkipException;

import static org.example.BrowserInitiation.driver;

public class TestRunnerClass {

    @BeforeTest
    public void lauchBrowser() throws Exception{
        FunctionUtility.reportGeneration();
        FunctionUtility.configureReport();
        BrowserInitiation.initiateBrowser("chrome");
        BrowserInitiation.launchURL("https://sampleapp.tricentis.com/101/app.php#");
        Thread.sleep(5000);

    }
//     @Test(dataProvider = "testdata", priority = 2,dataProviderClass = DataDriven.class)
//    @Test(priority = 2)
//    public void enterValue()
//    {
//        WebElement emailId  = driver.findElement(By.id("email"));
//        if (emailId.isEnabled()) {
//            emailId.sendKeys(email);
//        } else {
//            System.out.println("Element is not enabled.");
//        }
//        ProductData.enterData();
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class, priority = 1)
    public void TC1_Sample_Test_Case_1(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);

        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 2)
    public void TC2_Sample_Test_Case_2(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
       // ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
//        Assert.assertEquals(driver.getTitle(),"Enter Product Data");
//        driver.get("");
        Assert.assertTrue(driver.findElement(By.id("tricentis_logo")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.id("tricentis_logo")).isDisplayed());
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 3)
    public void TC3_Sample_Test_Case_3(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
//        Assert.assertEquals(driver.getTitle(),"Enter Vehicle Data");
        String title = driver.getTitle();
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 4)
    public void TC4_Sample_Test_Case_4(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
       // Assert.assertEquals(driver.findElement(By.id("legalDefenseInsurance")));
        try {
            Assert.assertTrue(driver.findElement(By.id("downloadtrial")).isDisplayed());
        }catch (NoSuchElementException e)
        {
            Assert.assertFalse(driver.findElement(By.id("downloadtrial")).isDisplayed(),"No element found - downloadtrial");
        }
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 5)
    public void TC5_Sample_Test_Case_5(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
        Assert.assertEquals(driver.getCurrentUrl(),"https://sampleapp.tricentis.com/101/app.php#");
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 6)
    public void TC6_Sample_Test_Case_6(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        // ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
//        throw new SkipException("Skip test");
        //Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.id("visitsupport")).isEnabled());
    }



    @Test  //(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 7)
    public void TC7_Sample_Test_Case_7_skip() {
        throw new SkipException("Skipping due to known bug");
    }

    @Test//(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 8)
    public void TC8_Sample_Test_Case_8_skip() {
        throw new SkipException("Skipping due to unknown bug");
    }

    @Test//(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 9)
    public void TC9_Sample_Test_Case_9_fail() {
//        long pageLoadTime = 6000; // Simulated page load time in milliseconds
        // Start measuring the page load time
        long startTime = System.currentTimeMillis();

        BrowserInitiation.launchURL("https://sampleapp.tricentis.com/101/app.php#");

        long endTime = System.currentTimeMillis();

        // Calculate the page load time
        long pageLoadTime = endTime - startTime;
        Assert.assertTrue(pageLoadTime <= 0, "Page load time exceeded the limit!");
    }

    @Test//(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 10)
    public void TC10_Sample_Test_Case_10_fail() {
        // Example of checking for a broken link (simulated)
//        BrowserInitiation.launchURL("https://saeapp.tricentis.com/101/app.php#");

        // Simulate response code for a broken link (404 not found)
        int responseStatusCode = 404; // Replace this with actual code for broken link response

        // Validate if the link is broken by checking the response code (404 is a broken link)
        Assert.assertNotEquals(responseStatusCode, 404, "Link is broken with 404 error!");
    }

    @Test//(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 11)
    public void TC11_Sample_Test_Case_11_fail() {
        // Find a link element and check if it’s broken
//        driver.get("https://sampleapp.tricentis.com/101/app.php#");
//        WebElement link = driver.findElement(By.id("enterinsurantdata"));
//
//        link.click();
        // Simulate the response status for this link
        int responseStatusCode =404; // Example: Link is broken

        // Assert that the link is not broken
        Assert.assertNotEquals(responseStatusCode, 404, "The link is broken!");
    }


    @Test//(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 12)
    public void TC12_Sample_Test_Case_12_broken() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://sampleapp.tricentis.com/101/app.php#");
//        Assert.assertEquals(driver.getTitle(),"Sample App");
//        driver.quit();
        driver.findElement(By.id("enterproduct"));
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 13)
    public void TC13_Sample_Test_Case_13_broken(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
        driver.findElement(By.id("search_btn"));
//        Assert.assertEquals(driver.getCurrentUrl(),"https://sample.tricentis.com/101/app.php#");
        Thread.sleep(5000);
    }

    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 14)
    public void TC14_Sample_Test_Case_14_broken(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
      Assert.assertTrue(driver.findElement(By.linkText("Enter Insurant")).isDisplayed());
    }

    @AfterTest
    public void finish(){
        FunctionUtility.flushMethod();
        driver.quit();
    }



}

