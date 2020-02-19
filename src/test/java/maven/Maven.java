package maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Maven {
	public static void main(String[] args) throws Throwable {
		File f=new File("C:\\Users\\shalom daniel\\eclipse-workspace\\Maven\\form2.xlsx");
		FileInputStream stream=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet("form");
		//Row r = s.getRow(1);
		//Cell c = r.getCell(0);
		//System.out.println(c);
		
		System.out.println("to read all valus in a sheeet");
		
		for(int i=1;i<s.getPhysicalNumberOfRows();i++)
		{
			Row r1 = s.getRow(i);
			for(int j=0;j<r1.getPhysicalNumberOfCells();j++)
			{
			Cell c1 = r1.getCell(j);
			//String stringCellValue = c1.getStringCellValue();
			//System.out.println(stringCellValue);
			//System.out.println(c1);
			int type = c1.getCellType();
			if(type==1)
			{
				String stringCellValue = c1.getStringCellValue();
				System.out.println(stringCellValue);
			}
			else if (DateUtil.isCellDateFormatted(c1)) {
				Date dateCellValue = c1.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd-mmm-yy");
				String format = sim.format(dateCellValue);
				System.out.println(format);
				
				
			}
			else
			{
				double numericCellValue = c1.getNumericCellValue();
				long l=(long) numericCellValue;
				String valueOf = String.valueOf(l);
				System.out.println(valueOf);
				System.out.println(valueOf);
				
			}
			}
		}
		//Sheet s1 = w.createSheet("form");
		Row r1 = s.createRow(2);
		Cell c1 = r1.createCell(0);
		c1.setCellValue("selenium");
		FileOutputStream os=new FileOutputStream(f);
		w.write(os);
		System.out.println("done");
		
		
	}

}
