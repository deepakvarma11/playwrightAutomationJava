package com.playwright.base.test;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.playwright.constants.Constants;
import com.playwright.utils.ReportingManager;

public class TestListener implements ITestListener {

	private static final ExtentReports REPORT = ReportingManager.createReport();

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestNGMethod method = result.getMethod();
		try {
			String testData = result.getParameters()[0].toString();
			REPORT.createTest(method.getMethodName()).assignCategory(method.getRealClass().getSimpleName())
					.pass(String.format("Test Data: %s%n", testData));
		} catch (ArrayIndexOutOfBoundsException e) {
			REPORT.createTest(method.getMethodName()).assignCategory(method.getRealClass().getSimpleName())
					.pass(String.format("Test Data: %s%n", "No Parameters"));
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestNGMethod method = result.getMethod();
		String fileName = System.getProperty("user.dir") + File.separator + Constants.REPORTPATH.readProperty()
				+ File.separator + "screenshots" + File.separator;
		try {
			String testData = result.getParameters()[0].toString();
			REPORT.createTest(method.getMethodName()).assignCategory(method.getRealClass().getSimpleName())
					.fail(String.format("Test Data: %s%n", testData))
					.fail(result.getThrowable(), MediaEntityBuilder
							.createScreenCaptureFromPath(String.format("%s%s.png", fileName, method.getMethodName()))
							.build());
		} catch (ArrayIndexOutOfBoundsException e) {
			REPORT.createTest(method.getMethodName()).assignCategory(method.getRealClass().getSimpleName())
					.fail(result.getThrowable(), MediaEntityBuilder
							.createScreenCaptureFromPath(String.format("%s%s.png", fileName, method.getMethodName()))
							.build());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		REPORT.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
