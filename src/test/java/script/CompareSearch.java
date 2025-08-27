package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.AdminPage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.Driverfactory;

import java.time.Duration;

public class CompareSearch extends BaseTest {

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        System.out.println("Đăng nhập thành công");
        sleep(5000);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.gotoAdminPage();
        System.out.println("Chuyển sang trang PIM");
        sleep(5000);
        AdminPage adminPage = new AdminPage(driver);
        String userName = "Admin";
        adminPage.searchUser(userName);
        Boolean isuserfound = adminPage.isUserFound(userName);
        if (isuserfound) {
            System.out.println("tìm thấy User");
        } else {
            System.out.println("không tìm thấy User");
        }
    }

}
