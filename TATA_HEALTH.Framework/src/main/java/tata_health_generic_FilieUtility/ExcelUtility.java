package tata_health_generic_FilieUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String SheetName, int RowNum, int CellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/TATA_HEALTH_DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCount(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/TATA_HEALTH_DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}

	public void setDataIntoExcel(String SheetName, int RowNum, int CellNum, String Data) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/TATA_HEALTH_DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(RowNum).createCell(CellNum).setCellValue(Data);
		FileOutputStream fos = new FileOutputStream("./src/main/resources/TATA_HEALTH_DATA.xlsx");
		wb.write(fos);
		wb.close();
	}
}
