package framework.page.cloudcalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.util.StringOperations;

public class EstimatePage extends AbstractPage {

    By regionElement = By.xpath("//md-card-content[@id='resultBlock']//div[contains(text(), 'Region')]");
    By commitmentTermElement = By.xpath("//md-card-content[@id='resultBlock']//div[contains(text(), 'Commitment term')]");
    By provisioningModelElement = By.xpath("//md-card-content[@id='resultBlock']//div[contains(text(), 'Provisioning model')]");
    By machineTypeElement = By.xpath("//md-card-content[@id='resultBlock']//div[contains(text(), 'Instance type')]");
    By operatingSystemElement = By.xpath("//md-card-content[@id='resultBlock']//div[contains(text(), 'Operating System / Software')]");
    By localSSDElement = By.xpath("//md-card-content[@id='resultBlock']//div[contains(text(), 'Local SSD')]");
    By totalEstimateElement = By.xpath("//b[contains(text(), 'Total Estimated Cost')]");
    By emailEstimateBtn = By.xpath("//button[@title='Email Estimate']");
    By emailInputField = By.xpath("//input[@type='email']");
    By sendEmailBtn = By.xpath("//button[@aria-label='Send Email']");
    private final String googleCloudTabID;

    public EstimatePage(WebDriver driver) {
        super(driver);
        googleCloudTabID = driver.getWindowHandle();
    }

    public String getRegion() {
        return StringOperations.componentSubstring(getElement(regionElement, driver).getText(), ": ");
    }

    public String getCommitmentTerm() {
        return StringOperations.componentSubstring(getElement(commitmentTermElement, driver).getText(), ": ");
    }

    public String getProvisioningModel() {
        return StringOperations.componentSubstring(getElement(provisioningModelElement, driver).getText(), ": ");
    }

    public String getMachineType() {
        return StringOperations.componentSubstring(getElement(machineTypeElement, driver).getText(), ": ", "\n");
    }

    public String getOperatingSystem() {
        return StringOperations.componentSubstring(getElement(operatingSystemElement, driver).getText(), ": ");
    }

    public String getLocalSSDCapacity() {
        return StringOperations.componentSubstring(getElement(localSSDElement, driver).getText(), ": ", "GiB");
    }

    public String getTotalEstimate() {
        return StringOperations.componentSubstring(getElement(totalEstimateElement, driver).getText(), ": ", " per");
    }

    public EstimatePage openEmailEstimateForm() {
        getElement(emailEstimateBtn, driver).click();
        logger.info("Estimate machine cost form has been opened");
        return this;
    }

    public EstimatePage emailInput(String email) {
        switchFrame(CalculatorPage.iFrameOuter, driver);
        switchFrame(CalculatorPage.iFrame, driver);
        getElement(emailInputField, driver).sendKeys(email);
        logger.info("Recipient email address has been entered");
        return this;
    }

    public EstimatePage sendEmail() {
        getElement(sendEmailBtn, driver).click();
        logger.info("Email has been sent");
        return new EstimatePage(driver);
    }

    public String getGoogleCloudTabID() {
        return googleCloudTabID;
    }

}
