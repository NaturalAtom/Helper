package eu.mixeration.helper.commands;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.module.server.Server_Fork_Version;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelperServer implements CommandExecutor {
    public HelperServer(Helper helper) {}

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Server_Fork_Version.get().equalsIgnoreCase("paper$mxr")) {
            if(sender instanceof Player) {
                if(command.getName().equalsIgnoreCase("HelperServer")) {
                    if(((Player) sender).hasPermission("helper.server")) {
                        if (args.length == 0 || args[0].equalsIgnoreCase("server")) {
                            Server server = Bukkit.getServer();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHelperServer | &bPAPER : &fTPS &b#" + server.getTPS().length));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Port : &b" + server.getPort()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Address : &b" + server.getIp()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Version : &b" + server.getVersion()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Bukkit Version : &b" + server.getBukkitVersion()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Max player : &b" + server.getMaxPlayers()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Remaining online slot : &b" + (server.getMaxPlayers() - server.getOnlinePlayers().size())));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Online : &b" + server.getOnlinePlayers().size()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Ticks per animals spawn : &b" + server.getTicksPerAnimalSpawns()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Ticks per monsters spawn : &b" + server.getTicksPerMonsterSpawns()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- View distance : &b" + server.getViewDistance()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            try {
                                Runtime r = Runtime.getRuntime();
                                float usedMemory = (r.totalMemory() - r.freeMemory()) / 1048576F;
                                int usedMemoryPercentage = (int) ((100 * usedMemory) / (r.maxMemory() / 1048576));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- Ram ? &fUsed " + (int) usedMemory + "§b/§f Total " + (r.totalMemory() / 1048576) + "§b/§f Maximum " + (r.maxMemory() / 1048576) + "§bMB (§f" + usedMemoryPercentage + "§b%)"));
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHelperServer | &7I cant found any ram information..."));
                            }
                        }
                    } else {
                        Entity.send(((Player) sender).getPlayer(), Locale.NOPERMISSION);
                    }
                }
            } else {
                Console.message(Locale.ONLYINGAME);
            }
        } else if(Server_Fork_Version.get().equalsIgnoreCase("spigot$mxr")) {
            if(sender instanceof Player) {
                if(command.getName().equalsIgnoreCase("HelperServer")) {
                    if(((Player) sender).hasPermission("helper.server")) {
                        if (args.length == 0) {
                            Server server = Bukkit.getServer();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHelperServer | &eSPIGOT &fTPS &b#" + server.getTPS().length));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Port : &b" + server.getPort()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Address : &b" + server.getIp()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Version : &b" + server.getVersion()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Bukkit Version : &b" + server.getBukkitVersion()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Max player : &b" + server.getMaxPlayers()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Remaining online slot : &b" + (server.getMaxPlayers() - server.getOnlinePlayers().size())));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Online : &b" + server.getOnlinePlayers().size()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Ticks per animals spawn : &b" + server.getTicksPerAnimalSpawns()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Ticks per monsters spawn : &b" + server.getTicksPerMonsterSpawns()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- View distance : &b" + server.getViewDistance()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            try {
                                Runtime r = Runtime.getRuntime();
                                float usedMemory = (r.totalMemory() - r.freeMemory()) / 1048576F;
                                int usedMemoryPercentage = (int) ((100 * usedMemory) / (r.maxMemory() / 1048576));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- Ram ? &fUsed " + (int) usedMemory + "§b/§f Total " + (r.totalMemory() / 1048576) + "§b/§f Maximum " + (r.maxMemory() / 1048576) + "§bMB (§f" + usedMemoryPercentage + "§b%)"));
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHelperServer | &7I cant found any ram information..."));
                            }
                        }
                    } else {
                        Entity.send(((Player) sender).getPlayer(), Locale.NOPERMISSION);
                    }
                }
            } else {
                Console.message(Locale.ONLYINGAME);
            }
        } else {
            if(sender instanceof Player) {
                if(command.getName().equalsIgnoreCase("HelperServer")) {
                    if(((Player) sender).hasPermission("helper.server")) {
                        if (args.length == 0) {
                            Server server = Bukkit.getServer();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHelperServer | &fTPS &b#" + server.getTPS().length));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Port : &b" + server.getPort()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Address : &b" + server.getIp()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Version : &b" + server.getVersion()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Bukkit Version : &b" + server.getBukkitVersion()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Max player : &b" + server.getMaxPlayers()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Remaining online slot : &b" + (server.getMaxPlayers() - server.getOnlinePlayers().size())));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Online : &b" + server.getOnlinePlayers().size()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Ticks per animals spawn : &b" + server.getTicksPerAnimalSpawns()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Ticks per monsters spawn : &b" + server.getTicksPerMonsterSpawns()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- View distance : &b" + server.getViewDistance()));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                            try {
                                Runtime r = Runtime.getRuntime();
                                float usedMemory = (r.totalMemory() - r.freeMemory()) / 1048576F;
                                int usedMemoryPercentage = (int) ((100 * usedMemory) / (r.maxMemory() / 1048576));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- Ram ? &fUsed " + (int) usedMemory + "§b/§f Total " + (r.totalMemory() / 1048576) + "§b/§f Maximum " + (r.maxMemory() / 1048576) + "§bMB (§f" + usedMemoryPercentage + "§b%)"));
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHelperServer | &7I cant found any ram information..."));
                            }
                        }
                    } else {
                        Entity.send(((Player) sender).getPlayer(), Locale.NOPERMISSION);
                    }
                }
            } else {
                Console.message(Locale.ONLYINGAME);
            }
        }
        return true;
    }
}
