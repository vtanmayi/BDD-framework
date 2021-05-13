package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import stepDefininitions.LoginSteps;

public class TestListener extends ExtentReportListener implements ITestListener{
	
	private static ExtentReports extent;

	public void onTestStart(ITestResult result)
	{
		
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("PASS");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("FAIL");
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("SKIP");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	public void onStart(ITestContext context)
	{
		System.out.println("Execution started");
		extent=setUp();
		
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("Execution Finished");
		extent.flush();
		System.out.println("Report is generated");
		
	}
}
