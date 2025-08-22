package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.MyInforPage;

public class Compareinfo {
    private WebDriver driver;
    //    public AddemployeeTest(){
//
//    }
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
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
        dashBoardPage.gotoMyInfoPage();
        System.out.println("Chuyển sang trang Info");
        sleep(5000);
        MyInforPage myInforPage=new MyInforPage(driver);
        String fullname= myInforPage.getInfor();
        String displayname=myInforPage.getDisplayName();
        sleep(5000);
        if(fullname.equalsIgnoreCase(displayname)){
            System.out.println("Kết quả trùng khớp");
        }
        else {
            System.out.println("Kết quả không trùng khớp");
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

