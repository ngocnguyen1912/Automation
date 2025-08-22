package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.AddEmployee;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    public static void capturescreenshot(WebDriver driver,String namePrefix){
        if(!(driver instanceof TakesScreenshot)){
            System.out.println("Driver không hỡ trợ");
        }
        File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp=new SimpleDateFormat("yyyyMMĐ_HHmmss").format(new Date());
        File destFile=new File("screenshot/"+namePrefix+ "_"+timeStamp+".png");
        try{
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(scrFile.toPath(),destFile.toPath());
            System.out.println("Đã chụp màn hình");
        }
        catch (IOException e){
            System.out.println("lỗi lưu ảnh");
        }
    }
}
