package eu.mixeration.helper.events;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.paths.Path_Bank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerRegisterBankEvent implements Listener {
    public PlayerRegisterBankEvent(Helper helper) {}

    @EventHandler
    public void playerRegisterEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(Path_Bank.getConfig().getString("user-data." + player.getUniqueId().toString()) == null) {
            Path_Bank.getConfig().set("user-data." + player.getUniqueId().toString() + ".bank-owner", player.getName());
            Path_Bank.getConfig().set("user-data." + player.getUniqueId().toString() + ".bank-balance", 0);
            Path_Bank.saveConfig();
        }
    }

}
