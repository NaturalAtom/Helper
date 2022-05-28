package eu.mixeration.essentials.commands.player;

import eu.mixeration.$mixeration.Mixeration_Manager;
import eu.mixeration.essentials.commands.Ess$Locale;
import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.paths.Path_Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Player_Ping implements CommandExecutor {
    public Player_Ping(Helper helper) {}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("ping")) {
                Player player = ((Player) sender).getPlayer();
                if (Path_Helper.getConfig().getString("server-version").equalsIgnoreCase("paper$mxr")) {
                    if (args.length == 0) {
                        Entity.send(((Player) sender).getPlayer(), Ess$Locale.YOUR_PING.replace("<ping>", String.valueOf(player.getPing())));
                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target == null) {
                            Entity.send(((Player) sender).getPlayer(), Ess$Locale.PING_NOT_ONLINE.replace("<player>", (args[0].toString())));
                        } else {
                            Entity.send(((Player) sender).getPlayer(), Ess$Locale.PLAYERS_PING.replace("<player>", player.getName()).replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                        }
                    } else {
                        Entity.send(((Player) sender).getPlayer(), Ess$Locale.YOUR_PING.replace("<ping>", String.valueOf(player.getPing())));
                    }
                } else if (Path_Helper.getConfig().getString("server-version").equalsIgnoreCase("spigot$mxr")) {
                    if (args.length == 0) {
                        Entity.send(((Player) sender).getPlayer(), Ess$Locale.YOUR_PING.replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target == null) {
                            Entity.send(((Player) sender).getPlayer(), Ess$Locale.PING_NOT_ONLINE.replace("<player>", (args[0].toString())));
                        } else {
                            Entity.send(((Player) sender).getPlayer(), Ess$Locale.PLAYERS_PING.replace("<player>", (target.getName().toString())).replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                        }
                    } else {
                        Entity.send(((Player) sender).getPlayer(), Ess$Locale.YOUR_PING.replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                    }
                } else {
                    if (args.length == 0) {
                        Entity.send(((Player) sender).getPlayer(), Ess$Locale.YOUR_PING.replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target == null) {
                            Entity.send(((Player) sender).getPlayer(), Ess$Locale.PING_NOT_ONLINE.replace("<player>", (args[0].toString())));
                        } else {
                            Entity.send(((Player) sender).getPlayer(), Ess$Locale.PLAYERS_PING.replace("<player>", (target.getName().toString())).replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                        }
                    } else {
                        Entity.send(((Player) sender).getPlayer(), Ess$Locale.YOUR_PING.replace("<ping>", String.valueOf(Mixeration_Manager.getPing(((Player) sender).getPlayer()))));
                    }
                }
            }
        } else {
            Console.message(Locale.ONLYINGAME);
        }
        return true;
    }
}
