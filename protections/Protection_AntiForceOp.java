package eu.mixeration.protections;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.paths.Path_Helper;
import eu.mixeration.helper.paths.Path_Operator;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Protection_AntiForceOp implements Listener {
    public Protection_AntiForceOp(Helper helper) {}

    @Deprecated
    @EventHandler
    public void move(PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Helper.get(), new BukkitRunnable() {
            public void run() {
                if (!Path_Operator.getConfig().getStringList("operator.users").contains(p.getUniqueId().toString()) && ! Path_Operator.getConfig().getStringList("operator.users").contains(p.getName()) && p.isOp()) {
                    p.setOp(false);
                    Helper.get().getServer().dispatchCommand(Helper.get().getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', Path_Operator.getConfig().getString("operator.punishment").replace("<player>", p.getName())));
                }
            }
        }, Path_Helper.getConfig().getLong("anti-force-op-check-interval"), Path_Helper.getConfig().getLong("anti-force-op-check-interval-period"));
    }

    @Deprecated
    @EventHandler
    public void join(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Helper.get(), new BukkitRunnable() {
            public void run() {
                if (!Path_Operator.getConfig().getStringList("operator.users").contains(p.getUniqueId().toString()) && ! Path_Operator.getConfig().getStringList("operator.users").contains(p.getName()) && p.isOp()) {
                    p.setOp(false);
                    Helper.get().getServer().dispatchCommand(Helper.get().getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', Path_Operator.getConfig().getString("operator.punishment").replace("<player>", p.getName())));
                }
            }
        }, Path_Helper.getConfig().getLong("anti-force-op-check-interval"), Path_Helper.getConfig().getLong("anti-force-op-check-interval-period"));
    }

    @Deprecated
    @EventHandler
    public void chat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Helper.get(), new BukkitRunnable() {
            public void run() {
                if (!Path_Operator.getConfig().getStringList("operator.users").contains(p.getUniqueId().toString()) && ! Path_Operator.getConfig().getStringList("operator.users").contains(p.getName()) && p.isOp()) {
                    p.setOp(false);
                    Helper.get().getServer().dispatchCommand(Helper.get().getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', Path_Operator.getConfig().getString("operator.punishment").replace("<player>", p.getName())));
                }
            }
        }, Path_Helper.getConfig().getLong("anti-force-op-check-interval"), Path_Helper.getConfig().getLong("anti-force-op-check-interval-period"));
    }

    @Deprecated
    @EventHandler
    public void command(PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Helper.get(), new BukkitRunnable() {
            public void run() {
                if (!Path_Operator.getConfig().getStringList("operator.users").contains(p.getUniqueId().toString()) && ! Path_Operator.getConfig().getStringList("operator.users").contains(p.getName()) && p.isOp()) {
                    p.setOp(false);
                    Helper.get().getServer().dispatchCommand(Helper.get().getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', Path_Operator.getConfig().getString("operator.punishment").replace("<player>", p.getName())));
                }
            }
        }, Path_Helper.getConfig().getLong("anti-force-op-check-interval"), Path_Helper.getConfig().getLong("anti-force-op-check-interval-period"));
    }
}
