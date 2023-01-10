package framework.test;

import framework.model.Calculator;
import framework.page.cloudcalculator.EstimatePage;
import framework.page.cloudcalculator.CloudGoogleHomePage;
import framework.service.CalculatorCreator;
import framework.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorPageTest extends CommonConditions {

    Calculator calculator;

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

    @Test
    public void actualAndExpectedCalculatorComponentsTest() {
        EstimatePage estimatePage = getEstimatePageWithProperty();

        Assert.assertEquals(estimatePage.getRegion(), calculator.getLocationOfDataCenter());
        Assert.assertEquals(estimatePage.getCommitmentTerm(), calculator.getCommitedUsage());
        Assert.assertEquals(estimatePage.getProvisioningModel(), calculator.getProvisioningModel());
        Assert.assertEquals(estimatePage.getMachineType(), calculator.getMachineType());
        Assert.assertTrue(calculator.getOperatingSystem().contains(estimatePage.getOperatingSystem()));
        Assert.assertTrue(calculator.getCapacityOfLocalSSD().contains(estimatePage.getLocalSSDCapacity()));
        Assert.assertEquals(estimatePage.getTotalEstimate(), TestDataReader.getTestData("calculator.expectedTotalEstimate"));
    }
}
