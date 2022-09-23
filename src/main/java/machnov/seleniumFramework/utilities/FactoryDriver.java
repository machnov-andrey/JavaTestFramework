package machnov.seleniumFramework.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import machnov.seleniumFramework.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

final class FactoryDriver {

    private static WebDriver driver;
    private static BrowserType browserType;

    static {
        browserType = ConfigManager.getBrowserType();
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            return driver = switch (browserType) {
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    yield new EdgeDriver();
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    yield new FirefoxDriver();
                default:
                    WebDriverManager.chromedriver().setup();
                    yield new ChromeDriver();
            };
        }
    }

    public static void setDriverNull() {
        driver = null;
    }
}
