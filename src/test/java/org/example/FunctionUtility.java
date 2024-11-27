package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FunctionUtility {
    static ExtentSparkReporter extentSparkReporter;
    static ExtentReports extentReports;
    static ExtentTest extentTest;

    public static void reportGeneration(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"./reports/tricentis-report-1.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void configureReport(){

        extentSparkReporter.config().setDocumentTitle("Tricentis Report");
        extentSparkReporter.config().setReportName("Report 1");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extentTest = extentReports.createTest("Test Case 1","This is the report of product data page");
    }

    public static void flushMethod(){
        extentReports.flush();
    }
}
