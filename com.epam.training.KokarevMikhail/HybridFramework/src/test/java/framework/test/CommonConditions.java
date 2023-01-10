package framework.test;

import framework.driver.DriverSingleton;
import framework.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getWebDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}

