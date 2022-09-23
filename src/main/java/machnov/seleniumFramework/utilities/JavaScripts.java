package machnov.seleniumFramework.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScripts {

    private static final JavascriptExecutor JAVASCRIPT_EXECUTOR;

    static {
        JAVASCRIPT_EXECUTOR = ((JavascriptExecutor) FactoryDriver.getDriver());
    }

    public static void highlightElement(WebElement element) {
        JAVASCRIPT_EXECUTOR.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
