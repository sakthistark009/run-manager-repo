package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import static org.example.BrowserInitiation.driver;

public class DataDriven {


    @DataProvider(name="testdata")
    public Object[][] testDataExample(){
        ExtractData configuration = new ExtractData("./tricentis-data.xlsx");
        int rows = configuration.getRowCount(0);
        Object[][]data_credentials = new Object[rows][6];

        for(int i=0;i<rows;i++)
        {
            data_credentials[i][0] = configuration.getData(0, i, 0);
            data_credentials[i][1] = configuration.getData(0, i, 1);
            data_credentials[i][2] = configuration.getData(0, i, 2);
            data_credentials[i][3] = configuration.getData(0, i, 3);
            data_credentials[i][4] = configuration.getData(0, i, 4);
            data_credentials[i][5] = configuration.getData(0, i, 5);
        }
        return data_credentials;
    }
}
