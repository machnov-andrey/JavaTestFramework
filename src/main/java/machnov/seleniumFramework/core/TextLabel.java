package machnov.seleniumFramework.core;

import machnov.seleniumFramework.utilities.Logger;
import org.openqa.selenium.By;

public class TextLabel extends BaseElement {

    public TextLabel(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        Logger.printInfo(String.format("Получаем текстовое содержимое элемента '%s'", name));
        return findElement().getText();
    }
}
