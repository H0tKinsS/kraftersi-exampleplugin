package me.h0tkinss.example.exampleplugin;

import me.h0tkinss.example.exampleplugin.Commands.ExampleCommand;
import me.h0tkinss.example.exampleplugin.Commands.RubyBank;
import me.h0tkinss.example.exampleplugin.Listeners.RubyBankPAPI;
import me.h0tkinss.example.exampleplugin.Listeners.PlayerJoin;
import me.h0tkinss.example.exampleplugin.Listeners.RubyGUI;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ExamplePlugin extends JavaPlugin {
    public static ExamplePlugin getPlugin() {
        return plugin;
    }
    private PlayerPointsAPI ppAPI;

    public PlayerPointsAPI getPpAPI() {
        return ppAPI;
    }

    public static ExamplePlugin plugin;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.ppAPI = PlayerPoints.getInstance().getAPI();
        }
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new RubyBankPAPI(this).register();
        }
        PluginManager pm = Bukkit.getPluginManager();
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        ArrayList<Player> targetMap = new ArrayList<>();
        pm.registerEvents(new PlayerJoin(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new RubyGUI(targetMap, this), this);
        getLogger().info("Wlaczono ExamplePlugin!" + getConfig().getString("example"));
        this.getCommand("examplecommand").setExecutor(new ExampleCommand());
        this.getCommand("rubybank").setExecutor(new RubyBank(targetMap, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
