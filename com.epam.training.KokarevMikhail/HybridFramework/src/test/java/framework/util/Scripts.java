package framework.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scripts {
    public static void moveToElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
