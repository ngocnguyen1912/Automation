package script;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Excel;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest{
    private static final Logger logger= LogManager.getLogger(LoginTest.class);
    @DataProvider(name = "loginData")
    public Object[][] LoginData() {
        String filePath = "src/test/java/resources/login.xlsx";

        String sheetName = "Sheet1";
// Lấy tổng số dòng (bao gồm header)
        int totalRows = Excel.getRowCount(filePath, sheetName);

        // Bỏ dòng tiêu đề → số dòng data
        int rowCount = totalRows - 1;

        // Lấy số cột
        int colCount = Excel.getColCount(filePath, sheetName);

        Object[][] data = new Object[rowCount][colCount];

        // tạo biến số dòng dữ liệu (không bao gồm dòng tiêu đề)
//        int rowCount = 4;

        // tạo mảng 2 chiều để lưu dữ liệu
//        Object[][] data = new Object[rowCount][3];

        for (int i = 0; i < rowCount; i++) {
            // lấy dữ liệu cho username
            data[i][0] = Excel.getCellData(filePath, sheetName, i + 1, 0);

            // lấy dữ liệu cho password
            data[i][1] = Excel.getCellData(filePath, sheetName, i + 1, 1);

            // expectedResult
            data[i][2] = Excel.getCellData(filePath, sheetName, i + 1, 2);
        }

        // trả dữ liệu ra ngoài
        return data;
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult) {
        try{
            logger.info("Đang test với username: {}",username);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);
            Thread.sleep(2000);
            Boolean isLogged = driver.getCurrentUrl().contains("dashboard");
            logger.info("kết quả : {}",isLogged);
//            if (Boolean.parseBoolean(expectedResult) == isLogged) {
//                System.out.println("test pass");
//            } else {
//                System.out.println("test fail");
//            }
            Assert.assertEquals(isLogged,Boolean.parseBoolean(expectedResult),"không đúng kết quả");
            System.out.println(" đúng");
            logger.info("Test pass");

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
