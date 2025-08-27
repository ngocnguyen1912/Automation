package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.MyInforPage;

import java.time.Duration;

public class Compareinfo extends BaseTest {

    //    public AddemployeeTest(){
//
//    }
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        System.out.println("Đăng nhập thành công");
        sleep(5000);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.gotoMyInfoPage();
        System.out.println("Chuyển sang trang Info");
        sleep(5000);
        MyInforPage myInforPage = new MyInforPage(driver);
        String fullname = myInforPage.getInfor();
        String displayname = myInforPage.getDisplayName();
        sleep(5000);
        if (fullname.equalsIgnoreCase(displayname)) {
            System.out.println("Kết quả trùng khớp");
        } else {
            System.out.println("Kết quả không trùng khớp");
        }
    }
}

