package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReceiveEmailService {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final By amountOfUnreadEmails = By.xpath("//div[@class='nav__folder-badge']/span");
    private final By unreadEmailField = By.xpath("//span[@class='ll-sp__normal']");
    private final By senderInfoBtn = By.xpath("//span[@class='letter-contact']");
    private final By emailSenderField = By.xpath("//div[@class='list-item__email']");
    private final By textField = By.xpath("//div[@class='html-expander']/div/div/div/div/div");

    public void login() {
        Login mailLogin = new Login();
        mailLogin.mailLogin(ConfProperties.getProperty("mail-login"), ConfProperties.getProperty("mail-password"));
        webDriver = mailLogin.getWebDriver();
        wait = mailLogin.getWebDriverWait();
    }

    public boolean hasEmailArrived() {
        try {
            wait = new WebDriverWait(webDriver, Duration.ofMinutes(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(amountOfUnreadEmails));
            return (Integer.parseInt(webDriver.findElement(amountOfUnreadEmails).getText()) == 1);
        } catch (TimeoutException e) {
            webDriver.quit();
            return false;
        } finally {
            webDriver.quit();
        }
    }

    public String getSender() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(unreadEmailField));
            webDriver.findElement(unreadEmailField).click();
            wait.until(ExpectedConditions.elementToBeClickable(senderInfoBtn));
            webDriver.findElement(senderInfoBtn).click();
            return webDriver.findElement(emailSenderField).getText();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }
        return null;
    }

    public String getMessageContent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(unreadEmailField));
            webDriver.findElement(unreadEmailField).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(textField));
            return webDriver.findElement(textField).getText();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }
        return null;
    }
}
