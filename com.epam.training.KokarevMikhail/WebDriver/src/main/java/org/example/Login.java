package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final By mailLoginField = By.xpath("//input[@name='username']");
    private final By mailPasswordField = By.xpath("//input[@name='password']");
    private final By mailProfilePageIcon = By.xpath("//div[@data-testid='whiteline-account']");

    private final By yandexLoginPageBtn = By.xpath("//span[@class='Button2-Text']/parent::button");
    private final By yandexLoginField = By.xpath("//input[@data-t='field:input-login']");
    private final By yandexPasswordField = By.xpath("//input[@data-t='field:input-passwd']");
    private final By yandexSwitchToEmailLoginBtn = By.xpath("//button[@data-t='button:clear']");
    private final By yandexProfileIconField = By.xpath("//span[@class='user-account__name']/parent::a");
    private final By yandexLoginToggleFlag = By.xpath("//input[@data-t='field:input-phone']");

    private void driverSetUp() {
        webDriver = new ChromeDriver();
        System.setProperty("web-driver.chrome.driver", ConfProperties.getProperty("web-driver-path"));
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return this.wait;
    }

    public void mailLogin(String username, String password) {
        try {
            driverSetUp();
            webDriver.get(ConfProperties.getProperty("mail-login-page"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(mailLoginField));
            webDriver.findElement(mailLoginField).sendKeys(username, Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(mailPasswordField));
            webDriver.findElement(mailPasswordField).sendKeys(password, Keys.ENTER);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public boolean isSuccessfulMailLogin() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mailProfilePageIcon));
            webDriver.quit();
            return true;
        } catch (TimeoutException e) {
            webDriver.quit();
            return false;
        }
    }

    public void yandexLogin(String username, String password) {
        driverSetUp();
        webDriver.get(ConfProperties.getProperty("yandex-login-page"));
        wait.until(ExpectedConditions.elementToBeClickable(yandexLoginPageBtn));
        webDriver.findElement(yandexLoginPageBtn).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(yandexLoginToggleFlag));
            webDriver.findElement(yandexSwitchToEmailLoginBtn).click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(yandexLoginField));
            webDriver.findElement(yandexLoginField).sendKeys(username, Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(yandexPasswordField));
            webDriver.findElement(yandexPasswordField).sendKeys(password, Keys.ENTER);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public boolean isSuccessfulYandexLogin() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(yandexProfileIconField));
            webDriver.quit();
            return true;
        } catch (TimeoutException e) {
            webDriver.quit();
            return false;
        }
    }
}
