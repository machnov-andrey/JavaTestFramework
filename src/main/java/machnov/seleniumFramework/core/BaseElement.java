package machnov.seleniumFramework.core;

import machnov.seleniumFramework.utilities.Browser;
import machnov.seleniumFramework.utilities.JavaScripts;
import machnov.seleniumFramework.utilities.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public abstract class BaseElement {

    protected By locator;
    protected String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public String getName() {
        Logger.printInfo("Получаем имя элемента");
        return name;
    }

    protected WebElement findElement() {
        Logger.printInfo(String.format("Ищем элемент по локатору '%s'", locator));
        try {
            return Browser.findElement(locator);
        } catch (NotFoundException ex) {
            Logger.printError(String.format("Элемент '%s' не найден", name));
            Logger.printError(Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public boolean waitForDisplayed() {
        Logger.printInfo(String.format("Ожидаем появление '%s' в течении 10 секунд", name));
        return Browser.waitForDisplayed(locator);
    }

    protected List<WebElement> findElements() {
        Logger.printInfo(String.format("Ищем элементы по локатору '%s'", locator));
        return Browser.findElements(locator);
    }

    public boolean isDisplayed() {
        Logger.printInfo(String.format("Проверяем видимость элемента '%s'", name));
        return findElement().isDisplayed();
    }

    public void highLight() {
        Logger.printInfo(String.format("Подсвечиваем '%s'", name));
        JavaScripts.highlightElement(findElement());
    }
}
