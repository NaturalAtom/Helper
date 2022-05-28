package eu.mixeration.discord;

import eu.mixeration.discord.events.PingPong;
import eu.mixeration.discord.events.SendMessageToConsole;
import eu.mixeration.discord.events.InGameStats;
import eu.mixeration.discord.settings.Discord_Values;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.paths.Path_Discord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.Locale;

public class SetupDiscordBot extends ListenerAdapter {

    public static JDABuilder builder;
    public static JDA jda;
    public static void openDiscordBot(String token) throws LoginException {
        jda = JDABuilder.createDefault(token).build();
        builder = JDABuilder.createDefault(token);
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setCompression(Compression.NONE);
        String type = Path_Discord.getConfig().getString("discord.bot-status.type$0");
        String type1 = Path_Discord.getConfig().getString("discord.bot-status.type$1");
        String event = Path_Discord.getConfig().getString("discord.bot-status-event");
        String streaming = Path_Discord.getConfig().getString("discord.bot-status-streaming");
        Console.message("&b{ &9Helper &3| &fDiscord : Status $ Type%0 &b} &7Type$0 status type : &9" + type.toUpperCase(Locale.ROOT));
        if (type.equalsIgnoreCase("watching")) {
            builder.setActivity(Activity.watching(event));
        } else if (type.equalsIgnoreCase("playing")) {
            builder.setActivity(Activity.playing(event));
        } else if (type.equalsIgnoreCase("competing")) {
            builder.setActivity(Activity.competing(event));
        } else if (type.equalsIgnoreCase("streaming")) {
            builder.setActivity(Activity.streaming(event, streaming));
        } else if (type.equalsIgnoreCase("listening")) {
            builder.setActivity(Activity.listening(event));
        }
        Console.message("&b{ &9Helper &3| &fDiscord : Status $ Type%1 &b} &7Type$1 status type : &9" + type1.toUpperCase());
        if (type1.equalsIgnoreCase("do-not-distrub")) {
            builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        } else if (type1.equalsIgnoreCase("idle")) {
            builder.setStatus(OnlineStatus.IDLE);
        } else if (type1.equalsIgnoreCase("online")) {
            builder.setStatus(OnlineStatus.ONLINE);
        } else if (type1.equalsIgnoreCase("offline")) {
            builder.setStatus(OnlineStatus.OFFLINE);
        } else if (type1.equalsIgnoreCase("invisible")) {
            builder.setStatus(OnlineStatus.INVISIBLE);
        }
        builder.build();
        jda.addEventListener(new SendMessageToConsole());
        Console.message("&b{ &9Helper &3| &fDiscord &b} &7/Helper activated, you can use that command for help.");
        if(Discord_Values.sendPrivateMessagesToConsole()) {
            jda.addEventListener(new SendMessageToConsole());
            Console.message("&b{ &9Helper &3| &fDiscord : Modules &b} &7Send private messages to console module is enabled.");
        } else {
            Console.message("&b{ &9Helper &3| &fDiscord : Modules &b} &7Send private messages to console module is &cnot enable&7.");
        }
        if(Discord_Values.stats()) {
            jda.addEventListener(new InGameStats());
            Console.message("&b{ &9Helper &3| &fDiscord : Modules &b} &7Stats module is enabled.");
        } else {
            Console.message("&b{ &9Helper &3| &fDiscord : Modules &b} &7Stats module is &cnot enable&7.");
        }
        if(Discord_Values.pingPong()) {
            jda.addEventListener(new PingPong());
            Console.message("&b{ &9Helper &3| &fDiscord : Modules &b} &7Ping pong module is enabled.");
        } else {
            Console.message("&b{ &9Helper &3| &fDiscord : Modules &b} &7Ping pong module is &cnot enable&7.");
        }
    }
}
