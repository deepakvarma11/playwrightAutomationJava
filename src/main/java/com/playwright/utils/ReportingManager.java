package com.playwright.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.playwright.constants.Constants;

public final class ReportingManager {

	private ReportingManager() {
	};

	public static ExtentReports createReport() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

		String fileName = System.getProperty("user.dir") + File.separator + Constants.REPORTPATH.readProperty()
				+ File.separator + String.format("TestReport_%s.html", currentDate);

		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
		extentReport.attachReporter(spark);
		return extentReport;
	}

}
