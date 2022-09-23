package machnov.seleniumFramework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class Browser {

    public static void goToUrl(String url) {
        FactoryDriver.getDriver().navigate().to(url);
    }

    public static void maximize() {
        FactoryDriver.getDriver().manage().window().maximize();
    }

    public static void quit() {
        FactoryDriver.getDriver().quit();
        FactoryDriver.setDriverNull();
    }

    public static void goToLastTab() {
        List<String> windowsHandles = FactoryDriver.getDriver().getWindowHandles().stream().toList();
        FactoryDriver.getDriver().switchTo().window(windowsHandles.get(windowsHandles.size() - 1));
    }

    public static WebElement findElement(By locator) {
        return FactoryDriver.getDriver().findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return FactoryDriver.getDriver().findElements(locator);
    }

    public static boolean waitForDisplayed(By locator) {
        return new WebDriverWait(FactoryDriver.getDriver(), Duration.ofSeconds(10))
                .until(driver -> driver.findElement(locator)).isDisplayed();
    }

    public static void switchToFrame(By locator) {
        FactoryDriver.getDriver().switchTo().frame(findElement(locator));
    }

    public static void switchToDefaultContent() {
        FactoryDriver.getDriver().switchTo().defaultContent();
    }
}
