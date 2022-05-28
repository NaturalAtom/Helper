package eu.mixeration.discord.events;

import eu.mixeration.discord.settings.Discord_CommandPackageListener;
import eu.mixeration.discord.settings.Discord_Locale;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingPong extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals(Discord_CommandPackageListener.Ping_Pong)) {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage(Discord_Locale.Pong00)
                    .queue(response -> {
                        response.editMessageFormat(Discord_Locale.Pong01, System.currentTimeMillis() - time).queue();
                    });
        }
    }
}
