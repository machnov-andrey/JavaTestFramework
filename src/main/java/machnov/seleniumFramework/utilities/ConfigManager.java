package machnov.seleniumFramework.utilities;

import machnov.seleniumFramework.enums.BrowserType;

import java.io.FileReader;
import java.util.Arrays;

public final class ConfigManager {

    private static ConfigManagerModel config;

    static {
        try {
            config = GsonReader.getGson().fromJson(new FileReader("config.json"), ConfigManagerModel.class);
        } catch (Exception ex) {
            Logger.printFatal(Arrays.toString(ex.getStackTrace()));
        }
    }

    public static BrowserType getBrowserType() {
        return config.browserType;
    }

    public static String getUrl() {
        return config.url;
    }

    public static String getBrowserLanguage() {
        return config.browserLanguage;
    }

    public static String getCity() {
        return config.city;
    }

    private class ConfigManagerModel {
        public BrowserType browserType;
        public String browserLanguage;
        public String url;
        public String city;
    }
}
