package com.testyentra.paytm.nativeapp.init;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * 
 * 
 * @author k soundarya
 * Description:Declaring the AndroidDriver,DesriredCapabilities variable as non-static.
 * to utilize need to create instance of this class UniversalVariables and with the help
 * of reference variable, these variables can be accessed.
 *
 */

public class UniversalVariables {
	
	public AndroidDriver driver=null;
	public DesiredCapabilities capabilities=null;
	public AppiumDriverLocalService service=null;;
	public AppiumServiceBuilder builder=null;;
	public Workbook wb=null;
	public static FileOutputStream fos=null;
	public static ExtentHtmlReporter report=null;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	public static Dimension ScreenDimensions=null;
	
	
}
