package com.testyentra.paytm.nativeapp.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aventstack.extentreports.Status;
import com.testyentra.paytm.nativeapp.init.UniversalVariables;

public class ExcelLibaray {
	
	public static UniversalVariables uniVariable=new UniversalVariables();
	public static Workbook _createWorkbook(String path,String methodName) {
		try {
			uniVariable.wb=WorkbookFactory.create(new FileInputStream(path));
		} catch (EncryptedDocumentException e) {
			UniversalVariables.test.log(Status.INFO,methodName+": throws EncryptedDocumentException " );
		} catch (InvalidFormatException e) {
			UniversalVariables.test.log(Status.INFO,methodName+": throws InvalidFormatException " );
		} catch (FileNotFoundException e) {
			UniversalVariables.test.log(Status.INFO,methodName+": throws FileNotFoundException " );
		} catch (IOException e) {
			UniversalVariables.test.log(Status.INFO,methodName+": throws IOException " );
		}
		return uniVariable.wb;
	}
	
	//Method to get the row count from the excel
	/*
	 * @param path       absolute path of the excel 
	 * @param sheetname  name of the sheet relative to excel.
	 * @return           count of rows in excel
	 */
	public static int _getNoOfRowsFromExcel(String path, String sheetname)  {
		class Local {};
	      String methodName = Local.class.getEnclosingMethod().getName();
	     Workbook workBook = _createWorkbook(path,methodName);
		int iRowCount = workBook.getSheet(sheetname).getLastRowNum();
		return iRowCount;
		
	}
	//Method to get the cell count from the excel
		/*
		 * @param path       absolute path of the excel 
		 * @param sheetname  name of the sheet relative to excel.
		 * @param rowNum     row number of which we want to get the cell count
		 * @return           count of rows in excel
		 */
	public static int _getNoOfColumnsFromExcel(String path,String sheetname,int rowNum ) {
		class Local {};
	      String methodName = Local.class.getEnclosingMethod().getName();
	      Workbook workBook = _createWorkbook(path,methodName);
	      try {
			String cellData = workBook.getSheet(sheetname).getRow(rowNum).getCell(0).toString();
			if(cellData!=null)
			{
				return  workBook.getSheet(sheetname).getRow(rowNum).getLastCellNum();
			}
			else
			{
				return 0;
			}
	      }
	      catch(NullPointerException e)
	      {
	    	  UniversalVariables.test.log(Status.INFO,methodName+": In excel the given row has NO data " );
	    	  return -1;
	      }
	}
	//Method to get the cell data from the excel
			/*
			 * @param path       absolute path of the excel 
			 * @param sheetname  name of the sheet relative to excel.
			 * @param rowNum     row number of which we want to get the cell count
			 * @param columnNum  column number of which we want to get the cell count
			 * @return           String / value from the cell
			 */
	
	public static String _getCellData(String path, String sheetname,int rowNum,int columnNum) {
		class Local {};
	      String methodName = Local.class.getEnclosingMethod().getName();
	      Workbook workBook = _createWorkbook(path,methodName);
	      try {
	    	  String value = workBook.getSheet(sheetname).getRow(rowNum).getCell(columnNum).getStringCellValue().toString();
	    	  UniversalVariables.test.log(Status.INFO,methodName+":"+value );
	    	  return value;
	    	 
	    	 }
	      catch(NullPointerException e)
	      {
	    	  UniversalVariables.test.log(Status.INFO,methodName+": In excel the cell has NO data " );
	    	  return null;
	      }
	}
	
	//method to write the data into the Excel based on row number and column number
	/*
	 * @param path       absolute path of the excel 
	 * @param sheetname  name of the sheet relative to excel.
	 * @param rowNum     row number of which we want to get the cell count
	 * @param columnNum  column number of which we want to get the cell count
	 * @param data		 data need to be entered in the cell
	 * @return           void
	 */
	public static void _writeDataByRowAndCellNumber(String path,String sheetname,int rowNum,int columnNum,String data) {
		class Local {};
	      String methodName = Local.class.getEnclosingMethod().getName();
	      Workbook workBook = _createWorkbook(path,methodName);
	     
	    	  try {
	    		  if( workBook.getSheet(sheetname).getRow(rowNum).getCell(0).getStringCellValue().toString()!=null)
		    	  {
		    		  if( workBook.getSheet(sheetname).getRow(rowNum).getCell(columnNum).toString()!=null)
		    		  {
		    		  workBook.getSheet(sheetname).getRow(rowNum).createCell(columnNum).setCellValue(data);
		    		  }
		    		  else {
		    			  workBook.getSheet(sheetname).getRow(rowNum).getCell(columnNum).setCellValue(data);
		    		  }
		    	  }
		    	  
	    		  
	    	  }
	    	  catch(NullPointerException e)
	    	  {
	    		 
		    		  workBook.getSheet(sheetname).createRow(rowNum).createCell(columnNum).setCellValue(data);
		    	  
	    	  }
	      try {
			UniversalVariables.fos = new FileOutputStream(path);
			workBook.write(UniversalVariables.fos);
		      UniversalVariables.fos.close();
		} catch (FileNotFoundException e) {
			UniversalVariables.test.log(Status.INFO,methodName+": throws FileNotFoundException " );
		} catch (IOException e) {
			UniversalVariables.test.log(Status.INFO,methodName+": throws IOException " );
		}
	      
	  }
	
	//Method to write the data into excel as list(single column)
	public static void _writeDataIntoExcelAsList(String path,String sheetname,ArrayList list,int columnNum) {
		class Local {};
	      String methodName = Local.class.getEnclosingMethod().getName();
	      Workbook workBook = _createWorkbook(path,methodName);
	     int lastRow = workBook.getSheet(sheetname).getLastRowNum();
	     for(Object l:list) {
	    	 workBook.getSheet(sheetname).createRow(lastRow++).createCell(columnNum).setCellValue(l.toString());
	     }
	     try {
				UniversalVariables.fos = new FileOutputStream(path);
				workBook.write(UniversalVariables.fos);
			      UniversalVariables.fos.close();
			} catch (FileNotFoundException e) {
				UniversalVariables.test.log(Status.INFO,methodName+": throws FileNotFoundException " );
			} catch (IOException e) {
				UniversalVariables.test.log(Status.INFO,methodName+": throws IOException " );
			}
	     
	      
	}

}
