package eu.mixeration.essentials.events;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.helper.CustomJoinMessage;
import eu.mixeration.helper.paths.Path_Essentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Iterator;

public class CustomJoinMessageEvent implements Listener {

    public CustomJoinMessageEvent(Helper helper) {
    }

    @Deprecated
    @EventHandler()
    public void userJoinEvent(PlayerJoinEvent joinEvent) {
        Player user = joinEvent.getPlayer();
        String groups;
        Iterator var8;
        if (CustomJoinMessage.get()) {
            if (Path_Essentials.getConfig().getString("essentials.settings.join-message.type").equalsIgnoreCase("oneLineText")) {
                String message = Path_Essentials.getConfig().getString("essentials.settings.join-message.oneLineText.message");
                message = message.replace("%name", user.getName());
                message = message.replace("%displayname", user.getDisplayName());
                joinEvent.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message));
            } else if (Path_Essentials.getConfig().getString("essentials.settings.join-message.type").equalsIgnoreCase("oversizedText")) {
                var8 = Path_Essentials.getConfig().getStringList("essentials.settings.join-message.oversizedText.message").iterator();

                while (var8.hasNext()) {
                    groups = (String) var8.next();
                    groups = groups.replace("%name", user.getName());
                    groups = groups.replace("%displayname", user.getDisplayName());
                    joinEvent.setJoinMessage((String) null);
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', groups));
                }
            } else {
                String name;
                Iterator var6;
                String message;
                if (Path_Essentials.getConfig().getString("essentials.settings.join-message.type").equalsIgnoreCase("usePermission")) {
                    var8 = Path_Essentials.getConfig().getConfigurationSection("essentials.settings.join-message.usePermission").getKeys(false).iterator();

                    label70:
                    while (true) {
                        do {
                            if (!var8.hasNext()) {
                                break label70;
                            }

                            groups = (String) var8.next();
                            name = Path_Essentials.getConfig().getString("essentials.settings.join-message.usePermission." + groups + ".permission");
                        } while (!user.hasPermission(name));

                        var6 = Path_Essentials.getConfig().getStringList("essentials.settings.join-message.usePermission." + groups + ".message").iterator();

                        while (var6.hasNext()) {
                            message = (String) var6.next();
                            message = message.replace("%name", user.getName());
                            message = message.replace("%displayname", user.getDisplayName());
                            joinEvent.setJoinMessage((String) null);
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
                        }
                    }
                } else if (Path_Essentials.getConfig().getString("essentials.settings.join-message.type").equalsIgnoreCase("perPlayer")) {
                    var8 = Path_Essentials.getConfig().getConfigurationSection("essentials.settings.join.perPlayer").getKeys(false).iterator();

                    label55:
                    while (true) {
                        do {
                            if (!var8.hasNext()) {
                                break label55;
                            }

                            groups = (String) var8.next();
                            name = Path_Essentials.getConfig().getString("essentials.settings.join-message.perPlayer." + groups + ".name");
                        } while (!user.getName().equalsIgnoreCase(name));

                        var6 = Path_Essentials.getConfig().getStringList("essentials.settings.join-message.perPlayer." + groups + ".message").iterator();

                        while (var6.hasNext()) {
                            message = (String) var6.next();
                            message = message.replace("%name", user.getName());
                            message = message.replace("%displayname", user.getDisplayName());
                            joinEvent.setJoinMessage((String) null);
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
                        }
                    }
                }
            }
        } else {
            joinEvent.setJoinMessage((String) null);
        }

        if (Path_Essentials.getConfig().getBoolean("essentials.settings.motd.enable")) {
            var8 = Path_Essentials.getConfig().getStringList("messages.motd.messages").iterator();

            while (var8.hasNext()) {
                groups = (String) var8.next();
                groups = groups.replace("%name", user.getName());
                groups = groups.replace("%displayname", user.getDisplayName());
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', groups));
            }
        }

    }
}