package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendReceiveTests {
    @Test
    public void sentEmailTest() {
        SendEmail sendEmail = new SendEmail();
        Assert.assertTrue(sendEmail.sendEmail("seleniumtest123@mail.ru", "Subject"));
    }

    @Test(priority = 1)
    public void emailHasArrivedTest() {
        ReceiveEmail receiveEmail = new ReceiveEmail();
        Assert.assertTrue(receiveEmail.emailArrivalCheck());
    }

    @Test(priority = 2)
    public void senderTest() {
        ReceiveEmail receiveEmail = new ReceiveEmail();
        Assert.assertEquals("seleniumtest1234567@yandex.ru", receiveEmail.getSender());
    }

    @Test(priority = 3)
    public void textContentTest() {
        ReceiveEmail receiveEmail = new ReceiveEmail();
        Assert.assertEquals(receiveEmail.getMessageContent(), SendEmail.messageContent);
    }
}
