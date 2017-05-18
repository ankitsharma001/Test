package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class ExcelUtils {

		private static XSSFSheet ExcelWSheet;

		private static XSSFWorkbook ExcelWBook;

		private static XSSFCell Cell;

		private static XSSFRow Row1;
		
/*		public static void main(String args[]) throws IOException {
			// TODO Auto-generated method stub
			String Str1 = ExcelUtils.getData(14, 1, 13);
			System.out.println(Str1);
			String Str = ExcelUtils.getData(14, 2, 13);
			System.out.println(Str);
		}
		
		*/
		public static String getData(int row, int col, int flag){
			String value = null;
			try{
			 FileInputStream file = new FileInputStream (new File("C:\\Users\\admin\\git\\Fleet Management\\Fleet\\TestData.xlsx"));
			 Workbook mybook = new XSSFWorkbook(file);
			 String sheetname = "Sheet1";
			 Sheet mysheet = mybook.getSheet(sheetname);
			 Iterator<Row> iterator = mysheet.iterator();
			 iterator.next();
			 int var = 0;
			 while (iterator.hasNext()) {
		          
				 Row nextRow = iterator.next();
		           if(var == flag){
		        	   value = nextRow.getCell(col).toString();
		        	  break;
		           }
		           var++;
		           /*String str1 = nextRow.getCell(col).toString();
		           System.out.println(str1);*/
		           
			 }
			
			}catch(Exception E){
				System.out.println("File not Found");
				Log.error("File not Found");
			}
			 return value;
		}
	}