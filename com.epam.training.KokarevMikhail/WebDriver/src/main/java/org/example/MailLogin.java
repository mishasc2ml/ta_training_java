package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailLogin extends WebDriverSetUp {
    private final By mailLoginField = By.xpath("//input[@name='username']");
    private final By mailPasswordField = By.xpath("//input[@name='password']");
    private final By mailProfilePageIcon = By.xpath("//span[@class='ph-project__user-name svelte-1hiqrvn']");

    public boolean mailLogin(String username, String password) {
        if (username.isEmpty()) {
            return false;
        }
        driverSetUp();
        webDriver.get("https://account.mail.ru/login");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mailLoginField));
            webDriver.findElement(mailLoginField).sendKeys(username, Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(mailPasswordField));
            webDriver.findElement(mailPasswordField).sendKeys(password, Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(mailProfilePageIcon));
            return true;
        } catch (TimeoutException e) {
            webDriver.quit();
            return false;
        }
    }

}
