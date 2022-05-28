package eu.mixeration.discord.helper;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class DiscordCommand_Helper extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("Helper")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Helper", null);
            eb.setColor(new Color(0x1756DE));
            eb.setDescription("Helper | Help Messages");
            eb.addField("**-** /Helper ", "See the commands of the helper plugin.", false);
            eb.addField("**-** /HelperServer ", "Shows server status.", false);
            eb.addField("**-** /HelperWorld ", "Shows world status.", false);
            eb.addField("**-** /HelperClient ", "You determine which clients will enter the server.", false);
            eb.addField("**-** /HelperEssentials ", "When the Essentials plugin is not found, the helper activates itself and installs the essentials packages.", false);
            eb.addBlankField(false);
            eb.setAuthor("name", null, "https://avatars.githubusercontent.com/u/64479768?v=4");
            eb.setImage("https://avatars.githubusercontent.com/u/64479768?v=4");
            event.getChannel().sendMessage((Message) eb.build()).queue();
        }
    }
}
