package tata_health_generic_ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tata_health_generic_BaseUtility.BaseClassTest;



public class ExtentReport_ListImpClass implements ITestListener, ISuiteListener{
	public static ExtentTest test;
	//by making it static it won't participate in parallel execution so create a localThread for multiple objects

	public ExtentSparkReporter spark;
	public ExtentReports report;

	
	@Override
	public void onStart(ISuite suite) {
		//ISuiteListener.super.onStart(suite);
		System.out.println("Report Configuration");
		//Spark reporting config
		String Time = new Date().toString().replace(" ", "_").replace(":", "_");

				spark = new ExtentSparkReporter("./AdvanceReport/report_"+Time+".html");
				spark.config().setDocumentTitle("TH Test Suite Result");
				spark.config().setReportName("TH Report");
				spark.config().setTheme(Theme.DARK);
				
				//Add Env^t info & create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "win11");
				report.setSystemInfo("BROWSER", "CHROME-133");
	}

	@Override
	public void onFinish(ISuite suite) {
		//ISuiteListener.super.onFinish(suite);
		System.out.println("Report Backup");

		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		//ITestListener.super.onTestStart(result);
		System.out.println("=====>"+result.getMethod().getMethodName()+ "<=====START====");
    test= report.createTest(result.getMethod().getMethodName());
    UtilityClassObject.setTest(test);
    test.log(Status.INFO, result.getMethod().getMethodName()+"===>STARTED<===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//ITestListener.super.onTestSuccess(result);
		System.out.println("=====>"+result.getMethod().getMethodName()+ "<=====END====");
	    test.log(Status.PASS, result.getMethod().getMethodName()+"===>COMPLETED<===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//ITestListener.super.onTestFailure(result);
		String TestName = result.getMethod().getMethodName();
		TakesScreenshot TSS = (TakesScreenshot) BaseClassTest.Sdriver;
	String FilePath = TSS.getScreenshotAs(OutputType.BASE64);
	
	/* in order to capture time based ss */
	String Time = new Date().toString().replace(" ", "_").replace(":", "_");
	System.out.println(Time);
    test.addScreenCaptureFromBase64String(FilePath, TestName+"_"+Time);	
    test.log(Status.FAIL, result.getMethod().getMethodName()+"===>FAILED<===");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
