package eu.mixeration.helper.events;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.Path_Maintenancer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MaintenancerEvent implements Listener {
    public MaintenancerEvent(Helper helper) {}

    @EventHandler
    @Deprecated
    public void hmtEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Lists_And_Maps.maintenance.get("server")) {
            if (Path_Maintenancer.getConfig().getStringList("helper.maintenancer.whitelist").contains(player.getName())) {
                Entity.send(player, Locale.HMT_JWHMT);
            } else {
                for (String kick : Path_Maintenancer.getConfig().getStringList("maintenancer.kick-reason")) {
                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                }
            }
        }
    }
}
