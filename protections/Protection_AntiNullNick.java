package eu.mixeration.protections;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.helper.AntiNullNick;
import eu.mixeration.helper.paths.Path_AntiNullNick;
import eu.mixeration.helper.paths.Path_Config;
import eu.mixeration.helper.paths.Path_ProtectionsLocale;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Protection_AntiNullNick implements Listener {
    public Protection_AntiNullNick(Helper helper) {}

    @Deprecated
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        if(AntiNullNick.get()) {
            if (e.getPlayer().getName().matches(Path_AntiNullNick.getConfig().getString("anti-null-nick.matches"))) {
                if(Path_AntiNullNick.getConfig().getBoolean("anti-null-nick.information.passed-nick-control")) {
                    for(String passed : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-null-nick.passed")) {
                        e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', passed));
                    }
                }
                if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.null-nick")) {
                    Console.message("&b{ &9Helper | &bSuccess | &3Anti Null Nick &b} &7Player &f&o" + e.getPlayer().getName() + "&7 passed null nickname control.");
                }
            } else {
                if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.null-nick")) {
                    Console.message("&b{ &9Helper | &bError | &3Anti Null Nick &b} &7Suspect &f&o" + e.getPlayer().getName() + "&7 directly kicked from server, Reason: &9Null Nick");
                }
                for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-null-nick.kick-message")) {
                    e.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                }
            }
        }
    }

}
