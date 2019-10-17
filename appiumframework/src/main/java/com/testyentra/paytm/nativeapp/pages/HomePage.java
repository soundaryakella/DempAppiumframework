package com.testyentra.paytm.nativeapp.pages;

import java.lang.reflect.Field;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.testyentra.paym.nativeapp.actions.DriverActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	DriverActions tap=new  DriverActions();
	
	@FindBy(xpath="//android.widget.EditText[@resource-id='in.amazon.mShop.android.shopping:id/rs_search_src_text']")
	private WebElement searchBox;
	public void _clickOnSearchBox(AndroidDriver driver)
	{
		tap._clickOnElement(driver, searchBox);
		
	}
	public void _sendDataToSearchBox(String data)
	{
		searchBox.sendKeys(data);
	}
	
	@FindBy(id="in.amazon.mShop.android.shopping:id/action_bar_cart_count")
	private WebElement cartSymbol;
	public void _clickOnCartSymbol(AndroidDriver driver)
	{
		tap._clickOnElement(driver, cartSymbol);
	}
	
	public HomePage(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}