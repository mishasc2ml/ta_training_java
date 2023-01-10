package framework.page.yopmail;

import framework.page.cloudcalculator.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class YopmailHomePage extends AbstractPage {

    private final String BASE_URL = "https://yopmail.com/ru/";
    By emailGeneratorBtn = By.xpath("(//a[@href='email-generator'])[2]");

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopmailHomePage openPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(BASE_URL);
        logger.info("Yopmail home page has been opened in a new tab");
        return this;
    }

    public GeneratorPage generateEmail() {
        getElement(emailGeneratorBtn, driver).click();
        logger.info("New recipient email has been generated");
        return new GeneratorPage(driver);
    }

}
