package framework.page.yopmail;

import framework.page.cloudcalculator.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneratorPage extends AbstractPage {

    By generatedEmailField = By.id("egen");
    By openEmailInboxBtn = By.xpath("//button[@onclick='egengo();']");

    public GeneratorPage(WebDriver driver) {
        super(driver);
    }

    public String getEmail() {
        String email = getElement(generatedEmailField, driver).getText();
        logger.info("Saved generated recipient email address");
        return email;
    }

    public InboxPage openInboxPage() {
        getElement(openEmailInboxBtn, driver).click();
        logger.info("Yopmail home page has been opened");
        return new InboxPage(driver);
    }
}
