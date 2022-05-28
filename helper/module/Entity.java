package eu.mixeration.helper.module;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Entity {

    public static void send(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String inGame(Player player) {
        if(player.isOnline()) {
            return "✓";
        } else {
            return "☓";
        }
    }

    public static String getPlayerInventory(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            return item.getItemMeta().getDisplayName().toString();
        }
        return "Unknow";
    }

}
