package com.storage.kaktusv6.storage.settings;

import android.content.SharedPreferences;

import com.storage.kaktusv6.storage.MainActivity;

public class Settings {
    static private String base_url = "http://192.168.0.100/";
    static private String path_url = "Storage/hs/our-service/";

    public static final String APP_PREFERENCES = "StorageSettings";
    public static final String APP_PREFERENCES_BASE_URL = "base_url";
    public static final String APP_PREFERENCES_PATH_URL = "path_url";
    public static SharedPreferences mSettings;

    public static String getBase_url() {
        return base_url;
    }

    public static void setBase_url(String base_url) {
        Settings.base_url = base_url;
    }

    public static String getPath_url() {
        return path_url;
    }

    public static void setPath_url(String path_url) {
        Settings.path_url = path_url;
    }
}
