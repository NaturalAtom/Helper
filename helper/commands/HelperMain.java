package eu.mixeration.helper.commands;

import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.helper.helper$modules.Module_Reload;
import eu.mixeration.helper.module.helper.register.AboutValues;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.module.pluginator.Pluginator_Modules;
import eu.mixeration.helper.paths.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HelperMain implements CommandExecutor {
    public HelperMain(eu.mixeration.helper.Helper helper) {}

    @Deprecated
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (player.hasPermission("helper.admin")) {
                if (command.getName().equalsIgnoreCase("Helper")) {
                    if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                        Locale.helpMessage(player, "help-messages.command.helper");
                    } else if(args[0].equalsIgnoreCase("reload")) {
                        Module_Reload.mixeration();
                        Entity.send(player, Locale.RELOADED);
                    } else if(args[0].equalsIgnoreCase("maintenance")) {
                        if(args.length == 2) {
                            if(args[1].equalsIgnoreCase("list")) {
                                Entity.send(player, Locale.HMT_LIST_TITLE);
                                for (String getWhitelist : Path_Maintenancer.getConfig().getStringList("maintenancer.whitelist")) {
                                    Entity.send(player, (Locale.HMT_LIST_VALUE) + getWhitelist);
                                }
                            } else if(args[1].equalsIgnoreCase("toggle")) {
                                if(Lists_And_Maps.maintenance.get("server")) {
                                    Entity.send(player, Locale.HMT_DISABLED);
                                    Lists_And_Maps.maintenance.put("server", false);
                                } else {
                                    Entity.send(player, Locale.HMT_ENABLED);
                                    Lists_And_Maps.maintenance.put("server", true);
                                    if(Path_Maintenancer.getConfig().getBoolean("maintenancer.kick-players-when-maintenance-is-enable")) {
                                        for (Player players : Bukkit.getOnlinePlayers()) {
                                            if(!players.hasPermission(Path_Maintenancer.getConfig().getString("maintenancer.bypass-permission"))) {
                                                for (String kick : Path_Maintenancer.getConfig().getStringList("maintenancer.kick-reason")) {
                                                    players.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                                                }
                                            } else {
                                                Entity.send(player, Locale.HMT_JWHMT);
                                            }
                                        }
                                    }
                                }
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*maintenance");
                            }
                        } else if(args.length == 3) {
                            if(args[1].equalsIgnoreCase("add")) {
                                List<String> hmt = Path_Maintenancer.getConfig().getStringList("maintenancer.whitelist");
                                String user = args[2].toString();
                                if(Path_Maintenancer.getConfig().getStringList("maintenancer.whitelist").contains(user)) {
                                    Entity.send(player, Locale.HMT_ALREADY_IN_LIST.replace("<user>", user));
                                } else {
                                    hmt.add(user);
                                    Path_Maintenancer.getConfig().set("maintenancer.whitelist", hmt);
                                    Path_Maintenancer.saveConfig();
                                    Entity.send(player, Locale.HMT_ADDED.replace("<user>", user));
                                }
                            } else if(args[1].equalsIgnoreCase("remove")) {
                                List<String> hmt = Path_Maintenancer.getConfig().getStringList("maintenancer.whitelist");
                                String user = args[2].toString();
                                if(!(Path_Maintenancer.getConfig().getStringList("maintenancer.whitelist").contains(user))) {
                                    Entity.send(player, Locale.HMT_NOT_IN_LIST.replace("<user>", user));
                                } else {
                                    hmt.remove(user);
                                    Path_Maintenancer.getConfig().set("maintenancer.whitelist", hmt);
                                    Path_Maintenancer.saveConfig();
                                    Entity.send(player, Locale.HMT_REMOVED.replace("<user>", user));
                                }
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*maintenance-add?remove");
                            }
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.helper*maintenance");
                        }
                    } else if(args[0].equalsIgnoreCase("operator")) {
                        if(args.length == 2) {
                            if(args[1].equalsIgnoreCase("list")) {
                                Entity.send(player, Locale.OP_LIST_TITLE);
                                for(String ops : Path_Operator.getConfig().getStringList("operators.users")) {
                                    Entity.send(player, (Locale.OP_LIST_VALUE) + ops);
                                }
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*operator");
                            }
                        } else if(args.length == 3) {
                            List<String> ops = Path_Operator.getConfig().getStringList("operators.users");
                            if(args[1].equalsIgnoreCase("add")) {
                                String user = args[2].toString();
                                if(Path_Maintenancer.getConfig().getStringList("operators.users").contains(user)) {
                                    Entity.send(player, Locale.OP_ALREADY_IN_LIST.replace("<user>", user));
                                } else {
                                    ops.add(user);
                                    Path_Maintenancer.getConfig().set("operators.users", ops);
                                    Path_Maintenancer.saveConfig();
                                    Entity.send(player, Locale.OP_ADDED.replace("<user>", user));
                                }
                            } else if(args[1].equalsIgnoreCase("remove")) {
                                String user = args[2].toString();
                                if(!(Path_Maintenancer.getConfig().getStringList("operators.users").contains(user))) {
                                    Entity.send(player, Locale.OP_NOT_IN_LIST.replace("<user>", user));
                                } else {
                                    ops.remove(user);
                                    Path_Maintenancer.getConfig().set("operators.users", ops);
                                    Path_Maintenancer.saveConfig();
                                    Entity.send(player, Locale.OP_REMOVED.replace("<user>", user));
                                }
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*operator-add?remove");
                            }
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.helper*operator");
                        }
                    } else if(args[0].equalsIgnoreCase("pluginator")) {
                        if(args.length == 2) {
                            if(args[1].equalsIgnoreCase("reloadall")) {
                                if(Bukkit.getPluginManager().getPlugins().length > Path_Pluginator.getConfig().getInt("pluginator.reload-all.max-plugin-size")) {
                                    Entity.send(player, Locale.PLUGINATOR_RELOAD_BLOCKED);
                                } else {
                                    Pluginator_Modules.reloadAll();
                                    Entity.send(player, Locale.PLUGINATOR_RELOAD_ALL);
                                }
                            } else if(args[1].equalsIgnoreCase("disableall")) {
                                Pluginator_Modules.disableAll();
                                Entity.send(player, Locale.PLUGINATOR_DISABLED_ALL);
                            } else if(args[1].equalsIgnoreCase("enableall")) {
                                if(Bukkit.getPluginManager().getPlugins().length > Path_Pluginator.getConfig().getInt("pluginator.reload-all.max-plugin-size")) {
                                    Entity.send(player, Locale.PLUGINATOR_ENABLE_BLOCKED);
                                } else {
                                    Pluginator_Modules.enableAll();
                                    Entity.send(player, Locale.PLUGINATOR_ENABLE_ALL);
                                }
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*pluginator");
                            }

                        } else if(args.length == 3) {
                            Plugin plugin = Bukkit.getPluginManager().getPlugin(args[2]);
                            if(args[1].equalsIgnoreCase("load")) {
                                if(!(plugin == null)) {
                                    Pluginator_Modules.load(args[2]);
                                    Entity.send(player, Locale.PLUGINATOR_LOADED.replace("<plugin>", args[2]));
                                } else {
                                    Entity.send(player, Locale.PLUGINATOR_CANNOTFIND);
                                }
                            } else if(args[1].equalsIgnoreCase("unload")) {
                                if(!(plugin == null)) {
                                    Pluginator_Modules.unload(plugin);
                                    Entity.send(player, Locale.PLUGINATOR_UNLOADED.replace("<plugin>", args[2]));
                                } else {
                                    Entity.send(player, Locale.PLUGINATOR_CANNOTFIND);
                                }
                            } else if(args[1].equalsIgnoreCase("disable")) {
                                if(!(plugin == null)) {
                                    Pluginator_Modules.disable(plugin);
                                    Entity.send(player, Locale.PLUGINATOR_DISABLED.replace("<plugin>", args[2]));
                                } else {
                                    Entity.send(player, Locale.PLUGINATOR_CANNOTFIND);
                                }
                            } else if(args[1].equalsIgnoreCase("enable")) {
                                if(!(plugin == null)) {
                                    Pluginator_Modules.enable(plugin);
                                    Entity.send(player, Locale.PLUGINATOR_ENABLED.replace("<plugin>", args[2]));
                                } else {
                                    Entity.send(player, Locale.PLUGINATOR_CANNOTFIND);
                                }
                            } else if(args[1].equalsIgnoreCase("reload")) {
                                if(!(plugin == null)) {
                                Pluginator_Modules.reload(plugin);
                                Entity.send(player, Locale.PLUGINATOR_RELOADED.replace("<plugin>", args[2]));
                                } else {
                                    Entity.send(player, Locale.PLUGINATOR_CANNOTFIND);
                                }
                            }
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.helper*pluginator");
                        }
                    } else if(args[0].equalsIgnoreCase("proxy")) {
                        if(args.length == 2) {
                            if(args[1].equalsIgnoreCase("getlink")) {
                                Entity.send(player, Locale.PROXY_GETLINK.replace("<link>", Path_Proxy.getConfig().getString("proxy-url")));
                            } else if(args[0].equalsIgnoreCase("resetlink")) {
                                Path_Proxy.getConfig().set("proxy-url", "https://stpprx2server.altervista.org/noproxy.php?ip=");
                                Path_Proxy.saveConfig();
                                Entity.send(player, Locale.PROXY_RESETED.replace("<link>", "https://stpprx2server.altervista.org/noproxy.php?ip="));
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*proxy");
                            }
                        } else if(args.length == 3) {
                            String newlink = args[2];
                            if(args[1].equalsIgnoreCase("changelink")) {
                                Path_Proxy.getConfig().set("proxy-url", newlink);
                                Path_Proxy.saveConfig();
                                Entity.send(player, Locale.PROXY_LINK_CHANGED.replace("<link>", newlink));
                            } else {
                                Locale.helpMessage(player, "help-messages.usage.helper*proxy");
                            }
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.helper*proxy");
                        }
                    } else if(args[0].equalsIgnoreCase("channels")) {
                        if (Path_Client.getConfig().getString("helper-client.settings.mc-brand.channel-mode", "blacklist").equals("blacklist")) {
                            Entity.send(player, "&9&lHelperChannels | &fBlacklisted client names");
                            for (String blackList : Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.blacklist.channels")) {
                                Entity.send(player, blackList);
                            }
                        } else if (Path_Client.getConfig().getString("helper-client.settings.mc-brand.channel-mode", "blacklist").equals("blacklist")) {
                            Entity.send(player, "&9&lHelperChannels | &fWhitelisted client names");
                            for (String whiteList : Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.whitelist.channels")) {
                                Entity.send(player, whiteList);
                            }
                        }
                    } else if(args[0].equalsIgnoreCase("values")) {
                        Entity.send(player, Locale.VALUES_TITLE);
                        AboutValues._send(player);
                    } else if(args[0].equalsIgnoreCase("notify")) {
                        if(args.length == 1) {
                            if (args[1].equalsIgnoreCase("book-crash")) {
                                if (Lists_And_Maps.notify_antibookcrash.get(player.getUniqueId()) == null) {
                                    Lists_And_Maps.notify_antibookcrash.put(player.getUniqueId(), "Enable");
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Locale.getConfig().getString("messages.notify.book-crash.enabled")));;
                                } else {
                                    Lists_And_Maps.notify_antibookcrash.remove(player.getUniqueId());
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Locale.getConfig().getString("messages.notify.book-crash.disabled")));
                                }
                                return true;
                            }
                        }
                    } else {
                        Locale.helpMessage(player, "help-messages.usage.helper*notify");
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
