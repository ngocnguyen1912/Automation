package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    private WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver=driver;
    }
    public void gotoPimPage(){
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
    }
    public void gotoAdminPage(){
        driver.findElement(By.xpath("//li[1]//a[1]//span[1]")).click();
    }
    public void gotoMyInfoPage(){
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
    }
}
