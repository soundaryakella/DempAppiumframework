package com.testyentra.paytm.nativeapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testyentra.paym.nativeapp.actions.DriverActions;

import io.appium.java_client.android.AndroidDriver;

public class productsDetails {
	
	DriverActions tap=new  DriverActions();
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[13]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View")
	private WebElement title;
	public String _getTitle()
	{
		System.out.println(title.getText());
		return title.getText().toString();
		
	}
	
	@FindBy(xpath="//android.widget.Button[@text='Add to Cart']")
	private WebElement addToCart;
	public void _addToCartBTN(AndroidDriver driver)
	{
		tap._clickOnElement(driver, addToCart);
		
	}
	
	public productsDetails(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
