package me.h0tkinss.example.exampleplugin.Commands;

import me.h0tkinss.example.exampleplugin.Coins.Coins;
import me.h0tkinss.example.exampleplugin.Data.PlayerData;
import me.h0tkinss.example.exampleplugin.ExamplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ExampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = ((Player) sender);
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("balance")) {
                    p.sendMessage(ChatColor.GREEN + "Your balance is " + ChatColor.YELLOW + Coins.getCoins(p) + ChatColor.GREEN + " coins.");
                }
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("rubybank")) {
                    Player player = Bukkit.getPlayer(args[1]);
                    if (PlayerData.isExistingPlayer(player)) {

                    }
                }
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    Player player = Bukkit.getPlayer(args[1]);
                    if (player.isOnline()) {
                        Coins.setCoins(player, Integer.valueOf(args[2]));
                        p.sendMessage("Set " + player.getName() + " coins to " + args[2]);
                    }
                }
                if (args[0].equalsIgnoreCase("add")) {
                    Player player = Bukkit.getPlayer(args[1]);
                    if (PlayerData.isExistingPlayer(player)) {
                        Coins.setCoins(player, Coins.getCoins(player) + Integer.valueOf(args[2]));
                        p.sendMessage("Added " + args[2] + " coins to " + player.getName());
                    }
                }

            }
        }

        return true;

    }
}