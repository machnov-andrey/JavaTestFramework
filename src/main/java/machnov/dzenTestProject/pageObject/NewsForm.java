package machnov.dzenTestProject.pageObject;

import machnov.seleniumFramework.core.BaseElement;
import machnov.seleniumFramework.core.Button;
import machnov.seleniumFramework.utilities.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NewsForm extends BaseElement {

    private final int NEWS_PER_PAGE = 5;
    private final Button SWITCH_TO_LOCAL_NEWS = new Button(By.xpath(
            String.format("//div[contains(text(),'%s') and contains(@class,'news')]", ConfigManager.getCity())),
            "Кнопка для локальных новостей");

    public NewsForm() {
        super(By.id("zen-row-0"), "Новости");
    }

    private ArrayList<String> getNews() {
        List<WebElement> listNews = findElement().findElements(By.className("news-story__text-2H"));
        ArrayList<String> listNewsString = new ArrayList<String>();

        for (WebElement textLabel : listNews) {
            listNewsString.add(textLabel.getText());
        }

        return listNewsString;
    }

    public List<String> getWorldNews() {
        return getNews().stream().limit(NEWS_PER_PAGE).toList();
    }

    public List<String> getLocalNews() {
        return getNews().stream().skip(NEWS_PER_PAGE).toList();
    }

    public void switchToLocalNews() {
        SWITCH_TO_LOCAL_NEWS.click();
    }
}
