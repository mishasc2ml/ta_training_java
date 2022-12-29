package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetUp {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public void driverSetUp() {
        webDriver = new ChromeDriver();
        System.setProperty("web-driver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }
}
