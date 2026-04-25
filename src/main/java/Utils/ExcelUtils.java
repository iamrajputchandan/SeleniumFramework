package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    // Load Excel
    public static void setExcelFile(String path, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get total rows
    public static int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Get total columns
    public static int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    // Get cell data
    public static String getCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).toString();
    }

    // Convert entire Excel to Object[][]
    public static Object[][] getSheetData() {
        int rows = getRowCount();
        int cols = getColCount();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {  // skip header
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = getCellData(i, j);
            }
        }
        return data;
    }
    
    public static Object[][] getDataAsMap() {

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][1];

        for (int i = 1; i < rowCount; i++) {

            Map<String, String> map = new HashMap<>();

            for (int j = 0; j < colCount; j++) {

                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = getCellData(i, j);

                map.put(key, value);
            }

            data[i - 1][0] = map;
        }

        return data;
    }
}