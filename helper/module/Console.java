package eu.mixeration.helper.module;

import eu.mixeration.helper.paths.Path_Essentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Console {

    public static void message(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void listMessageForEssentials(String path) {
        for (String list : Path_Essentials.getConfig().getStringList(path)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', path));
        }
    }

}
