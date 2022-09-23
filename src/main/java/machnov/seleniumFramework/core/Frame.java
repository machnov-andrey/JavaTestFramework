package machnov.seleniumFramework.core;

import machnov.seleniumFramework.utilities.Browser;
import machnov.seleniumFramework.utilities.Logger;
import org.openqa.selenium.By;

public class Frame extends BaseElement {

    public Frame(By locator, String name) {
        super(locator, name);
    }

    public void switchToFrame() {
        Logger.printInfo(String.format("Переключаемся на фрейм '%s'", name));
        Browser.switchToFrame(locator);
    }

    public void switchToDefault() {
        Logger.printInfo(String.format("Переключаемся с фрейма '%s' на дефолтный контент", name));
        Browser.switchToDefaultContent();
    }
}
