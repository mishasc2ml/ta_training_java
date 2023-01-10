package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailService {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final By createNewEMailBtn = By.xpath("//div[@class='mail-Layout-Aside-Background']/following-sibling::div/div/div/div/a");
    private final By recipientEmailField = By.xpath("//div[@class='composeYabbles']");
    private final By subjectField = By.xpath("//div[@class='ComposeSubject']/div/label/following-sibling::div/input");
    private final By textField = By.xpath("//div[@title='Напишите что-нибудь']/div");
    private final By sendEmailBtn = By.xpath("//div[@class='ComposeControlPanel-Part']/div/button");
    private final By sentEmailWindow = By.xpath("//div[@class='ComposeDoneScreen-Title']");

    public void login() {
        Login yandexLogin = new Login();
        yandexLogin.yandexLogin(ConfProperties.getProperty("yandex-login"), ConfProperties.getProperty("yandex-password"));
        webDriver = yandexLogin.getWebDriver();
        wait = yandexLogin.getWebDriverWait();
    }

    public void sendEmail(String recipient, String subject, String textContent) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createNewEMailBtn));
        webDriver.findElement(createNewEMailBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(recipientEmailField));
        webDriver.findElement(recipientEmailField).sendKeys(recipient);
        webDriver.findElement(subjectField).sendKeys(subject);
        webDriver.findElement(textField).sendKeys((textContent));
        webDriver.findElement(sendEmailBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sentEmailWindow));
        webDriver.findElement(sentEmailWindow).click();
        webDriver.quit();
    }
}