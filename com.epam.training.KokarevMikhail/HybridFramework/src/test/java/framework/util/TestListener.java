package framework.util;

import framework.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    private void saveScreenshot() {
        File scrFile = ((TakesScreenshot) DriverSingleton.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(".//target/screenshots/" + getCurrentTime() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
}
