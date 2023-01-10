package framework.page.cloudcalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends AbstractPage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openCalculatorPage() {
        getElement(By.linkText(searchingText), driver).click();
        logger.info("Calculator page has been opened");
        return new CalculatorPage(driver);
    }
}
