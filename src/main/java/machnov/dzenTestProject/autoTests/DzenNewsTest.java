package machnov.dzenTestProject.autoTests;

import machnov.dzenTestProject.pageObject.StartDzenPage;
import machnov.seleniumFramework.utilities.Logger;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DzenNewsTest extends BaseTest {

    @Test
    public void TestNews() {
        StartDzenPage startDzenPage = new StartDzenPage();

        Assert.assertTrue(startDzenPage.isOpened(), "Начальная страница не открылась");

        List<String> worldNews = startDzenPage.NEWS_FORM.getWorldNews();
        worldNews.forEach(news -> Assert.assertFalse(StringUtils.isEmpty(news.trim()), "Новость пустая"));
        worldNews.forEach(Logger::printInfo);

        startDzenPage.NEWS_FORM.switchToLocalNews();

        List<String> localNews = startDzenPage.NEWS_FORM.getLocalNews();
        localNews.forEach(news -> Assert.assertFalse(StringUtils.isEmpty(news.trim()), "Новость пустая"));
        Assert.assertEquals(localNews.size(), 5);
        localNews.forEach(Logger::printInfo);
    }
}
