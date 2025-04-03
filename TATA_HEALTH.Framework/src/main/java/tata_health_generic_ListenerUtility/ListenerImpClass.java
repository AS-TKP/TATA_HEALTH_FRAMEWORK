package tata_health_generic_ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tata_health_generic_BaseUtility.BaseClassTest;


public class ListenerImpClass implements ITestListener, ISuiteListener{
	@Override
	public void onStart(ISuite suite) {
		//ISuiteListener.super.onStart(suite);
		System.out.println("Report Configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		//ISuiteListener.super.onFinish(suite);
		System.out.println("Report Backup");

	}

	@Override
	public void onTestStart(ITestResult result) {
		//ITestListener.super.onTestStart(result);
		System.out.println("=====>"+result.getMethod().getMethodName()+ "<=====START====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//ITestListener.super.onTestSuccess(result);
		System.out.println("=====>"+result.getMethod().getMethodName()+ "<=====END====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//ITestListener.super.onTestFailure(result);
		String TestName = result.getMethod().getMethodName();
		TakesScreenshot TSS = (TakesScreenshot) BaseClassTest.Sdriver;
	File SrcFile = TSS.getScreenshotAs(OutputType.FILE);
	
	/* in order to capture time based ss */
	String Time = new Date().toString().replace(" ", "_").replace(":", "_");
	System.out.println(Time);

	File dtnFile = new File("./TH_Screenshots/"+TestName+"_"+Time+".png");
	try {
		FileHandler.copy(SrcFile, dtnFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
