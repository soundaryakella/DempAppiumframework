package com.testyentra.paytm.nativeapp.libraries;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.testyentra.paytm.nativeapp.init.UniversalVariables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseLibaray {
	/* instantiating the UniversalVariables class to access the non-static variables*/
	public static UniversalVariables uniVariable=new UniversalVariables();
	
	/*
	 * _setTheCapabilities method will start the server by taking the parameters.
	 */
	@Parameters({"platformVersion","deviceName","UDID","serverPort","ipaddress"})
	@BeforeTest
	public void _setTheCapabilities(String platformVersion,String deviceName,String UDID,int serverPort,String ipaddress)
	{
		//Set Capabilities
		uniVariable.capabilities = new DesiredCapabilities();
		uniVariable.capabilities.setCapability("noReset", "true");
		uniVariable.capabilities.setCapability("fullReset","false");
		uniVariable.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		uniVariable.capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
		uniVariable.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName );
		uniVariable.capabilities.setCapability(MobileCapabilityType.UDID, UDID);
		uniVariable.capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		uniVariable.capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		
		//Build the Appium service
		uniVariable.builder = new AppiumServiceBuilder();
		uniVariable.builder.withIPAddress(ipaddress);
		uniVariable.builder.usingPort(serverPort);
		uniVariable.builder.withCapabilities(uniVariable.capabilities);
		try {
			uniVariable.driver=new AndroidDriver(new URL("http://"+ipaddress+":"+serverPort+"/wd/hub"),uniVariable.capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@BeforeClass
	public void _startServer()
	{
		
		//Start the server with the builder
		uniVariable.service = AppiumDriverLocalService.buildService(uniVariable.builder);
		uniVariable.service.start();
		
	}
//	@BeforeMethod
//	public void _launchApp()
//	{
//		uniVariable.driver.launchApp();
//	}
	@AfterMethod
	public void _closeApp()
	{
		uniVariable.driver.closeApp();
	}

	@AfterClass
	public void _endServer()
	{
		uniVariable.service.stop();
		
	}
}
