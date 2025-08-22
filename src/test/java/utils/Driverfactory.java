package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driverfactory {
    public  static WebDriver getDriver(String browser){
        WebDriver driver;
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("không hỗ trọ");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
