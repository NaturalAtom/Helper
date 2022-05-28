package eu.mixeration.helper.events.proxy;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.paths.Path_ProtectionsLocale;
import eu.mixeration.helper.paths.Path_Proxy;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

public class ProxyEvent implements Listener {

    public ProxyEvent(Helper helper) {}

    @Deprecated
    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void onJoin(PlayerLoginEvent event) {
        boolean notifyop = Path_Proxy.getConfig().getBoolean("proxy.notify-op");
        String usingProxy_Console = ChatColor.translateAlternateColorCodes('&', Path_Proxy.getConfig().getString("proxy.using-proxy.console"));
        String usingProxy_Player = ChatColor.translateAlternateColorCodes('&', Path_Proxy.getConfig().getString("proxy.using-proxy.player"));
        String noProxy_Console = ChatColor.translateAlternateColorCodes('&', Path_Proxy.getConfig().getString("proxy.not-using-proxy.console"));
        String noProxy_Player = ChatColor.translateAlternateColorCodes('&', Path_Proxy.getConfig().getString("proxy.not-using-proxy.player"));
        Player player = event.getPlayer();
        String playerip = event.getAddress().getHostAddress();
        if (!player.hasPermission(Path_Proxy.getConfig().getString("proxy.bypass-permission"))) {
            Player p;
            Iterator var12;
            if (isBad(playerip)) {
                Bukkit.getLogger().info(usingProxy_Console.replace("<address>", playerip).replace("<name>", player.getName()));
                var12 = Bukkit.getOnlinePlayers().iterator();

                while(var12.hasNext()) {
                    p = (Player)var12.next();
                    if (notifyop && p.isOp()) {
                        p.sendMessage(usingProxy_Player.replace("<address>", playerip).replace("<name>", player.getName()));
                    }
                }
                if (Path_Proxy.getConfig().getBoolean("proxy.autoban-mode")) {
                    for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.stop-proxy.ban-message")) {
                        event.disallow(PlayerLoginEvent.Result.KICK_BANNED, ChatColor.translateAlternateColorCodes('&', kick));
                    }
                    BanList banList = Bukkit.getBanList(BanList.Type.IP);
                    banList.addBan(playerip, Path_Proxy.getConfig().getString("proxy.visible-reason"), (Date) null, "Helper");
                } else {
                    for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.stop-proxy.kick-message")) {
                        event.disallow(PlayerLoginEvent.Result.KICK_BANNED, ChatColor.translateAlternateColorCodes('&', kick));
                    }
                }
            } else {
                var12 = Bukkit.getOnlinePlayers().iterator();

                while(var12.hasNext()) {
                    p = (Player)var12.next();
                    if (notifyop && p.isOp()) {
                        p.sendMessage(noProxy_Player.replace("<address>", playerip).replace("<name>", player.getName()));
                    }
                }

                Console.message(noProxy_Console.replace("<address>", playerip).replace("<name>", player.getName()));
            }
        }

    }

    public static boolean isBad(String playerip) {
        if (!playerip.equals("127.0.0.1") && !playerip.matches("192\\.168\\.[01]{1}\\.[0-9]{1,3}")) {
            try {
                URL url = new URL(Path_Proxy.getConfig().getString("proxy-url") + playerip);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String str = "";
                if ((str = br.readLine()) != null) {
                    if (str.contains("yes")) {
                        return true;
                    }

                    return false;
                }
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            return false;
        } else {
            return false;
        }
    }

}
