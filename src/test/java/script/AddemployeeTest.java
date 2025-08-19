package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.DashBoardPage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class AddemployeeTest {
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
        dashBoardPage.gotoPimPage();
        System.out.println("Chuyển sang trang PIM");
        sleep(5000);
        AddEmployee addemployee=new AddEmployee(driver);
        String firstname="hello";
        String lastname="hi";
        addemployee.goToAddEmployee();
        System.out.println("chuyển trang thành công");
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

    private void sleep(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @AfterClass
    public void clear(){
        driver.quit();
    }
}
