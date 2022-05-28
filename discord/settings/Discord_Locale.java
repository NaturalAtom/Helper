package eu.mixeration.discord.settings;

import eu.mixeration.helper.paths.Path_Discord;

public class Discord_Locale {

    public static String Pong00 = Path_Discord.getConfig().getString("messages.ping-pong.$#00");
    public static String Pong01 = Path_Discord.getConfig().getString("messages.ping-pong.$#01");
    public static String PLAYER_NOT_FOUND = Path_Discord.getConfig().getString("messages.stats.player-not-found");
    public static String GET_STATS = Path_Discord.getConfig().getString("messages.stats.here-is-your-stats");
    public static String TIP_1 = Path_Discord.getConfig().getString("messages.tips.stats");

}
