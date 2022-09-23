package machnov.dzenTestProject.pageObject;

import machnov.seleniumFramework.core.Button;
import machnov.seleniumFramework.core.Frame;
import machnov.seleniumFramework.core.TextBox;
import machnov.seleniumFramework.core.TextLabel;
import org.openqa.selenium.By;

public class StartDzenPage extends BasePage {

    private final TextLabel GEOLOCATION_LABEL = new TextLabel(By.className("geoblock-weather__region-3Y"), "Геолокация");
    private final Button SEARCH_BUTTON = new Button(By.className("arrow__button"), "Кнопка поиска");
    private final TextBox SEARCH_BOX = new TextBox(By.xpath("//input[contains(@class,'arrow__input')]"), "Поисковая строка");
    private final Frame FRAME_SEARCH_BOX = new Frame(By.xpath("//iframe[contains(@class,'dzen')]"), "Фрейм для поисковой строки");
    public final NewsForm NEWS_FORM = new NewsForm();

    public StartDzenPage() {
        super(new TextLabel(By.xpath("//div[contains(text(),'Сейчас в СМИ')]"), "Сейчас в СМИ"),
                "Начальная страница");
    }

    public void sendTextInSearchBox(String text) {
        SEARCH_BOX.sendKeys(text);
    }

    public void startSearch() {
        SEARCH_BUTTON.click();
    }

    public String getGeoLocation() {
        GEOLOCATION_LABEL.highLight();
        return GEOLOCATION_LABEL.getText();
    }

    public void switchToFrameSearchBox() {
        FRAME_SEARCH_BOX.switchToFrame();
    }

    public void switchToDefaultContent() {
        FRAME_SEARCH_BOX.switchToDefault();
    }
}
