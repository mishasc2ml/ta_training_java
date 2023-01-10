package framework.page.cloudcalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudGoogleHomePage extends AbstractPage {
    private final String BASE_URL = "https://cloud.google.com/";
    By searchBoxElement = By.xpath("//div[@class='devsite-searchbox']");
    By searchInputField = By.xpath("//div[@class='devsite-searchbox']/input");
    By showAllResultsBtn = By.xpath("//div[@id = 'devsite-search-popout-container-id-1']//button");

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public SearchPage searchForExpression() {
        getElement(searchBoxElement, driver).click();
        getElement(searchInputField, driver).sendKeys(searchingText);
        getElement(showAllResultsBtn, driver).click();
        logger.info("Found the " + searchingText + " expression and showed results page");
        return new SearchPage(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Cloud google home page has been opened");
        return this;
    }
}
