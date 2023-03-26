package me.h0tkinss.example.exampleplugin.Listeners;

import dev.lone.itemsadder.api.CustomStack;
import me.h0tkinss.example.exampleplugin.ExamplePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;


public class RubyGUI implements Listener
{
    private final ArrayList<Player> targetMap; // Storing our map as we will need this later
    private final ExamplePlugin plugin;
    public RubyGUI(ArrayList<Player> targetMap, ExamplePlugin plugin) {
        this.targetMap = targetMap;
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(!targetMap.contains(e.getWhoClicked())){
            return;
        } else {
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)){
                e.setCancelled(true);
                return;
            }
            Inventory inv = e.getInventory();
            int clickedSlot = e.getRawSlot();
            if (clickedSlot < inv.getSize()) {
                e.setCancelled(true);
                Player p = (Player) e.getWhoClicked();
                ItemStack item = e.getCursor();
                if (item == null) {
                    return;
                }
                int amount = item.getAmount();
                CustomStack cs = CustomStack.byItemStack(item);
                List<Integer> workingSlots = plugin.getConfig().getIntegerList("ruby-bank-working-slots");
                if (!workingSlots.contains(clickedSlot)) {
                    return;
                }
                if (cs != null && cs.getNamespacedID().equals(plugin.getConfig().getString("ruby-itemsadder-namespacedid"))){
                    plugin.getPpAPI().give(p.getUniqueId(), amount);
                    p.setItemOnCursor(null);
                }

                p.updateInventory();
            }

        }

    }    @EventHandler
    public void onInventoryDragEvent(InventoryDragEvent e) {
        if(!targetMap.contains(e.getWhoClicked())) return;
        Inventory inv = e.getInventory();
        Integer size = inv.getSize();
        Set<Integer> slots = e.getRawSlots();
        for (Integer slot : slots){
            if (slot < size) {
                e.setCancelled(true);
                return;
            }
        }
//            ItemStack item = e.getOldCursor();
//            CustomStack cs = CustomStack.byItemStack(item);
//            if (cs != null && cs.getNamespacedID().equals(plugin.getConfig().getString("ruby-itemsadder-namespacedid"))){
//                for (Integer slot : slots){
//                    if (!(slot > 11 && slot < 16)) {
//                        return;
//                    }
//                }
//                Integer amount = item.getAmount();
//                Player p = (Player) e.getWhoClicked();
//                plugin.getPpAPI().give(p.getUniqueId(), amount);
//                item.setType(Material.AIR);
            }

    @EventHandler
    public void onInventoryClosed(InventoryCloseEvent event) {
        targetMap.remove(event.getPlayer());
    }


}