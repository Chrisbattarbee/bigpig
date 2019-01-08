package Settings;

import io.grpc.okhttp.internal.framed.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FuzzerSettings {
    private static FuzzerSettings instance;
    private SettingsHolder values;

    private FuzzerSettings() throws IOException, IllegalAccessException {
        String path = "/settings/local.json";
        try {
            if (System.getenv("BPENV").equals("remote")) {
                path = "/settings/remote.json";
            }
        } catch (Exception e) {
//            System.out.println("ENV is not remote: " + e.getMessage());
        }
        InputStream file = getClass().getResourceAsStream(path);
        byte[] bytes = new byte[file.available()];
        file.read(bytes);
        String jsonData = new String(bytes, StandardCharsets.UTF_8);
        values = SettingsHolder.fromJson(jsonData);
    }

    public SettingsHolder getValues() {
        return values;
    }

    public static SettingsHolder settings() throws IOException, IllegalAccessException {
        return getInstance().getValues();
    }

    public synchronized static FuzzerSettings getInstance() throws IOException, IllegalAccessException {
        if(instance == null) {
            instance = new FuzzerSettings();
        }
        return instance;
    }

}
