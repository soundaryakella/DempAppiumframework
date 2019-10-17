package com.testyentra.paytm.nativeapp.listener;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testyentra.paytm.nativeapp.init.UniversalVariables;

public class ExtendReportsIntialzers { 
	
	public static void _intializeExtentReports(String path) {
		UniversalVariables uniVariable=new UniversalVariables();
		uniVariable.report=new ExtentHtmlReporter(new File(path));
		uniVariable.extent=new ExtentReports();
		UniversalVariables.extent.attachReporter(uniVariable.report);
		
	}

}
