package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceiveEmail extends WebDriverSetUp {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    private final By amountOfUnreadEmails = By.xpath("//span[@class='badge badge_size_m']/span");
    private final By unreadEmail = By.xpath("//span[@class='ll-sp__normal']");
    private final By senderInfoBtn = By.xpath("//span[@class='letter-contact']");
    private final By senderEmail = By.xpath("//div[@class='list-item__email']");
    private final By textField = By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div/div/div[2]/div[1]/div[4]/div[2]/div/div/div/div/div/div/div/div/div/div/div");


    public ReceiveEmail() {
        MailLogin mailLogin = new MailLogin();
        mailLogin.mailLogin("seleniumtest123@mail.ru", "Ytrewq9191");
        webDriver = mailLogin.getWebDriver();
        wait = mailLogin.getWebDriverWait();
    }

    public boolean emailArrivalCheck() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(amountOfUnreadEmails));
            return (Integer.parseInt(webDriver.findElement(amountOfUnreadEmails).getText()) == 1);
        } catch (TimeoutException e) {
            emailArrivalCheck();
        } finally {
            webDriver.quit();
        }
        return false;
    }

    public String getSender() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(unreadEmail));
            webDriver.findElement(unreadEmail).click();
            wait.until(ExpectedConditions.elementToBeClickable(senderInfoBtn));
            webDriver.findElement(senderInfoBtn).click();
            return webDriver.findElement(senderEmail).getText();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }
        return null;
    }

    public String getMessageContent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(unreadEmail));
            webDriver.findElement(unreadEmail).click();
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
