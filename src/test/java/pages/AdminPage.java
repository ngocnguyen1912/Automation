package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage {
    private WebDriver driver;
    public AdminPage(WebDriver driver){
        this.driver=driver;
    }
    public void searchUser(String UserName){
        WebElement username=driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        username.sendKeys(UserName);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    }
    public boolean isUserFound(String userExpected){
        List<WebElement> rows=driver.findElements(By.xpath(".//div[@class='oxd-table-body']"));

        for (WebElement row:rows){
            System.out.println(row);
            String actuallyUserName = row.findElement(By.xpath(".//div[@class='oxd-table-body']//div[1]//div[1]//div[2]")).getText();
            System.out.println(actuallyUserName);
            if(actuallyUserName.equalsIgnoreCase(userExpected)){
                return true;
            }

        }
        return false;
    }
}
