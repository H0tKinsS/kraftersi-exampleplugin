package me.h0tkinss.example.exampleplugin.Coins;

import me.h0tkinss.example.exampleplugin.Data.PlayerData;
import me.h0tkinss.example.exampleplugin.ExamplePlugin;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Coins {
    public static int getCoins(Player p){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        return Integer.parseInt(config.get("coins").toString());
    }
    public static void setCoins(Player p, int amount){
            File f = PlayerData.getPlayerDataFile(p);
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.set("coins", amount);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
