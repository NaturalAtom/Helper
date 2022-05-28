package eu.mixeration.essentials.commands.staff;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.paths.Path_Essentials;
import eu.mixeration.helper.paths.Path_Locale;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {
    public Broadcast(Helper helper) {}

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (player.hasPermission(Path_Essentials.getConfig().getString("essentials.custom-permissions.broadcast"))) {
                if (command.getName().equalsIgnoreCase("Broadcast")) {
                    if (args.length <= 0) {
                        Locale.helpMessage(player, "help-messages.usage.staff*broadcast");
                    } else if (args.length >= 2) {
                        if (args[0].equalsIgnoreCase("title")) {
                            StringBuilder str = new StringBuilder();
                            for (int i = 1; i < args.length; i++) {
                                str.append(args[i]).append(" ");
                            }
                            String message = str.toString();
                            if (Bukkit.getServer().getOnlinePlayers().size() > 0) {
                                for (Player allPlayers : Bukkit.getOnlinePlayers()) {
                                    int fadein = Path_Essentials.getConfig().getInt("essentials.broadcast.type.title.fade-in");
                                    int stay = Path_Essentials.getConfig().getInt("essentials.broadcast.type.title.stay");
                                    int fadeout = Path_Essentials.getConfig().getInt("essentials.broadcast.type.title.fade-out");
                                    String title = Path_Essentials.getConfig().getString("essentials.broadcast.type.title.title");
                                    title = ChatColor.translateAlternateColorCodes('&', title);
                                    allPlayers.sendTitle(title, String.valueOf(message), fadein, stay, fadeout);
                                }
                            } else {
                                Entity.send(player, Path_Locale.getConfig().getString("messages.no-player-in-server"));
                            }
                        } else if (args[0].equalsIgnoreCase("chat")) {
                            StringBuilder str = new StringBuilder();
                            for (int i = 1; i < args.length; i++) {
                                str.append(args[i]).append(" ");
                            }
                            String message = str.toString();
                            String title = Path_Essentials.getConfig().getString("essentials.broadcast.type.chat.prefix");
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', title) + ChatColor.translateAlternateColorCodes('&', String.valueOf(message)));
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.staff*broadcast");
                        }
                    } else {
                        Locale.helpMessage(player, "help-messages.usage.staff*broadcast");
                    }
                }
            } else {
                Entity.send(player, Path_Locale.getConfig().getString("messages.no-permission"));
            }
        } else {
            if (command.getName().equalsIgnoreCase("Broadcast")) {
                if (args.length <= 0) {
                    Locale.consoleMessage( "help-messages.usage.staff*broadcast");
                } else if (args.length >= 2) {
                    if (args[0].equalsIgnoreCase("title")) {
                        StringBuilder str = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            str.append(args[i]).append(" ");
                        }
                        String message = str.toString();
                        if (Bukkit.getServer().getOnlinePlayers().size() > 0) {
                            for (Player allPlayers : Bukkit.getOnlinePlayers()) {
                                int fadein = Path_Essentials.getConfig().getInt("essentials.broadcast.type.title.fade-in");
                                int stay = Path_Essentials.getConfig().getInt("essentials.broadcast.type.title.stay");
                                int fadeout = Path_Essentials.getConfig().getInt("essentials.broadcast.type.title.fade-out");
                                String title = Path_Essentials.getConfig().getString("essentials.broadcast.type.title.title");
                                title = ChatColor.translateAlternateColorCodes('&', title);
                                allPlayers.sendTitle(title, String.valueOf(message), fadein, stay, fadeout);
                            }
                        } else {
                            Console.message(Path_Locale.getConfig().getString("messages.no-player-in-server"));
                        }
                    } else if (args[0].equalsIgnoreCase("chat")) {
                        StringBuilder str = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            str.append(args[i]).append(" ");
                        }
                        String message = str.toString();
                        String title = Path_Essentials.getConfig().getString("essentials.broadcast.type.chat.prefix");
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', title) + ChatColor.translateAlternateColorCodes('&', String.valueOf(message)));
                    } else {
                        Locale.consoleMessage( "help-messages.usage.staff*broadcast");
                    }
                } else {
                    Locale.consoleMessage("help-messages.usage.staff*broadcast");
                }
            }
        }
        return true;
    }
}
