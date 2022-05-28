package eu.mixeration.discord.events;

import eu.mixeration.$mixeration.Mixeration_Manager;
import eu.mixeration.discord.settings.Discord_CommandPackageListener;
import eu.mixeration.discord.settings.Discord_Locale;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.paths.Path_Discord;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static eu.API_Vault.econ;

public class InGameStats extends ListenerAdapter {

    @Deprecated
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String name = event.getMessage().getGuild().getMemberById(event.getMessage().getAuthor().getId()).getNickname();
        if (msg.getContentRaw().equals(Discord_CommandPackageListener.Stats)) {
            assert name != null;
            Player bukkitPlayer = Bukkit.getPlayer(name);
            MessageChannel channel = event.getChannel();
            if(bukkitPlayer == null) {
                channel.sendMessage(Discord_Locale.PLAYER_NOT_FOUND).queue();
                if(Path_Discord.getConfig().getBoolean("discord.values.send-tips")) {
                    channel.sendMessage(Discord_Locale.TIP_1).queue();
                }
            } else {
                channel.sendMessage(Discord_Locale.GET_STATS.replace("<nl>", "\n")
                        .replace("<name>", bukkitPlayer.getName())
                        .replace("<balance>", String.valueOf(econ.getBalance(bukkitPlayer)))
                        .replace("<locale>", bukkitPlayer.getLocale())
                        .replace("<food>", String.valueOf(bukkitPlayer.getFoodLevel()))
                        .replace("<health>", String.valueOf(bukkitPlayer.getHealth()))
                        .replace("<bed-loc>", String.valueOf(bukkitPlayer.getBedSpawnLocation()))
                        .replace("<world>", bukkitPlayer.getWorld().getName())
                        .replace("<ping>", String.valueOf(Mixeration_Manager.getPing(bukkitPlayer)))
                        .replace("<op>", Mixeration_Manager.isOp(bukkitPlayer))
                        .replace("<inGame>", Entity.inGame(bukkitPlayer))).queue();
            }
        }
    }
}
