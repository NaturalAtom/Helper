package eu.mixeration.protections;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.Path_AntiBookCrash;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.nio.charset.StandardCharsets;

public class Protection_AntiBookCrash implements Listener {
    public Protection_AntiBookCrash(Helper helper) {}

    @Deprecated
    @EventHandler
    public void onBookEdit(PlayerEditBookEvent e) {
        for (String bookPage : e.getNewBookMeta().getPages()) {
            if (!StandardCharsets.US_ASCII.newEncoder().canEncode(bookPage)) {
                e.setCancelled(true);
                String antiBook = Path_AntiBookCrash.getConfig().getString("anti-book-crash.asci-charsets.cancel-event");
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', antiBook));
                for (Player onlineStaff : Bukkit.getOnlinePlayers()) {
                    if (!(Lists_And_Maps.notify_antibookcrash.get(onlineStaff.getUniqueId()) == null)) {
                        onlineStaff.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_AntiBookCrash.getConfig().getString("anti-book-crash.notify").replace("%suspect%", e.getPlayer().getName()).replace("%next_line%", "\n\n").replace("%suspect_address%", e.getPlayer().getAddress().getAddress().getHostAddress())));
                    }
                }
            }
        }
    }
}

