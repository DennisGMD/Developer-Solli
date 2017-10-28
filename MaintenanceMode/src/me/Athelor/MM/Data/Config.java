package me.Athelor.MM.Data;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
	static Config instance = new Config();
	Plugin plugin;
	FileConfiguration dataconfig;
	File file;
	
	public Config() {
	}
	public static Config getInstance() {
		return instance;
	}
	public void setup(Plugin p) {
		this.file = new File(p.getDataFolder(), "config.yml");
        if(!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException var3) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Oops! Something went wrong!");
            }
		}
        this.dataconfig = YamlConfiguration.loadConfiguration(file);
	}
	public FileConfiguration getData() {
		return this.dataconfig;
	}
	public void saveData() {
        try {
            this.dataconfig.save(this.file);
        } catch (IOException var2) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Oops! Something went wrong!");
        }
    }
    public void reloadData() {
        this.dataconfig = YamlConfiguration.loadConfiguration(this.file);
    }
}