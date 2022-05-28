package eu.mixeration.discord.settings;

import eu.mixeration.helper.paths.Path_Discord;
import org.jetbrains.annotations.Nullable;

public class Discord_Values {

    public static @Nullable String protectionNotifyChannels_uuid = Path_Discord.getConfig().getString("channels.protection-notifys.uuid");
    public static @Nullable String guild = Path_Discord.getConfig().getString("guild-id");

    public static boolean sendPrivateMessagesToConsole(){
        return Path_Discord.getConfig().getBoolean("discord.modules.send-discord-messages-to-console");
    }

    public static boolean pingPong(){
        return Path_Discord.getConfig().getBoolean("discord.modules.ping-pong");
    }
    public static boolean stats(){
        return Path_Discord.getConfig().getBoolean("discord.modules.stats");
    }

}
