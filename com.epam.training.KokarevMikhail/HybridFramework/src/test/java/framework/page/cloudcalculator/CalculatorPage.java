package framework.page.cloudcalculator;

import framework.model.Calculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage extends AbstractPage {

    static By iFrameOuter = By.xpath("//article[@id='cloud-site']//iframe");
    static By iFrame = By.id("myFrame");
    By computeEngineSelectionElement = By.xpath("//div[@title='Compute Engine']");
    By numberOfInstancesInputField = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Number of instances')]/following-sibling::input");
    By operatingSystemSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Operating System / Software')]/following-sibling::md-select");
    By provisioningModelSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Provisioning model')]/following-sibling::md-select");
    By machineFamilySelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Machine Family')]/following-sibling::md-select");
    By seriesSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Series')]/following-sibling::md-select");
    By machineTypeSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Machine type')]/following-sibling::md-select");
    By addGPUCheckBoxElement = By.xpath("//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']");
    By GPUTypeSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'GPU type')]/following-sibling::md-select");
    By numberOfGPUSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Number of GPUs')]/following-sibling::md-select");
    By localSSDSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Local SSD')]/following-sibling::md-select");
    By dataCenterLocationSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Datacenter location')]/following-sibling::md-select");
    By committedUsageSelectionElement = By.xpath("//form[@name='ComputeEngineForm']//label[contains(text(), 'Committed usage')]/following-sibling::md-select");
    By addToEstimateBtn = By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']");
    private final String emptyVariantSelectionByValueXpath = "//div[contains(@class, 'md-active') and contains(@class, 'md-clickable')]//md-option//div[contains(text(), '%s')]";

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private By formattedVariantSelectionByValueXpath(String value) {
        return By.xpath(String.format(emptyVariantSelectionByValueXpath, value));
    }

    public CalculatorPage activateComputeEngineSelectionElement() {
        switchFrame(iFrameOuter, driver);
        switchFrame(iFrame, driver);
        getElement(computeEngineSelectionElement, driver).click();
        logger.info("Compute engine section has been chosen");
        return this;
    }

    public CalculatorPage numberOfInstancesInput(Calculator calculator) {
        getElement(numberOfInstancesInputField, driver).sendKeys(calculator.getNumberOfInstances());
        logger.info("Number of instances has been entered");
        return this;
    }

    public CalculatorPage operatingSystemSelection(Calculator calculator) {
        getElement(operatingSystemSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getOperatingSystem()), driver).click();
        logger.info("Operating system variant has been chosen");
        return this;
    }

    public CalculatorPage provisioningModelSelection(Calculator calculator) {
        getElement(provisioningModelSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getProvisioningModel()), driver).click();
        logger.info("Provisioning model variant has been chosen");
        return this;
    }

    public CalculatorPage machineFamilySelection(Calculator calculator) {
        getElement(machineFamilySelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getMachineFamily()), driver).click();
        logger.info("Machine family variant has been chosen");
        return this;
    }

    public CalculatorPage seriesSelection(Calculator calculator) {
        getElement(seriesSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getSeries()), driver).click();
        logger.info("Series variant has been chosen");
        return this;
    }

    public CalculatorPage machineTypeSelection(Calculator calculator) {
        getElement(machineTypeSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getMachineType()), driver).click();
        logger.info("Machine type variant has been chosen");
        return this;
    }

    public CalculatorPage GPUTypeSelection(Calculator calculator) {
        getElement(addGPUCheckBoxElement, driver).click();
        getElement(GPUTypeSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getTypeOfGPU()), driver).click();
        logger.info("GPU type variant has been chosen");
        return this;
    }

    public CalculatorPage numberOfGPUSelection(Calculator calculator) {
        getElement(numberOfGPUSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getNumberOfGPU()), driver).click();
        logger.info("Number of GPUs variant has been chosen");
        return this;
    }

    public CalculatorPage localSSDCapacitySelection(Calculator calculator) {
        getElement(localSSDSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getCapacityOfLocalSSD()), driver).click();
        logger.info("Local SSD capacity variant has been chosen");
        return this;
    }

    public CalculatorPage dataCenterLocationSelection(Calculator calculator) {
        getElement(dataCenterLocationSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getLocationOfDataCenter()), driver).click();
        logger.info("Data center location variant has been chosen");
        return this;
    }

    public CalculatorPage committedUsagePeriodSelection(Calculator calculator) {
        getElement(committedUsageSelectionElement, driver).click();
        getElement(formattedVariantSelectionByValueXpath(calculator.getCommitedUsage()), driver).click();
        logger.info("Commited usage period variant has been chosen");
        return this;
    }

    public EstimatePage addToEstimate() {
        getElement(addToEstimateBtn, driver).click();
        logger.info("Got the estimate price window");
        return new EstimatePage(driver);
    }
}
