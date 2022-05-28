package eu.mixeration.essentials.events;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.helper.CustomQuitMessage;
import eu.mixeration.helper.paths.Path_Essentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Iterator;

public class CustomQuitMessageEvent implements Listener {

    public CustomQuitMessageEvent(Helper helper) {
    }

    @Deprecated
    @EventHandler
    public void userQuitEvent(PlayerQuitEvent quitEvent) {
        Player user = quitEvent.getPlayer();
        String groups;
        Iterator var8;
        if (CustomQuitMessage.get()) {
            if (Path_Essentials.getConfig().getString("essentials.settings.quit-message.type").equalsIgnoreCase("oneLineText")) {
                String message = Path_Essentials.getConfig().getString("essentials.settings.quit-message.oneLineText.message");
                message = message.replace("%name", user.getName());
                message = message.replace("%displayname", user.getDisplayName());
                quitEvent.setQuitMessage(ChatColor.translateAlternateColorCodes('&', message));
            } else if (Path_Essentials.getConfig().getString("essentials.settings.quit-message.type").equalsIgnoreCase("oversizedText")) {
                var8 = Path_Essentials.getConfig().getStringList("essentials.settings.quit-message.oversizedText.message").iterator();

                while (var8.hasNext()) {
                    groups = (String) var8.next();
                    groups = groups.replace("%name", user.getName());
                    groups = groups.replace("%displayname", user.getDisplayName());
                    quitEvent.setQuitMessage((String) null);
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', groups));
                }
            } else {
                String name;
                Iterator var6;
                String message;
                if (Path_Essentials.getConfig().getString("essentials.settings.quit-message.type").equalsIgnoreCase("usePermission")) {
                    var8 = Path_Essentials.getConfig().getConfigurationSection("essentials.settings.quit-message.usePermission").getKeys(false).iterator();

                    label70:
                    while (true) {
                        do {
                            if (!var8.hasNext()) {
                                break label70;
                            }

                            groups = (String) var8.next();
                            name = Path_Essentials.getConfig().getString("essentials.settings.quit-message.usePermission." + groups + ".permission");
                        } while (!user.hasPermission(name));

                        var6 = Path_Essentials.getConfig().getStringList("essentials.settings.quit-message.usePermission." + groups + ".message").iterator();

                        while (var6.hasNext()) {
                            message = (String) var6.next();
                            message = message.replace("%name", user.getName());
                            message = message.replace("%displayname", user.getDisplayName());
                            quitEvent.setQuitMessage((String) null);
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
                        }
                    }
                } else if (Path_Essentials.getConfig().getString("essentials.settings.quit-message.type").equalsIgnoreCase("perPlayer")) {
                    var8 = Path_Essentials.getConfig().getConfigurationSection("essentials.settings.quit.perPlayer").getKeys(false).iterator();

                    label55:
                    while (true) {
                        do {
                            if (!var8.hasNext()) {
                                break label55;
                            }

                            groups = (String) var8.next();
                            name = Path_Essentials.getConfig().getString("essentials.settings.quit-message.perPlayer." + groups + ".name");
                        } while (!user.getName().equalsIgnoreCase(name));

                        var6 = Path_Essentials.getConfig().getStringList("essentials.settings.quit-message.perPlayer." + groups + ".message").iterator();

                        while (var6.hasNext()) {
                            message = (String) var6.next();
                            message = message.replace("%name", user.getName());
                            message = message.replace("%displayname", user.getDisplayName());
                            quitEvent.setQuitMessage((String) null);
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
                        }
                    }
                }
            }
        } else {
            quitEvent.setQuitMessage((String) null);
        }
    }

}
