package framework.page.yopmail;

import framework.page.cloudcalculator.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InboxPage extends AbstractPage {

    By mailFrame = By.id("ifmail");
    By amountOfReceivedEmailsElement = By.id("nbmail");
    By refreshBtn = By.id("refresh");
    By totalEstimatedMonthlyCost = By.xpath("//h3[contains (text(), 'Total Estimated Monthly Cost')]/parent::td/following-sibling::td/h3");
    private final String inboxPageWindowID;

    public InboxPage(WebDriver driver) {
        super(driver);
        inboxPageWindowID = driver.getWindowHandle();
    }

    public boolean isEmailReceived() {
        try {
            getElement(refreshBtn, driver).click();
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.textToBePresentInElementLocated(amountOfReceivedEmailsElement, "1 mail"));
            logger.info("New email has been received");
        } catch (Exception e) {
            isEmailReceived();
        }
        return true;
    }

    public String getMailMonthlyCostValue() {
        switchFrame(mailFrame, driver);
        return getElement(totalEstimatedMonthlyCost, driver).getText();
    }

    public String getInboxPageWindowId() {
        return inboxPageWindowID;
    }
}
