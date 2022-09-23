package machnov.seleniumFramework.core;

import machnov.seleniumFramework.utilities.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

public class Button extends BaseElement {

    public Button(By locator, String name) {
        super(locator, name);
    }

    public void click() {
        try {
            Logger.printInfo(String.format("Кликаем по элементу '%s'", name));
            findElement().click();
        } catch (ElementClickInterceptedException ex) {
            Logger.printError(String.format("Не удалось кликнуть по элементу '%s'", name));
        }
    }
}
