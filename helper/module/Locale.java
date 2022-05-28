package eu.mixeration.helper.module;

import eu.mixeration.helper.paths.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Locale {

    public static String NOPERMISSION = Path_Locale.getConfig().getString("messages.no-permission");
    public static String ONLYINGAME = Path_Locale.getConfig().getString("messages.only-for-players");
    public static String RELOADED = Path_Locale.getConfig().getString("messages.plugin-reloaded");
    public static String VALUES_TITLE = Path_Locale.getConfig().getString("messages.values-title");

    public static void helpMessage(Player player, String help_message_path) {
        for(String help : Path_Locale.getConfig().getStringList(help_message_path)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
        }
    }

    public static void consoleMessage(String path) {
        for(String help : Path_Locale.getConfig().getStringList(path)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', help));
        }
    }

    public static void listMessage(Player player, String listmessage) {
        for(String help : Path_Locale.getConfig().getStringList(listmessage)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
        }
    }


    public static String WORLD_TITLE = Path_Locale.getConfig().getString("messages.world.title");
    public static String COPY_WORLD_PLEASE_CHECK_HELPER_FOLDER = Path_Locale.getConfig().getString("messages.world.please-check-helper-folder");
    public static String WORLD_NOT_FOUND = Path_Locale.getConfig().getString("messages.world.world-not-found");
    public static String PROXY_LINK_CHANGED = Path_Proxy.getConfig().getString("proxy.link-changed");
    public static String PROXY_RESETED = Path_Proxy.getConfig().getString("proxy.link-reseted");
    public static String PROXY_GETLINK = Path_Proxy.getConfig().getString("proxy.get-link");

    public static String OP_LIST_VALUE = Path_Operator.getConfig().getString("operator.list.value");
    public static String OP_LIST_TITLE = Path_Operator.getConfig().getString("operator.list.title");
    public static String OP_ADDED = Path_Operator.getConfig().getString("operator.added");
    public static String OP_REMOVED = Path_Operator.getConfig().getString("operator.removed");
    public static String OP_ALREADY_IN_LIST = Path_Operator.getConfig().getString("operator.already-in-list");
    public static String OP_NOT_IN_LIST = Path_Operator.getConfig().getString("operator.not-in-list");


    public static String PLUGINATOR_DIRECTORY = Path_Pluginator.getConfig().getString("pluginator.plugin-directory");
    public static String PLUGINATOR_CANNOTFIND = Path_Pluginator.getConfig().getString("pluginator.plugin-not-found");
    public static String PLUGINATOR_INVAILDPLUGIN = Path_Pluginator.getConfig().getString("pluginator.invaild-plugin");
    public static String PLUGINATOR_INVAILDDESC = Path_Pluginator.getConfig().getString("pluginator.invaild-description");
    public static String PLUGINATOR_LOADED = Path_Pluginator.getConfig().getString("pluginator.plugin-loaded");
    public static String PLUGINATOR_UNLOADED = Path_Pluginator.getConfig().getString("pluginator.plugin-unloaded");
    public static String PLUGINATOR_ENABLED = Path_Pluginator.getConfig().getString("pluginator.plugin-enabled");
    public static String PLUGINATOR_DISABLED = Path_Pluginator.getConfig().getString("pluginator.plugin-disabled");
    public static String PLUGINATOR_RELOADED = Path_Pluginator.getConfig().getString("pluginator.plugin-reloaded");
    public static String PLUGINATOR_RELOAD_ALL = Path_Pluginator.getConfig().getString("pluginator.all-plugin-reload.reloaded");
    public static String PLUGINATOR_ENABLE_ALL = Path_Pluginator.getConfig().getString("pluginator.all-plugin-enable.enabled");
    public static String PLUGINATOR_DISABLED_ALL = Path_Pluginator.getConfig().getString("pluginator.all-plugin-disable.disabled");
    public static String PLUGINATOR_RELOAD_BLOCKED = Path_Pluginator.getConfig().getString("pluginator.all-plugin-reload.you-cannot-do-that");
    public static String PLUGINATOR_ENABLE_BLOCKED = Path_Pluginator.getConfig().getString("pluginator.all-plugin-enable.you-cannot-do-that");

    public static String HMT_JWHMT = Path_Maintenancer.getConfig().getString("maintenancer.server-in-maintenance");
    public static String HMT_LIST_VALUE = Path_Maintenancer.getConfig().getString("maintenancer.list.value");
    public static String HMT_LIST_TITLE = Path_Maintenancer.getConfig().getString("maintenancer.list.title");
    public static String HMT_ALREADY_IN_LIST = Path_Maintenancer.getConfig().getString("maintenancer.already-in-list");
    public static String HMT_NOT_IN_LIST = Path_Maintenancer.getConfig().getString("maintenancer.not-in-list");
    public static String HMT_ADDED = Path_Maintenancer.getConfig().getString("maintenancer.added");
    public static String HMT_REMOVED = Path_Maintenancer.getConfig().getString("maintenancer.removed");
    public static String HMT_ENABLED = Path_Maintenancer.getConfig().getString("maintenancer.enabled");
    public static String HMT_DISABLED = Path_Maintenancer.getConfig().getString("maintenancer.disabled");


}
