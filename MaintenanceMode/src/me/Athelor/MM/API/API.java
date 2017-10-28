package me.Athelor.MM.API;

import me.Athelor.MM.Data.Config;

public class API {
    public static Config data = Config.getInstance();

    public API() {
    }

    public static Boolean getActivated() {
        return Boolean.valueOf(data.getData().getBoolean("activated"));
    }

    public static String getKickMessage() {
        return data.getData().getString("kick-message");
    }

    public static void setActivated(Boolean activated) {
        data.getData().set("activated", activated);
        data.saveData();
    }
}
