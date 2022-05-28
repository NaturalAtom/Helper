package eu.mixeration.essentials.commands.player;

import eu.mixeration.$mixeration.PermissionHandler;
import eu.mixeration.essentials.commands.Ess$Locale;
import eu.mixeration.essentials.modules.Ess$GameMode;
import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Player_GameMode implements CommandExecutor {
    public Player_GameMode(Helper helper) {}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission(PermissionHandler.getEssentialsPermPath("gamemode"))){
                if(command.getName().equalsIgnoreCase("gamemode")) {
                    if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
                        Ess$Locale.essentialsHelpMessage(player, "essentials.commands.gamemode.help");
                    } else if(args.length == 2) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if(target == null) {
                            Entity.send(player, Ess$Locale.GAMEMODE_NOTONLINE.replace("<player>", args[1]));
                        } else {
                            Entity.send(player, Ess$Locale.GAMEMODE_CHANGED_FOR.replace("<gamemode>", args[0]).replace("<player>", args[1]));
                            if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
                                Ess$GameMode.changeGamemode(target, "creative");
                            } else if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
                                Ess$GameMode.changeGamemode(target, "survival");
                            } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
                                Ess$GameMode.changeGamemode(target, "adventure");
                            } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
                                Ess$GameMode.changeGamemode(target, "spectator");
                            } else {
                                Ess$Locale.essentialsHelpMessage(player, "essentials.commands.gamemode.help");
                            }
                        }
                    } else {
                        if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
                            Ess$GameMode.changeGamemode(player, "creative");
                        } else if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
                            Ess$GameMode.changeGamemode(player, "survival");
                        } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
                            Ess$GameMode.changeGamemode(player, "adventure");
                        } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
                            Ess$GameMode.changeGamemode(player, "spectator");
                        } else {
                            Ess$Locale.essentialsHelpMessage(player, "essentials.commands.gamemode.help");
                        }
                    }
                }
            } else {
                Entity.send(player, Locale.NOPERMISSION);
            }
        } else {
            if(command.getName().equalsIgnoreCase("gamemode")) {
                if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
                    Console.listMessageForEssentials("essentials.commands.gamemode.help");
                } else if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        Console.message(Ess$Locale.GAMEMODE_NOTONLINE.replace("<player>", args[1]));
                    } else {
                        Console.message(Ess$Locale.GAMEMODE_CHANGED_FOR.replace("<player>", args[1]));
                        if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
                            Ess$GameMode.changeGamemode(target, "creative");
                        } else if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
                            Ess$GameMode.changeGamemode(target, "survival");
                        } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
                            Ess$GameMode.changeGamemode(target, "adventure");
                        } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
                            Ess$GameMode.changeGamemode(target, "spectator");
                        } else {
                            Console.listMessageForEssentials("essentials.commands.gamemode.help");
                        }
                    }
                }
            }
        }
        return true;
    }
}
