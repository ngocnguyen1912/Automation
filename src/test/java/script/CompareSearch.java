package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.AdminPage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.Driverfactory;

public class CompareSearch {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
        driver= Driverfactory.getDriver();
        sleep(1000);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        sleep(5000);
    }

    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("Admin","admin123");
        System.out.println("Đăng nhập thành công");
        sleep(5000);
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.gotoAdminPage();
        System.out.println("Chuyển sang trang PIM");
        sleep(5000);
        AdminPage adminPage=new AdminPage(driver);
        String userName= "Admin";
        adminPage.searchUser(userName);
        Boolean isuserfound=adminPage.isUserFound(userName);
        if (isuserfound){
            System.out.println("tìm thấy User");
        }
        else {
            System.out.println("không tìm thấy User");
        }
    }

    private void sleep(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
//    @AfterClass
//    public void clear(){
//        driver.quit();
//    }

}
