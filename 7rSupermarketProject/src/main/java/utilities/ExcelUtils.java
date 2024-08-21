package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtils {
	
	public static FileInputStream f;
	public static XSSFWorkbook  w;
	public static XSSFSheet sh;

	 public static String getStringData(int a,int b,String sheet) throws IOException
	    {
		 
		 	String filepath=Constants.TESTDATAFILE;
	    	f=new FileInputStream(filepath);
	    	w=new XSSFWorkbook(f);
	    	sh=w.getSheet(sheet);
	    	Row r=sh.getRow(a);//Interface
	    	Cell c=r.getCell(b);//Interface
	    	return c.getStringCellValue();//method for returning cell value
	    }
	    public static String getIntegerData(int a,int b,String sheet) throws IOException
	    {
	    	String filepath=Constants.TESTDATAFILE;
	    	f=new FileInputStream(filepath);
	    	w=new XSSFWorkbook(f);
	    	sh=w.getSheet(sheet);
	    	Row r=sh.getRow(a);//Interface
	    	Cell c=r.getCell(b);//Interface
	    	int x=(int) c.getNumericCellValue();//type casting String value to integer value
	    	return String.valueOf(x);
	    }

}
