package eu.mixeration.helper.commands;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.paths.Path_Essentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelperEssentials implements CommandExecutor {
    public HelperEssentials(Helper helper) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission("helper.essentials.admin")) {
                if(command.getName().equalsIgnoreCase("HelperEssentials")) {
                    if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
                        for(String essentials : Path_Essentials.getConfig().getStringList("essentials.commands.helper-essentials.help")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', essentials));
                        }
                    } else if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("reload")) {
                            Path_Essentials.saveConfig();
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Essentials.getConfig().getString("essentials.commands.helper-essentials.reloaded")));
                        }
                    } else {
                        for(String essentials : Path_Essentials.getConfig().getStringList("essentials.commands.helper-essentials.help")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', essentials));
                        }
                    }
                }
            } else {
                Entity.send(player, Locale.NOPERMISSION);
            }
        } else {
            Console.message(Locale.ONLYINGAME);
        }

        return true;
    }
}
