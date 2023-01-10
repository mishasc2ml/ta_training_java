package framework.page.cloudcalculator;

import framework.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected Logger logger = LogManager.getRootLogger();
    protected final long WAIT_TIMEOUT_SECONDS = 10;
    protected final String searchingText = TestDataReader.getTestData("homepage.searchingText");


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementPresent(By by, WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return true;
    }

    protected WebElement getElement(By by, WebDriver driver) {
        if (isElementPresent(by, driver)) {
            return driver.findElement(by);
        } else throw new RuntimeException();
    }

    protected void switchFrame(By by, WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        } catch (NoSuchElementException | TimeoutException e) {
            throw new RuntimeException();
        }
    }
}
