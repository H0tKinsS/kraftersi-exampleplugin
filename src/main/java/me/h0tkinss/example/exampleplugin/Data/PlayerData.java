package me.h0tkinss.example.exampleplugin.Data;

import me.h0tkinss.example.exampleplugin.ExamplePlugin;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerData {

    public static boolean isExistingPlayer(Player p) {
        File f = new File(ExamplePlugin.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");
        return f.exists();
    }

    public static void createPlayerData(Player p) {
        if (!isExistingPlayer(p)) {
            File f = new File(ExamplePlugin.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");
            File folder = new File(ExamplePlugin.getPlugin().getDataFolder() + "/player-data/", "");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.set("coins", 0);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File getPlayerDataFile(Player p) {
        if (isExistingPlayer(p)) {
            return new File(ExamplePlugin.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");
        }
        return null;
    }
}
