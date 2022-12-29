package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YandexLogin extends WebDriverSetUp {
    private final By loginPageBtn = By.xpath("//button[@class='Button2 Button2_size_m Button2_view_orange Button2_weight_500 Button_3bxRfn2dtuSMoNjFiugM29 PSHeader-NoLoginButton']");
    private final By yandexLoginField = By.xpath("//input[@data-t='field:input-login']");
    private final By yandexPasswordField = By.xpath("//input[@data-t='field:input-passwd']");
    private final By switchToEmailLoginBtn = By.xpath("//button[@data-t='button:clear']");
    private final By yandexProfileIcon = By.xpath("//div[@class='user-pic user-pic_has-plus_ user-account__pic']");
    private final By loginToggleFlag = By.xpath("//input[@data-t='field:input-phone']");
    private final By incorrectEmailFlag = By.xpath("//div[@class='Textinput-Hint Textinput-Hint_state_error']");

    public boolean yandexLogin(String username, String password) {
        if (username.isEmpty()) {
            return false;
        }
        driverSetUp();
        webDriver.get("https://mail.yandex.by/");
        wait.until(ExpectedConditions.elementToBeClickable(loginPageBtn));
        webDriver.findElement(loginPageBtn).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(loginToggleFlag));
            webDriver.findElement(switchToEmailLoginBtn).click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(yandexLoginField));
            webDriver.findElement(yandexLoginField).sendKeys(username, Keys.ENTER);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(incorrectEmailFlag));
            wait.until(ExpectedConditions.elementToBeClickable(yandexPasswordField));
            webDriver.findElement(yandexPasswordField).sendKeys(password, Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(yandexProfileIcon));
            return true;
        } catch (TimeoutException e) {
            webDriver.quit();
            return false;
        }
    }
}
