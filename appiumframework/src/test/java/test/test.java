package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NotFoundException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testyentra.paym.nativeapp.actions.DriverActions;
import com.testyentra.paytm.nativeapp.init.UniversalVariables;
import com.testyentra.paytm.nativeapp.libraries.BaseLibaray;
import com.testyentra.paytm.nativeapp.libraries.ExcelLibaray;
import com.testyentra.paytm.nativeapp.listener.MyListeners;


public class test extends BaseLibaray {
	@Test
	    public void testServer() throws InterruptedException  {
//		System.out.println("started");
//		try {
//			uniVariable.driver.openNotifications();
//			UniversalVariables.test.log(Status.INFO, "notification performed");
//		}
//		catch(NotFoundException e)
//		{
//			UniversalVariables.test.log(Status.INFO, "notification Not performed");
//		}
//		ExcelLibaray excel = new ExcelLibaray();
//		int count = excel._getNoOfRowsFromExcel("E:/practiceExcels/excel1.xlsx", "Sheet1");
//		System.out.println(count);
//		System.out.println(excel._getNoOfColumnsFromExcel("E:/practiceExcels/excel1.xlsx","Sheet1",5 ));
//		System.out.println(excel._getCellData("E:/practiceExcels/excel1.xlsx", "Sheet1", 3, 1));
//		excel._writeDataByRowAndCellNumber("E:/practiceExcels/excel1.xlsx", "Sheet1", 3, 1, "newCell");
//		excel._writeDataByRowAndCellNumber("E:/practiceExcels/excel1.xlsx", "Sheet1", 3, 0, "xxxx");
//		excel._writeDataByRowAndCellNumber("E:/practiceExcels/excel1.xlsx", "Sheet1", 4, 1, "newronewcell");
//		ArrayList li=new ArrayList();
//		li.add("fruits");
//		li.add("Veggies");
//		li.add("juice");
//		li.add("dryfruits");
//		excel._writeDataIntoExcelAsList("E:/practiceExcels/excel1.xlsx", "Sheet1", li, 1);
		
		//swipeActions
		DriverActions act=new DriverActions();
		act.swipeRightToLeft(1636, 2000, uniVariable.driver);
		Thread.sleep(6000);
//		act.scrollBottomToTop(849, 2000, uniVariable.driver);
//		Thread.sleep(2000);
		act.scrollTopToBottom(849, 2000, uniVariable.driver);
		
	}

}
