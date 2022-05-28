package eu.mixeration.$mixeration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Mixeration_Manager {

    public static void console(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void player(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static int getPing(Player player) {
        int ping = 0;
        try {

            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            ping = entityPlayer.getClass().getField("ping").getInt(entityPlayer);

        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException |
                 NoSuchMethodException | InvocationTargetException e) {
        }
        return ping;
    }

    public static String isOp(Player player) {
        if(player.isOp()) {
            return "✓";
        } else {
            return "☓";
        }
    }
}
