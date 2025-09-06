package script;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AddEmployee;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.Excel;
import utils.Screenshot;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AddemployeeTest extends BaseTest {
//    public AddemployeeTest(){
//
//    }

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//    private static final Logger employ= LogManager.getLogger(AddemployeeTest.class);
    @DataProvider(name = "EmployeeData")
    public Object[][] EmployeeData() {
        String filePath = "src/test/java/resources/login.xlsx";
        String sheetName = "Sheet2";
// Lấy tổng số dòng (bao gồm header)
        int totalRows = Excel.getRowCount(filePath, sheetName);
        // Bỏ dòng tiêu đề → số dòng data
        int rowCount = totalRows - 1;
        // Lấy số cột
        int colCount = Excel.getColCount(filePath, sheetName);

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            // lấy dữ liệu cho firstName
            data[i][0] = Excel.getCellData(filePath, sheetName, i + 1, 0);

            // lấy dữ liệu cho LastName
            data[i][1] = Excel.getCellData(filePath, sheetName, i + 1, 1);
        }
        // trả dữ liệu ra ngoài
        return data;
    }
    @BeforeMethod
    public void loginOnce() {

    }
    @Test(dataProvider = "EmployeeData")
    public void testSuccessfullLogin(String lastname, String firstname) {

//        Login vào
//        employ.info("đang test với: {} ",firstname);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        System.out.println("Đăng nhập thành công");
        sleep(2000);
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.gotoPimPage();
        System.out.println("Chuyển sang trang PIM");
        sleep(5000);

//        tiến hành thêm user
        AddEmployee addemployee=new AddEmployee(driver);
//        String firstname="hello";
//        String lastname="hi";
//        String filePath="src/test/java/resources/login.xlsx";
        addemployee.goToAddEmployee();
        sleep(2000);
        String id=addemployee.employ(firstname,lastname);
        sleep(2000);
        System.out.println("thêm thành công");
        boolean verifyEmployee=addemployee.verifyEmploy(firstname,lastname,id);
//        employ.info("kết quả : {} ",verifyEmployee);
//        Assert.assertEquals(verifyEmployee,);
        if(verifyEmployee){
            System.out.println("trùng khớp");
        }
        else {
            System.out.println("không trùng khớp");
        }
    }
}
