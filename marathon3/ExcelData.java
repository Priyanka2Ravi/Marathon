package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static String[][] readData(String fileName) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook wbook = new XSSFWorkbook("./TestData/" + fileName + ".xlsx");
		XSSFSheet xsheet = wbook.getSheetAt(0);
		int rowCount = xsheet.getLastRowNum();
		System.out.println(rowCount);
		int colCount = xsheet.getRow(0).getLastCellNum();
		System.out.println(colCount);

		String[][] data = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = xsheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				String cellvalue = row.getCell(j).getStringCellValue();
				data[i - 1][j] = cellvalue;
			}
		}

		wbook.close();
		return data;
	}

}
