package com.crm.myriad.genericlibrary;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public  class ListenerImplementationClass implements ITestListener{

	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest testreport;

	public void onTestFailure(ITestResult result) {

		String failedTestName = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		String Date = new Date().toString().replaceAll(":", "-");
		File dst = new File("./screenshot/"+failedTestName+" "+Date+".png");
		String screenshotPath = dst.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dst);



		}
		catch (Exception e)
		{
		}


		test.fail(result.getMethod().getMethodName()+ " is pass");
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);
		




	}

	public void onTestStart(ITestResult result) {

		//test=reports.createTest(result.getMethod().getMethodName());
		//testreport=test;
		
		
	}

	public void onTestSuccess(ITestResult result) {

		test.pass(result.getMethod().getMethodName()+ "  is pass");

	}

	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+ "  is skipped");
		test.skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extent-output/emailable-extentReport.html") ;
		spark.config().setDocumentTitle("Extent Report Document Titl");
		spark.config().setReportName("Report Name of ExtentReport");
		spark.config().setTheme(Theme.STANDARD);

		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Reporter Name", "Chandu_Sunag");
		reports.setSystemInfo("Platform", "Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Browser Version", "103.0.5060.134");




	}

	public void onFinish(ITestContext context) {

		reports.flush();
	}}





