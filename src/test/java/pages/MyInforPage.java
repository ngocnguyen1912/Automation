package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInforPage {
    private WebDriver driver;
    public MyInforPage(WebDriver driver){
        this.driver=driver;
    }
    public String getInfor(){
        WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        WebElement lasttName=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

        return firstName.getAttribute("value").trim()+lasttName.getAttribute("value").trim();
    }
    public String getDisplayName(){
        return driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
    }
}
