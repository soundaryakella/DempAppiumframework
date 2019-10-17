package com.testyentra.paytm.nativeapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testyentra.paym.nativeapp.actions.DriverActions;

import io.appium.java_client.android.AndroidDriver;

public class ListOfProductsPage {
	
	DriverActions tap=new  DriverActions();

	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private List<WebElement> productNames;
	public List<WebElement> _searchByProductName(AndroidDriver driver)
	{
		return productNames;
		
	}
	public ListOfProductsPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
