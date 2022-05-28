package eu.mixeration.essentials.commands;

import eu.mixeration.helper.paths.Path_Essentials;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Ess$Locale {

    public static void essentialsHelpMessage(Player player, String path){
        for(String essPath : Path_Essentials.getConfig().getStringList(path)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', essPath));
        }
    }
    public static String GAMEMODE_CHANGE = Path_Essentials.getConfig().getString("essentials.messages.gamemode.changed");
    public static String GAMEMODE_NOTONLINE = Path_Essentials.getConfig().getString("essentials.messages.gamemode.not-online");
    public static String GAMEMODE_CHANGED_FOR = Path_Essentials.getConfig().getString("essentials.messages.gamemode.changed-for-others");

    public static String HIDE_SUCCES = Path_Essentials.getConfig().getString("essentials.messages.hide.success");
    public static String HIDE_NOTYOURSELF = Path_Essentials.getConfig().getString("essentials.messages.hide.cannot-hide-yourself");
    public static String HIDE_NOTONLINE = Path_Essentials.getConfig().getString("essentials.messages.hide.not-online");
    public static String SHOW_SUCCES = Path_Essentials.getConfig().getString("essentials.messages.show.success");
    public static String SHOW_NOTONLINE = Path_Essentials.getConfig().getString("essentials.messages.show.not-online");
    public static String SHOW_NOTYOURSELF = Path_Essentials.getConfig().getString("essentials.messages.show.cannot-hide-yourself");


    public static String HIDEALL_SUCCES = Path_Essentials.getConfig().getString("essentials.messages.hide-all.success");
    public static String SHOWALL_SUCCES = Path_Essentials.getConfig().getString("essentials.messages.show-all.success");
    public static String YOUR_PING = Path_Essentials.getConfig().getString("essentials.messages.ping.your-ping-is");
    public static String PING_NOT_ONLINE = Path_Essentials.getConfig().getString("essentials.messages.ping.player-not-online");
    public static String PLAYERS_PING = Path_Essentials.getConfig().getString("essentials.messages.ping.target-ping-is");

}
