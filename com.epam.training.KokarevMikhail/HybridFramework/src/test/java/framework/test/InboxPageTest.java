package framework.test;

import framework.model.Calculator;
import framework.page.cloudcalculator.CloudGoogleHomePage;
import framework.page.cloudcalculator.EstimatePage;
import framework.page.yopmail.GeneratorPage;
import framework.page.yopmail.InboxPage;
import framework.page.yopmail.YopmailHomePage;
import framework.service.CalculatorCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InboxPageTest extends CommonConditions {
    Calculator calculator;
    String totalCostEstimatePage;
    String totalCostInboxPage;
    String emailAddress;

    @BeforeMethod
    public void setUpModel() {
        calculator = CalculatorCreator.createWithProperty();
    }

    private EstimatePage getEstimatePageWithProperty() {
        return new CloudGoogleHomePage(driver)
                .openPage()
                .searchForExpression()
                .openCalculatorPage()
                .activateComputeEngineSelectionElement()
                .numberOfInstancesInput(calculator)
                .operatingSystemSelection(calculator)
                .provisioningModelSelection(calculator)
                .machineFamilySelection(calculator)
                .seriesSelection(calculator)
                .machineTypeSelection(calculator)
                .GPUTypeSelection(calculator)
                .numberOfGPUSelection(calculator)
                .localSSDCapacitySelection(calculator)
                .dataCenterLocationSelection(calculator)
                .committedUsagePeriodSelection(calculator)
                .addToEstimate();
    }

    private GeneratorPage generatedEmail() {
        return new YopmailHomePage(driver)
                .openPage()
                .generateEmail();
    }

    @Test
    public void estimatePriceEquityTest() {
        EstimatePage estimatePage = getEstimatePageWithProperty();
        totalCostEstimatePage = estimatePage.getTotalEstimate();
        estimatePage.openEmailEstimateForm();

        emailAddress = generatedEmail().getEmail();

        InboxPage inboxPage = generatedEmail().openInboxPage();

        driver.switchTo().window(estimatePage.getGoogleCloudTabID());

        estimatePage.emailInput(emailAddress).sendEmail();

        driver.switchTo().window(inboxPage.getInboxPageWindowId());

        Assert.assertTrue(inboxPage.isEmailReceived());

        totalCostInboxPage = inboxPage.getMailMonthlyCostValue();

        Assert.assertEquals(totalCostEstimatePage, totalCostInboxPage);
    }
}
