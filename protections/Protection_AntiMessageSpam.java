package eu.mixeration.protections;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.Path_Helper;
import eu.mixeration.helper.paths.Path_ProtectionsLocale;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Protection_AntiMessageSpam implements Listener {
    public Protection_AntiMessageSpam(Helper helper) {}

    @Deprecated
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        int cooldowntime = Path_Helper.getConfig().getInt("anti-message-spam.cooldown");
        Player player = e.getPlayer();
        if (Lists_And_Maps.cooldown.containsKey(player.getUniqueId())) {
            long secondsleft = (Long) Lists_And_Maps.cooldown.get(player.getUniqueId()) / 1000L + (long)cooldowntime - System.currentTimeMillis() / 1000L;
            String format = String.format(String.valueOf(secondsleft));
            if (secondsleft > 0L) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_ProtectionsLocale.getConfig().getString("protections.anti-spam.please-wait").replace("<delay>", format)));
            } else {
                Lists_And_Maps.cooldown.remove(player.getUniqueId());
            }
        } else {
            Lists_And_Maps.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
        }

    }

}
