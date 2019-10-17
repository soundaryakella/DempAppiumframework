package com.testyentra.paytm.nativeapp.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.testyentra.paytm.nativeapp.init.UniversalVariables;

public class MyListeners extends ExtendReportsIntialzers implements ITestListener,IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onTestStart(ITestResult result) {
		
		String getTestCaseName = result.getTestClass().getName().toString();
		UniversalVariables.test=UniversalVariables.extent.createTest(getTestCaseName);
		
	}

	public void onTestSuccess(ITestResult result) {
		UniversalVariables.test.log(Status.PASS, "Test is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		UniversalVariables.test.log(Status.FAIL, "Test is failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		UniversalVariables.test.log(Status.SKIP, "Test is skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtendReportsIntialzers._intializeExtentReports("D:\\soundarya\\AppiumFramework\\appiumframework\\Report1.html");
		
	}

	public void onFinish(ITestContext context) {
		UniversalVariables.test.log(Status.INFO, "Test is completed");
		UniversalVariables.extent.flush();
		
	}

}
