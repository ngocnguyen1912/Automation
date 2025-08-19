package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployee {
    private WebDriver driver;
    public AddEmployee(WebDriver driver){
        this.driver=driver;
    }
    public void goToAddEmployee(){
        driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();
    }
    public String employ(String firstName, String lastName ){
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        String employID=driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).getAttribute("value").trim();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        return employID;

    }
    public boolean verifyEmploy(String ExpectFirstName,String ExpectLastName,String ExpectID){
        String actuallyFirstName=driver.findElement(By.xpath("//input[@placeholder='First Name']")).getAttribute("value").trim();
        String actuallyLastName=driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getAttribute("value").trim();
        String actuallyID=driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).getAttribute("value").trim();
        return actuallyFirstName.equals(ExpectFirstName) && actuallyLastName.equals(ExpectLastName) && actuallyID.equals(ExpectID);
    }
}
