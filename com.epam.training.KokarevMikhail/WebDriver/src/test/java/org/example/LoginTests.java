package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void testMailCorrectLogin() {
        MailLogin correctLogin = new MailLogin();
        Assert.assertTrue(correctLogin.mailLogin("seleniumtest123@mail.ru", "Ytrewq9191"));
        correctLogin.webDriver.quit();
    }

    @Test
    public void testMailIncorrectLogins() {
        MailLogin incorrectLogin = new MailLogin();
        MailLogin incorrectPassword = new MailLogin();
        MailLogin emptyLogin = new MailLogin();
        MailLogin emptyPassword = new MailLogin();
        Assert.assertFalse(incorrectLogin.mailLogin("seleniumtest1234@mail.ru", "Ytrewq9191"));
        Assert.assertFalse(incorrectPassword.mailLogin("seleniumtest123@mail.ru", "Ytrewq919191"));
        Assert.assertFalse(emptyLogin.mailLogin("", "Ytrewq9191"));
        Assert.assertFalse(emptyPassword.mailLogin("seleniumtest1234@mail.ru", ""));
    }

    @Test
    public void testYandexCorrectLogin() {
        YandexLogin correctLogin = new YandexLogin();
        Assert.assertTrue(correctLogin.yandexLogin("seleniumtest1234567@yandex.ru", "Ytrewq9191"));
        correctLogin.webDriver.quit();
    }

    @Test
    public void testYandexIncorrectLogins() {
        YandexLogin incorrectLogin = new YandexLogin();
        YandexLogin incorrectPassword = new YandexLogin();
        YandexLogin emptyLogin = new YandexLogin();
        YandexLogin emptyPassword = new YandexLogin();
        Assert.assertFalse(incorrectLogin.yandexLogin("seleniumtest12345672121@yandex.ru", "Ytrewq9191"));
        Assert.assertFalse(incorrectPassword.yandexLogin("seleniumtest1234567@yandex.ru", "Ytrewq919191"));
        Assert.assertFalse(emptyLogin.yandexLogin("", "Ytrewq9191"));
        Assert.assertFalse(emptyPassword.yandexLogin("seleniumtest1234567@yandex.ru", ""));
    }
}
