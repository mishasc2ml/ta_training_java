package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendReceiveTests {
    @Test
    public void testHasEmailArrived() {
        SendEmailService sendEmail = new SendEmailService();
        ReceiveEmailService receiveEmail = new ReceiveEmailService();
        sendEmail.login();
        sendEmail.sendEmail(ConfProperties.getProperty("recipient-email-address"), ConfProperties.getProperty("email-subject"),
                ConfProperties.getProperty("email-text-content"));
        receiveEmail.login();
        Assert.assertTrue(receiveEmail.hasEmailArrived());
    }

    @Test(priority = 1)
    public void testSenderEqual() {
        ReceiveEmailService receiveEmail = new ReceiveEmailService();
        receiveEmail.login();
        Assert.assertEquals(receiveEmail.getSender(), ConfProperties.getProperty("yandex-login"));
    }

    @Test(priority = 2)
    public void testContentEqual() {
        ReceiveEmailService receiveEmail = new ReceiveEmailService();
        receiveEmail.login();
        Assert.assertEquals(receiveEmail.getMessageContent(), ConfProperties.getProperty("email-text-content"));
    }
}
