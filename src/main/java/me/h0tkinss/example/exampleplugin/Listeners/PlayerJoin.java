package me.h0tkinss.example.exampleplugin.Listeners;

import me.h0tkinss.example.exampleplugin.Data.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if (!e.getPlayer().hasPlayedBefore()){
            PlayerData.createPlayerData(e.getPlayer());
        }
        else if (!PlayerData.isExistingPlayer(e.getPlayer())){
            PlayerData.createPlayerData(e.getPlayer());
        }
    }
}
