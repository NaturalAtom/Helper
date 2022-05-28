package eu.mixeration.essentials.modules;

import eu.mixeration.essentials.commands.Ess$Locale;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Ess$GameMode {

    public static String changeGamemode(Player player, String gamemode) {
        if(player == null) {
            return "Null";
        } else {
            if(gamemode.equalsIgnoreCase("creative")) {
                player.setGameMode(GameMode.CREATIVE);
            } else if(gamemode.equalsIgnoreCase("survival")) {
                player.setGameMode(GameMode.SURVIVAL);
            } else if(gamemode.equalsIgnoreCase("adventure")) {
                player.setGameMode(GameMode.ADVENTURE);
            } else if(gamemode.equalsIgnoreCase("spectator")) {
                player.setGameMode(GameMode.SPECTATOR);
            } else {
                return "Unknow";
            }
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Ess$Locale.GAMEMODE_CHANGE.replace("<gamemode>", gamemode.toUpperCase(Locale.ROOT))));
        }
        return "Unknow";
    }

}
