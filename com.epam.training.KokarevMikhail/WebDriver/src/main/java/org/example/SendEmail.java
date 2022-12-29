package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmail extends WebDriverSetUp {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    static final String messageContent = "Message + Content";
    private final By createMailBtn = By.xpath("//a[@class='Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__compose--pTDsx qa-LeftColumn-ComposeButton ComposeButton-m__root--fP-o9']");
    private final By recipientEmail = By.xpath("//div[@class='composeYabbles']");
    private final By theme = By.xpath("//input[@class='composeTextField ComposeSubject-TextField']");
    private final By textField = By.xpath("//div[@title='Напишите что-нибудь']/div");
    private final By sendEmailBtn = By.xpath("//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']");
    private final By sentEmailWindow = By.xpath("//a[@data-lego='react']");

    public SendEmail() {
        YandexLogin yandexLogin = new YandexLogin();
        yandexLogin.yandexLogin("seleniumtest1234567@yandex.ru", "Ytrewq9191");
        webDriver = yandexLogin.getWebDriver();
        wait = yandexLogin.getWebDriverWait();
    }

    public boolean sendEmail(String recipient, String subject) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(createMailBtn));
            webDriver.findElement(createMailBtn).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(recipientEmail));
            webDriver.findElement(recipientEmail).sendKeys(recipient);
            webDriver.findElement(theme).sendKeys(subject);
            webDriver.findElement(textField).sendKeys(messageContent);
            webDriver.findElement(sendEmailBtn).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(sentEmailWindow));
            webDriver.findElement(sentEmailWindow).click();
            webDriver.quit();
            return true;
        } catch (TimeoutException e) {
            webDriver.quit();
            return false;
        }
    }
}