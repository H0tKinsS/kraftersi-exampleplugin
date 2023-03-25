package me.h0tkinss.example.exampleplugin.Commands;

import me.h0tkinss.example.exampleplugin.Data.PlayerData;
import me.h0tkinss.example.exampleplugin.ExamplePlugin;
import me.h0tkinss.example.exampleplugin.Listeners.RubyGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class RubyBank implements CommandExecutor {
    private final ExamplePlugin plugin;
    private final ArrayList<Player> targetMap; // Storing our map as we will need this later
    Inventory inv;
    public RubyBank(ArrayList<Player> targetMap, ExamplePlugin plugin) {
        this.targetMap = targetMap;
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("open")) {
                Player player = Bukkit.getPlayer(args[1]);
                if (PlayerData.isExistingPlayer(player)) {
                    targetMap.add(player);
                    FileConfiguration config = plugin.getConfig();
                    Inventory inv = Bukkit.createInventory(null, config.getInt("ruby-bank-size"),config.getString("ruby-bank-menu"));
                    player.openInventory(inv);
                }
            } else {
                return false;
            }

        }
        return true;
    }
}
