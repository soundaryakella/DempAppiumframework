package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testyentra.paym.nativeapp.actions.DriverActions;
import com.testyentra.paytm.nativeapp.libraries.BaseLibaray;
import com.testyentra.paytm.nativeapp.libraries.ExcelLibaray;
import com.testyentra.paytm.nativeapp.pages.HomePage;
import com.testyentra.paytm.nativeapp.pages.ListOfProductsPage;
import com.testyentra.paytm.nativeapp.pages.productsDetails;

import io.appium.java_client.android.AndroidDriver;

public class Assign_001 extends BaseLibaray {
	@Test
    public void _addToCart() throws InterruptedException {
		HomePage hmp=new HomePage(uniVariable.driver);
		Thread.sleep(2000);
		hmp._clickOnSearchBox(uniVariable.driver);
		Thread.sleep(2000);
		hmp._sendDataToSearchBox(ExcelLibaray._getCellData("D:\\soundarya\\AppiumFramework\\appiumframework\\src\\main\\resources\\001.xlsx", "Sheet1", 1, 0));
		 DriverActions tap=new  DriverActions();
		Thread.sleep(2000);
		tap._tapUsingCoordinates(uniVariable.driver,1001,2055);
		Thread.sleep(2000);
		for(int i=0;i<4;i++)
		{
			WebElement ele=null;
			try {
				String value1 = ExcelLibaray._getCellData("D:\\soundarya\\AppiumFramework\\appiumframework\\src\\main\\resources\\001.xlsx", "Sheet1", 1, 1);	
		 ele = uniVariable.driver.findElementByXPath("//android.widget.TextView[@text='"+value1+"']");
		 Thread.sleep(2000);
		 tap._clickOnElement(uniVariable.driver, ele);
		 break;
			}
			catch(Exception e) {
				tap.scrollBottomToTop(663, 2000, uniVariable.driver);
				 Thread.sleep(2000);
			}
		
		
		}
		
		SoftAssert soft=new SoftAssert();
		Thread.sleep(2000);
		productsDetails prod=new productsDetails(uniVariable.driver);
		String Actual = prod._getTitle();
		soft.assertEquals(Actual, ExcelLibaray._getCellData("D:\\soundarya\\AppiumFramework\\appiumframework\\src\\main\\resources\\001.xlsx", "Sheet1", 1, 2));
		
		Thread.sleep(2000);
		
	
			prod._addToCartBTN(uniVariable.driver);

		soft.assertAll();
		  
//		ListOfProductsPage list=new ListOfProductsPage(uniVariable.driver);
//		List<WebElement> products = list._searchByProductName(uniVariable.driver);
//		for( WebElement l:products)
//		{
//			Thread.sleep(2000);
//			Reporter.log(l.getText(),true);
//		}
		
		
		
		
		
	}
//	@Test
//	public void _changeThePincode() throws InterruptedException {
//		HomePage hmp=new HomePage(uniVariable.driver);
//		Thread.sleep(2000);
//		hmp._clickOnCartSymbol(uniVariable.driver);
//	}
	
		
	}


