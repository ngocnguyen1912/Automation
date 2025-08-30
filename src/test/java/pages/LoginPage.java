package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void login(String userName,String passWord){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


    }

}
