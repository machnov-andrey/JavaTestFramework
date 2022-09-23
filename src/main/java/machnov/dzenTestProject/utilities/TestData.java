package machnov.dzenTestProject.utilities;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class TestData {

    private static final String PATH_TO_GEOLOCATION = "test_data_geolocation.txt";

    @DataProvider(name = "geolocation")
    public static Object[][] getDataForTestGeolocation() {
        ArrayList<String> testData = new ArrayList<>();
        Object[][] testDataObject;

        try (BufferedReader testDataFile = new BufferedReader(new FileReader(PATH_TO_GEOLOCATION))) {
            testDataFile.lines().forEach(testData::add);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (testData.size() == 0) {
            throw new NoDataTestException("No any test data for geolocation test");
        }
        testDataObject = new Object[testData.size()][];

        for (int i = 0; i < testData.size(); i++) {
            testDataObject[i] = new Object[]{testData.get(i)};
        }

        return testDataObject;
    }
}
