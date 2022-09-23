package machnov.dzenTestProject.pageObject;

import machnov.seleniumFramework.core.BaseElement;

public abstract class BasePage {

    private final BaseElement checkedElement;
    private final String name;

    public BasePage(BaseElement checkedElement, String name) {
        this.checkedElement = checkedElement;
        this.name = name;
    }

    public boolean isOpened() {
        return checkedElement.waitForDisplayed();
    }

    public String getNamePage() {
        return name;
    }
}
