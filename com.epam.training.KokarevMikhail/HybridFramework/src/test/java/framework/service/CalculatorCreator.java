package framework.service;

import framework.model.Calculator;

public class CalculatorCreator {

    private static final String numberOfInstances = TestDataReader.getTestData("calculator.numberOfInstances");
    private static final String operatingSystem = TestDataReader.getTestData("calculator.operatingSystem");
    private static final String provisioningModel = TestDataReader.getTestData("calculator.provisioningModel");
    private static final String machineFamily = TestDataReader.getTestData("calculator.machineFamily");
    private static final String series = TestDataReader.getTestData("calculator.series");
    private static final String machineType = TestDataReader.getTestData("calculator.machineType");
    private static final String numberOfGPU = TestDataReader.getTestData("calculator.numberOfGPU");
    private static final String typeOfGPU = TestDataReader.getTestData("calculator.typeOfGPU");
    private static final String localSSD = TestDataReader.getTestData("calculator.localSSD");
    private static final String datacenterLocation = TestDataReader.getTestData("calculator.datacenterLocation");
    private static final String commitedUsage = TestDataReader.getTestData("calculator.commitedUsage");


    public static Calculator createWithProperty() {
        return new Calculator(numberOfInstances, operatingSystem, provisioningModel, machineFamily, series,
                machineType, numberOfGPU, typeOfGPU, localSSD, datacenterLocation, commitedUsage);
    }
}
