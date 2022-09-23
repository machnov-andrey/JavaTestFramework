package machnov.dzenTestProject.pageObject;

import machnov.seleniumFramework.core.TextLabel;
import org.openqa.selenium.By;

public class DzenSearchingPage extends BasePage {

    private final TextLabel SITE_OF_FIRST_RESULT = new TextLabel(By.xpath("//li[@data-cid=0]//a/b"),
            "Первый результат");

    public DzenSearchingPage() {
        super(new TextLabel(By.xpath("//div[contains(@aria-label,'Страницы')]"), "Строка для переключения страниц"),
                "Страница с результатами поиска");
    }

    public String getSiteOfFirstResult() {
        return SITE_OF_FIRST_RESULT.getText();
    }
}
