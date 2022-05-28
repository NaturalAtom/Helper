package eu.mixeration.discord.settings;

import eu.mixeration.helper.paths.Path_Discord;

public class Discord_CommandPackageListener {

    public static String Ping_Pong = Path_Discord.getConfig().getString("commands.ping-pong");
    public static String Stats = Path_Discord.getConfig().getString("commands.stats");
    public static String hookWithMc = Path_Discord.getConfig().getString("commands.integrate-minecraft-account-with-discord");

}
