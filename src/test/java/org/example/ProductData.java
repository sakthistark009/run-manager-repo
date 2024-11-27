package org.example;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.example.BrowserInitiation.driver;
import static org.example.FunctionUtility.extentTest;

public class ProductData {
    static WebElement startDate;
    static Select insuranceSum;
    static Select meritRating;
    static Select damageInsurance;
    static WebElement optionalProduct;
    static Select curtesyCar;
    static WebElement index_menu;
    //static WebElement index;



        public static void enterData(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) {

            // System.setProperty("webdriver.chrome.driver", "Path of Chrome Driver");
//            driver = new ChromeDriver();
//            driver.get("https://sampleapp.tricentis.com/101/app.php#");

            Actions action = new Actions(driver);
            try {
                index_menu = driver.findElement(By.linkText("Enter Product Data"));
                action.moveToElement(index_menu).perform();
                index_menu.click();
                extentTest.log(Status.PASS,"Navigated to the page successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - index_menu");
            }
            //
            try{
                startDate = driver.findElement(By.name("Start Date"));
                startDate.sendKeys(startdate);
                extentTest.log(Status.PASS,"Start Date entered successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - startdate");
            }

            //
            try {
                insuranceSum = new Select(driver.findElement(By.name("Insurance Sum")));
                insuranceSum.selectByVisibleText(insurancesum);
                extentTest.log(Status.PASS,"Insurance sum entered successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - insuranceSum");
            }
            //driver.findElement(By.name("commit")).click();
            //
            try {
                meritRating = new Select(driver.findElement(By.name("Merit Rating")));
                meritRating.selectByVisibleText(mertirating);
                extentTest.log(Status.PASS,"merit rating entered successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - meritRating");
            }
            //
            try {
                damageInsurance = new Select(driver.findElement(By.name("Damage Insurance")));
                damageInsurance.selectByVisibleText(damageinsurance);
                extentTest.log(Status.PASS,"Damage Insurance entered successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - damageInsurance");
            }
            //
            try {
                optionalProduct = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span"));
                optionalProduct.click();
                extentTest.log(Status.PASS,"Optional product entered successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - optionalProduct");
            }
            //
            try {
                curtesyCar = new Select(driver.findElement(By.name("Courtesy Car")));
                curtesyCar.selectByVisibleText(curtesycar);
                extentTest.log(Status.PASS,"Curtesy car entered successfully");
            }catch (NoSuchElementException e){
                extentTest.log(Status.FAIL, "No element find - curtesyCar");
            }
        }


}
