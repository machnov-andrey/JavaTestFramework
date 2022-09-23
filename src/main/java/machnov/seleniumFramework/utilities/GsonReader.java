package machnov.seleniumFramework.utilities;

import com.google.gson.Gson;

public class GsonReader {

    private static Gson gson;

    public static Gson getGson() {
        return (gson == null) ? gson = new Gson() : gson;
    }
}
