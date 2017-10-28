package me.Athelor.MM;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.Athelor.MM.Command.MaintenanceCMD;
import me.Athelor.MM.Data.Config;
import me.Athelor.MM.Listener.JoinListener;

public class MainClass extends JavaPlugin {
    private static Config data = Config.getInstance();

    public MainClass() {
    }

    public void registerCommands() {
        this.getCommand("maintenance").setExecutor(new MaintenanceCMD());
    }

    public void onEnable() {
    	this.getLogger().info("Made by Athelor");
        this.registerCommands();
        data.setup(this);
        data.getData().addDefault("activated", Boolean.valueOf(false));
        data.getData().addDefault("kick-message", "Server is in maintenance!");
        data.getData().options().copyDefaults(true);
        data.saveData();
        registerEvents(this, new Listener[]{new JoinListener()});
    }

    public void onDisable() {
        this.getLogger().info("Made by Athelor");
    }

    public static void registerEvents(Plugin plugin, Listener... listeners) {
        Listener[] var5 = listeners;
        int var4 = listeners.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Listener listener = var5[var3];
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }

    }
}
