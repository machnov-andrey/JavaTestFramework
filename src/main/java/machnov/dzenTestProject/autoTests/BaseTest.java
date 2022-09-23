package machnov.dzenTestProject.autoTests;

import machnov.seleniumFramework.utilities.Browser;
import machnov.seleniumFramework.utilities.ConfigManager;
import machnov.seleniumFramework.utilities.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        Logger.printInfo("Начинаем тест");
        Browser.goToUrl(ConfigManager.getUrl());
        Browser.maximize();
    }

    @AfterMethod
    public void tearDown() {
        Logger.printInfo("Завершаем тест");
        Logger.closeFile();
        Browser.quit();
    }
}
