package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void testMailCorrectLogin() {
        Login mailCorrectLogin = new Login();
        mailCorrectLogin.mailLogin(ConfProperties.getProperty("mail-login"), ConfProperties.getProperty("mail-password"));
        Assert.assertTrue(mailCorrectLogin.isSuccessfulMailLogin());
    }

    @Test
    public void testMailIncorrectLogins() {
        Login incorrectMailLogin = new Login();
        Login incorrectMailPassword = new Login();
        Login emptyMailLogin = new Login();
        Login emptyMailPassword = new Login();

        incorrectMailLogin.mailLogin("seleniumtest1234@mail.ru", "Ytrewq9191");
        Assert.assertFalse(incorrectMailLogin.isSuccessfulMailLogin());

        incorrectMailPassword.mailLogin("seleniumtest123@mail.ru", "Ytrewq919191");
        Assert.assertFalse(incorrectMailPassword.isSuccessfulMailLogin());

        emptyMailLogin.mailLogin("", "Ytrewq9191");
        Assert.assertFalse(emptyMailLogin.isSuccessfulMailLogin());

        emptyMailPassword.mailLogin("seleniumtest1234@mail.ru", "");
        Assert.assertFalse(emptyMailPassword.isSuccessfulMailLogin());

    }

    @Test
    public void testYandexCorrectLogin() {
        Login yandexCorrectLogin = new Login();
        yandexCorrectLogin.yandexLogin(ConfProperties.getProperty("yandex-login"), ConfProperties.getProperty("yandex-password"));
        Assert.assertTrue(yandexCorrectLogin.isSuccessfulYandexLogin());
    }

    @Test
    public void testYandexIncorrectLogins() {
        Login incorrectYandexLogin = new Login();
        Login incorrectYandexPassword = new Login();
        Login emptyYandexLogin = new Login();
        Login emptyYandexPassword = new Login();

        incorrectYandexLogin.yandexLogin("seleniumtest12345672121@yandex.ru", "Ytrewq9191");
        Assert.assertFalse(incorrectYandexLogin.isSuccessfulYandexLogin());

        incorrectYandexPassword.yandexLogin("seleniumtest1234567@yandex.ru", "Ytrewq919191");
        Assert.assertFalse(incorrectYandexPassword.isSuccessfulYandexLogin());

        emptyYandexLogin.yandexLogin("", "Ytrewq9191");
        Assert.assertFalse(emptyYandexLogin.isSuccessfulYandexLogin());

        emptyYandexPassword.yandexLogin("seleniumtest1234567@yandex.ru", "");
        Assert.assertFalse(emptyYandexPassword.isSuccessfulYandexLogin());

    }
}
