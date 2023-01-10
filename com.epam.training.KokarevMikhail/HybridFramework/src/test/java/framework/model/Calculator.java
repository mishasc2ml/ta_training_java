package framework.model;

public class Calculator {

    private  String numberOfInstances;
    private  String operatingSystem;
    private  String provisioningModel;
    private  String machineFamily;
    private  String series;
    private  String machineType;
    private  String numberOfGPU;
    private  String typeOfGPU;
    private  String capacityOfLocalSSD;
    private  String locationOfDataCenter;
    private  String commitedUsage;

    public Calculator(String numberOfInstances, String operatingSystem, String provisioningModel, String machineFamily,
                      String series, String machineType, String numberOfGPU, String typeOfGPU, String capacityOfLocalSSD,
                      String locationOfDataCenter, String commitedUsage) {

        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.numberOfGPU = numberOfGPU;
        this.typeOfGPU = typeOfGPU;
        this.capacityOfLocalSSD = capacityOfLocalSSD;
        this.locationOfDataCenter = locationOfDataCenter;
        this.commitedUsage = commitedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }

    public String getCapacityOfLocalSSD() {
        return capacityOfLocalSSD;
    }

    public void setCapacityOfLocalSSD(String capacityOfLocalSSD) {
        this.capacityOfLocalSSD = capacityOfLocalSSD;
    }

    public String getLocationOfDataCenter() {
        return locationOfDataCenter;
    }

    public void setLocationOfDataCenter(String locationOfDataCenter) {
        this.locationOfDataCenter = locationOfDataCenter;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }
}

