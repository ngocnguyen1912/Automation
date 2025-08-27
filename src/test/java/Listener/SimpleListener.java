package Listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import script.BaseTest;
import utils.Screenshot;

public class SimpleListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🔹 Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());

        // Lấy driver từ BaseTest
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;

        // Gọi util để chụp screenshot
        String testName = result.getName();
        String screenshotPath = Screenshot.capturescreenshot(driver, testName);
        System.out.println("📸 Screenshot saved to: " + screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭ Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== START SUITE: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== FINISH SUITE: " + context.getName() + " ===");
    }
}
