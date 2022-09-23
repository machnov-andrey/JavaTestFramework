package machnov.seleniumFramework.core;

import machnov.seleniumFramework.utilities.Logger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String text) {
        Logger.printInfo(String.format("Отправляем '%s' в элемент '%s'", text, name));
        findElement().sendKeys(text);
    }

    public void clear() {
        Logger.printInfo(String.format("Очищаем текст в элементе '%s'", name));
        findElement().clear();
    }
}
