package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Screenshot;

public class BaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        sleep(5000);
    }
    protected void sleep(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Screenshot.capturescreenshot(driver, "Addemployee");
        }
        driver.quit();
    }
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit(); // chỉ quit 1 lần sau khi chạy hết cả class
//        }
//    }

}
