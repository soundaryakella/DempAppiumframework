package com.testyentra.paym.nativeapp.actions;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.testyentra.paytm.nativeapp.init.UniversalVariables;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DriverActions {
	//Method to Swipe Right to Left
		public static void swipeRightToLeft(int y, int time,AndroidDriver driver)
		{
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
		UniversalVariables.ScreenDimensions =driver.manage().window().getSize();
		int startX = (int)(UniversalVariables.ScreenDimensions.width *0.90);
		int endX = (int)(UniversalVariables.ScreenDimensions.width *0.10);
		try {
			driver.swipe(startX, y, endX, y, time);
			UniversalVariables.test.log(Status.INFO,methodName+": performed swipe Right to left" );
		}
		catch(Exception e)
		{
			UniversalVariables.test.log(Status.INFO,methodName+": Not performed swipe Right to left" );
		}
		
		}
		
		//Method to Swipe Left to Right
		public static void swipeLeftToRight(int y, int time, AndroidDriver driver)
		{
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
			UniversalVariables.ScreenDimensions =driver.manage().window().getSize();
			int startX = (int)(UniversalVariables.ScreenDimensions.width *0.10);
			int endX = (int)(UniversalVariables.ScreenDimensions.width *0.90);
			
			try {
				driver.swipe(startX, y, endX, y, time);
				UniversalVariables.test.log(Status.INFO,methodName+": performed swipe Left to Right" );
			}
			catch(Exception e)
			{
				UniversalVariables.test.log(Status.INFO,methodName+": Not performed swipe Left to Right" );
			}
			
		}
		
		//Method to Scroll Top to bottom
		public static void scrollTopToBottom(int x,int time , AndroidDriver driver)
		{
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
			UniversalVariables.ScreenDimensions =driver.manage().window().getSize();
			int startY = (int)(UniversalVariables.ScreenDimensions.height *0.10);
			int endY = (int)(UniversalVariables.ScreenDimensions.height *0.90);
			
			
			try {
				driver.swipe(x, startY, x, endY, time);
				UniversalVariables.test.log(Status.INFO,methodName+": performed scroll Top to Bottom" );
			}
			catch(Exception e)
			{
				UniversalVariables.test.log(Status.INFO,methodName+": Not performed scroll Top to Bottom" );
			}
		}

		
		//Method to Scroll bottom to top
		public static void scrollBottomToTop(int x,int time , AndroidDriver driver)
		{
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
		UniversalVariables.ScreenDimensions =driver.manage().window().getSize();
		int startY = (int)(UniversalVariables.ScreenDimensions.height *0.90);
		int endY = (int)(UniversalVariables.ScreenDimensions.height *0.10);
		
		try {
			driver.swipe(x, startY, x, endY, time);
			UniversalVariables.test.log(Status.INFO,methodName+": performed scroll Bottom to Top" );
		}
		catch(Exception e)
		{
			UniversalVariables.test.log(Status.INFO,methodName+": Not performed scroll Bottom to Top" );
		}
		}
		
		//Method to scroll to the element
		public WebElement _scrollToElement(AndroidDriver driver,String resourceId ,String classname,String text) {
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
			try {
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(text))");
				WebElement ele = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"resourceId\")).getChildByText(new UiSelector().className(\"classname\"), \"text\")");
			UniversalVariables.test.log(Status.INFO,methodName+": scrolled to the element" );
			return ele;
			}
			
			catch(Exception e)
			{
				UniversalVariables.test.log(Status.FAIL,methodName+": Not scrolled to the element" );
			}
			return null;
		}
		
		//Method to tap using co-ordinates
		public void _tapUsingCoordinates(AndroidDriver driver,int Xcoordinate,int Ycoordinate) {
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
			TouchAction act1 = new TouchAction((MobileDriver)driver);
			try {
			act1.press(Xcoordinate, Ycoordinate).release().perform();
			UniversalVariables.test.log(Status.PASS,methodName+": Tapped on the element" );
			}
			catch(Exception e)
			{
				UniversalVariables.test.log(Status.FAIL,methodName+": Not Tapped on the element" );
			}
			
		}
		
		//Method to click on the element
		public void _clickOnElement(AndroidDriver driver,WebElement element) {
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
			try {
			element.click();
			UniversalVariables.test.log(Status.PASS,methodName+": Performed click on the element" );
			}
			catch(Exception e)
			{
				UniversalVariables.test.log(Status.FAIL,methodName+": Not Performed click on the element" );
			}
		}
		
		//Method to zoom in
		public void _zoomIn(AndroidDriver driver,int startPointX,int startPointY,int endPoint1X,int endPoint1Y,int endPoint2X,int endPoint2Y) {
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
			MultiTouchAction maction = new MultiTouchAction((MobileDriver)driver);
			TouchAction act1 = new TouchAction((MobileDriver)driver);
			act1.longPress(startPointX,startPointY, 2000).moveTo(endPoint1X, endPoint1Y).waitAction(2000);
			TouchAction act2 = new TouchAction((MobileDriver)driver);
			act2.longPress(startPointX,startPointY, 2000).moveTo(endPoint2X,endPoint2Y).waitAction(2000);
			try {
			maction.add(act1).add(act2).perform();
			UniversalVariables.test.log(Status.PASS,methodName+": Performed Zoom-in" );
			}
			catch(Exception e)
			{
				UniversalVariables.test.log(Status.FAIL,methodName+": Not Performed Zoom-in" );
			}
		}
		//Method to double tap based on co-ordinates
		public void _doubleTap(AndroidDriver driver,int x,int y) {
			class Local {};
		      String methodName = Local.class.getEnclosingMethod().getName();
		      try {
			new TouchAction((MobileDriver)driver).press(x,y).release().perform().press(x,y).release().perform();
			UniversalVariables.test.log(Status.PASS,methodName+": Performed DoubleTap" );
		      }
		      catch (Exception e) {
		    	  UniversalVariables.test.log(Status.FAIL,methodName+": Not Performed DoubleTap" );
		      }
		}
}
