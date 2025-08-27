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
    public static String capturescreenshot(WebDriver driver,String namePrefix){
        if(!(driver instanceof TakesScreenshot)){
            System.out.println("Driver không hỡ trợ");
        }
        File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp=new SimpleDateFormat("yyyyMMĐ_HHmmss").format(new Date());
        File destDir= new File("report/screenshots");
        File destFile=new File(destDir,namePrefix+ "_"+timeStamp+".png");
        try{
            Files.createDirectories(destDir.toPath());
            Files.copy(scrFile.toPath(),destFile.toPath());
            System.out.println("Đã chụp màn hình");
            return "screenshots"+destFile.getName();
        }
        catch (IOException e){
            System.out.println("lỗi lưu ảnh");
            return null;
        }
    }
}
