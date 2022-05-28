package eu.mixeration.essentials.commands.creator;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.paths.Path_Essentials;
import eu.API_Vault;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandCreatorListener implements Listener {

    public CommandCreatorListener(Helper helper) {}



    @Deprecated
    @EventHandler(
            priority = EventPriority.LOWEST
    )
    public void creator(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().split(" ")[0];
        for (String commands : Path_Essentials.getConfig().getConfigurationSection("essentials.command-creator").getKeys(false)) {
            String rcmd = Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".trigger");
            String type = Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".type");
            if (command.equalsIgnoreCase("/" + rcmd)) {
                if (type.equalsIgnoreCase("title-message")) {
                    String msg = ChatColor.translateAlternateColorCodes('&', Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".message.title-message.title"));
                    String subtitle = ChatColor.translateAlternateColorCodes('&', Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".message.title-message.sub-title"));
                    int fadein = Path_Essentials.getConfig().getInt("essentials.command-creator." + commands + ".message.title-message.settings.fade-in");
                    int stay = Path_Essentials.getConfig().getInt("essentials.command-creator." + commands + ".message.title-message.settings.stay");
                    int fadeout = Path_Essentials.getConfig().getInt("essentials.command-creator." + commands + ".message.title-message.settings.fade-out");
                    player.sendTitle(msg, subtitle, fadein, stay, fadeout);
                } else if (type.equalsIgnoreCase("chat-message")) {
                    for (String messages : Path_Essentials.getConfig().getStringList("essentials.command-creator." + commands + ".message.chat-message")) {
                        messages = messages.replace("<world>", player.getWorld().getName())
                                .replace("<name>", player.getName())
                                .replace("<money>", String.valueOf(API_Vault.econ.getBalance(player)))
                                .replace("<food>", String.valueOf(player.getFoodLevel()))
                                .replace("<health>", String.valueOf(player.getHealth()))
                                .replace("<bed-loc>", String.valueOf(player.getBedSpawnLocation()));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
                    }
                } else if (type.equalsIgnoreCase("aliases")) {
                    if (Path_Essentials.getConfig().getBoolean("essentials.command-creator." + commands + ".modules.permission.ask")) {
                        if (player.hasPermission(Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".modules.permission.perm-name"))) {
                            if (Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".modules.commands.mode").equalsIgnoreCase("single")) {
                                player.performCommand(Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".perform-command.single"));
                            } else if (Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".modules.commands.mode").equalsIgnoreCase("multiple")) {
                                for (String perform : Path_Essentials.getConfig().getStringList("essentials.command-creator." + commands + ".perform-command.multiple")) {
                                    player.performCommand(perform);
                                }
                            }
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".modules.permissions.no-perm")));
                        }
                    } else {
                        if (Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".modules.commands.mode").equalsIgnoreCase("single")) {
                            player.performCommand(Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".perform-command.single"));
                        } else if (Path_Essentials.getConfig().getString("essentials.command-creator." + commands + ".modules.commands.mode").equalsIgnoreCase("multiple")) {
                            for (String perform : Path_Essentials.getConfig().getStringList("essentials.command-creator." + commands + ".perform-command.multiple")) {
                                player.performCommand(perform);
                            }
                        }
                    }
                }
                event.setCancelled(true );
            }
        }
        return;
    }
}
