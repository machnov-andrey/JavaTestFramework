package machnov.dzenTestProject.autoTests;

import machnov.dzenTestProject.pageObject.DzenSearchingPage;
import machnov.dzenTestProject.pageObject.StartDzenPage;
import machnov.seleniumFramework.utilities.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DzenSearchTest extends BaseTest {

    private static final String FIND = "java";
    private static final String EXPECTED = "java.com";

    @Test
    public void SearchTest() {
        StartDzenPage startDzenPage = new StartDzenPage();
        Assert.assertTrue(startDzenPage.isOpened(), "Начальная страница Дзена не открылась");

        startDzenPage.switchToFrameSearchBox();
        startDzenPage.sendTextInSearchBox(FIND);
        startDzenPage.startSearch();
        startDzenPage.switchToDefaultContent();

        Browser.goToLastTab();
        DzenSearchingPage dzenSearchingPage = new DzenSearchingPage();
        Assert.assertTrue(dzenSearchingPage.isOpened(), "Страница с результатами поиска не открылась");

        String firstSite = dzenSearchingPage.getSiteOfFirstResult();
        Assert.assertEquals(firstSite, EXPECTED, "Первый сайт не соответствует ожидаемому");
    }
}
