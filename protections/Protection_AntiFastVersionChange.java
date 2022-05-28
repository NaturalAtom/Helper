package eu.mixeration.protections;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.NotWorking_Path_AntiFastVersionChange;
import eu.mixeration.helper.paths.Path_Config;
import eu.mixeration.helper.module.helper.helper$modules.Module_Countdown;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Protection_AntiFastVersionChange implements Listener {
    public Protection_AntiFastVersionChange(Helper helper) {}

    @Deprecated
    @EventHandler
    public void login(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        int customDelay = NotWorking_Path_AntiFastVersionChange.getConfig().getInt("anti-fast-version-change.rejoin-delay");
        if (!Lists_And_Maps.__antiFastVersionChange$1.get(player.getUniqueId()).equalsIgnoreCase(String.valueOf(Helper.get().protocolManager.getProtocolVersion(player)))) {
            if (!((Lists_And_Maps.__antiFastVersionChange$0.get(player.getUniqueId())) && (Lists_And_Maps.__antiFastVersionChange$0.get(player.getUniqueId()) == null))) {
                if (Lists_And_Maps.__antiFastVersionChange.get(player.getUniqueId()) == null) {
                    Lists_And_Maps.__antiFastVersionChange.put(player.getUniqueId(), "antiFastVersionChange");
                    Lists_And_Maps.__antiFastVersionChange$0.put(player.getUniqueId(), true);
                    Lists_And_Maps.__antiFastVersionChange$1.put(player.getUniqueId(), String.valueOf(Helper.get().protocolManager.getProtocolVersion(player)));
                    Module_Countdown.startTimer(player, customDelay);
                    if (!(Module_Countdown.booleanID.get(player.getUniqueId()))) {
                        for (String help : NotWorking_Path_AntiFastVersionChange.getConfig().getStringList("anti-fast-version-change.reasons.please-wait")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', help.replace("<remaining>", String.valueOf(Module_Countdown.timeMap))));
                        }
                        if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.fast-version-change")) {
                            Console.message("&b{ &9Helper | &bSuccess | &3Anti Fast Version Change &b} &7Suspect &f&o" + player.getName() + "&7 kicked from server, Reason: Fast Version Change.");
                        }
                    } else {
                        Entity.send(player, NotWorking_Path_AntiFastVersionChange.getConfig().getString("anti-fast-version-change.messages.joined").replace("<last-version>", Lists_And_Maps.__antiFastVersionChange$1.get(player.getUniqueId())));
                    }
                }
            }
        } else {
            Entity.send(player, NotWorking_Path_AntiFastVersionChange.getConfig().getString("anti-fast-version-change.messages.joined").replace("<last-version>", Lists_And_Maps.__antiFastVersionChange$1.get(player.getUniqueId())));
        }
    }
}
