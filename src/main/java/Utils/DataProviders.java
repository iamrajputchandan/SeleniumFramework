package Utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;

import Utils.ExcelUtils;

public class DataProviders {

    @DataProvider(name = "testData")
    public Object[][] getLoginData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";

        ExcelUtils.setExcelFile(path, "Sheet1");

        return ExcelUtils.getDataAsMap();
    }
}