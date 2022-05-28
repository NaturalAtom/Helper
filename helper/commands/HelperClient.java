package eu.mixeration.helper.commands;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.Path_Client;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class HelperClient implements CommandExecutor {
    public HelperClient(Helper helper) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player user = (Player)sender;
            if (command.getName().equalsIgnoreCase("HelperClient")) {
                if (user.hasPermission(Path_Client.getConfig().getString("helper-client.admin"))) {
                    if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                        Locale.helpMessage(user, "help-messages.usage.helper*client-selector");
                        return true;
                    }else if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("notify")) {
                            if (Lists_And_Maps.notify_client.get(user.getUniqueId()) == null) {
                                Lists_And_Maps.notify_client.put(user.getUniqueId(), "Enable");
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.notify-options.enable")));
                            } else {
                                Lists_And_Maps.notify_client.remove(user.getUniqueId());
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.notify-options.disable")));
                            }
                            return true;
                        }else if (args[0].equalsIgnoreCase("reload")) {
                            Path_Client.reloadConfig();
                            user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.reload-successful")));
                            return true;
                        } else {
                            Locale.helpMessage(user, "help-messages.usage.helper*client-selector");
                        }
                    } else if(args.length == 3){
                        if(args[0].equalsIgnoreCase("addclient")) {
                            if (args[1].equalsIgnoreCase("blacklist")) {
                                List list = Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.blacklist.channels");
                                list.add(args[2]);
                                Path_Client.getConfig().set("helper-client.settings.mc-brand.blacklist.channels", list);
                                Path_Client.saveConfig();
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.client-add-to-blacklist").replace("<client>", args[2])));
                            } else if (args[1].equalsIgnoreCase("whitelist")) {
                                List list = Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.whitelist.channels");
                                list.add(args[2]);
                                Path_Client.getConfig().set("helper-client.settings.mc-brand.whitelist.channels", list);
                                Path_Client.saveConfig();
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.client-add-to-whitelist").replace("<client>", args[2])));
                            } else {
                                Locale.helpMessage(user, "help-messages.usage.helper*client-selector");

                            }
                        } else if(args[0].equalsIgnoreCase("removeclient")) {
                            if (args[1].equalsIgnoreCase("blacklist")) {
                                List list = Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.blacklist.channels");
                                list.remove(args[2]);
                                Path_Client.getConfig().set("helper-client.settings.mc-brand.blacklist.channels", list);
                                Path_Client.saveConfig();
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.client-removed-from-blacklist").replace("<client>", args[2])));
                            } else if (args[1].equalsIgnoreCase("whitelist")) {
                                List list = Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.whitelist.channels");
                                list.remove(args[2]);
                                Path_Client.getConfig().set("helper-client.settings.mc-brand.whitelist.channels", list);
                                Path_Client.saveConfig();
                                user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.client-removed-from-whitelist").replace("<client>", args[2])));
                            } else {
                                Locale.helpMessage(user, "help-messages.usage.helper*client-selector");

                            }
                        } else {
                            Locale.helpMessage(user, "help-messages.usage.helper*client-selector");
                        }
                    }
                } else {
                    user.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.no-permission")));
                }
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.client-selector.only-players")));
        }
        return true;
    }
}
