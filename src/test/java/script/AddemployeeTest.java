package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("Admin","admin123");
        System.out.println("Đăng nhập thành công");
        sleep(5000);
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.gotoPimPage();
        System.out.println("Chuyển sang trang PIM");
        sleep(5000);
        AddEmployee addemployee=new AddEmployee(driver);
//        String firstname="hello";
//        String lastname="hi";
        String filePath="src/test/java/resources/Automation.xlsx";
        String firstname= Excel.getCellData(filePath,"sheet1",1,0);
        String lastname= Excel.getCellData(filePath,"sheet1",1,1);

        addemployee.goToAddEmployee();
        System.out.println("thêm thành công");
        sleep(5000);
        String id=addemployee.employ(firstname,lastname);
        boolean verifyEmployee=addemployee.verifyEmploy(firstname,lastname,id);
        if(verifyEmployee){
            System.out.println("trùng khớp");
        }
        else {
            System.out.println("không trùng khớp");
        }
    }




}
