package machnov.dzenTestProject.autoTests;

import machnov.dzenTestProject.pageObject.StartDzenPage;
import machnov.dzenTestProject.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DzenGeolocationTest extends BaseTest {

    @Test(dataProvider = "geolocation", dataProviderClass = TestData.class)
    public void TestCity(String city) {
        StartDzenPage startDzenPage = new StartDzenPage();
        Assert.assertTrue(startDzenPage.isOpened());
        Assert.assertEquals(startDzenPage.getGeoLocation().trim(), city, "Геолокация не равна ожидаемой");
    }
}
