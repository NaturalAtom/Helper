package eu.mixeration.essentials.commands.player;

import eu.mixeration.essentials.commands.Ess$Locale;
import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.paths.Path_Essentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Player_Manager implements CommandExecutor {
    public Player_Manager(Helper helper) {
    }

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (command.getName().equalsIgnoreCase("Manager")) {
                if (args.length == 0) {
                    for(String essentials : Path_Essentials.getConfig().getStringList("essentials.commands.manager.help")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', essentials));
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("hide")) {
                        if (args[1].equalsIgnoreCase("*") || args[1].equalsIgnoreCase("all")) {
                            for (Player allPlayers : Bukkit.getOnlinePlayers()) {
                                player.hidePlayer(allPlayers);
                                allPlayers.hidePlayer(player);
                                Entity.send(player, Ess$Locale.HIDEALL_SUCCES);
                            }
                        } else {
                            Player player1 = Bukkit.getPlayer(args[1]);
                            if (player1 == null) {
                                Entity.send(player, Ess$Locale.HIDE_NOTONLINE);
                            } else if (args[1].equalsIgnoreCase(player.getName())) {
                                Entity.send(player, Ess$Locale.HIDE_NOTYOURSELF);
                            } else {
                                player.hidePlayer(player1);
                                player1.hidePlayer(player);
                                Entity.send(player, Ess$Locale.HIDE_SUCCES.replace("<player>", player1.getName()));
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("show")) {
                        if (args[1].equalsIgnoreCase("*") || args[1].equalsIgnoreCase("all")) {
                            for (Player allPlayers : Bukkit.getOnlinePlayers()) {
                                player.canSee(allPlayers);
                                allPlayers.canSee(player);
                                Entity.send(player, Ess$Locale.SHOWALL_SUCCES);
                            }
                        } else {
                            Player player1 = Bukkit.getPlayer(args[1]);
                            if (player1 == null) {
                                Entity.send(player, Ess$Locale.SHOW_NOTONLINE);
                            } else if (args[1].equalsIgnoreCase(player.getName())) {
                                Entity.send(player, Ess$Locale.SHOW_NOTYOURSELF);
                            } else {
                                player.canSee(player1);
                                player1.canSee(player);
                                Entity.send(player, Ess$Locale.SHOW_SUCCES.replace("<player>", player1.getName()));
                            }
                        }
                    } else {
                        for(String essentials : Path_Essentials.getConfig().getStringList("essentials.commands.manager.help")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', essentials));
                        }
                    }
                } else {
                    for(String essentials : Path_Essentials.getConfig().getStringList("essentials.commands.manager.help")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', essentials));
                    }
                }
            }
        } else {
            Console.message(Locale.ONLYINGAME);
        }
        return true;
    }
}
