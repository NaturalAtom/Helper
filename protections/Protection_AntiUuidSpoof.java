package eu.mixeration.protections;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.Path_Config;
import eu.mixeration.helper.paths.Path_ProtectionsLocale;
import eu.mixeration.helper.paths.Path_UUID;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Protection_AntiUuidSpoof implements Listener {
    public Protection_AntiUuidSpoof(Helper helper) {}

    @Deprecated
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Lists_And_Maps.__antiforceop.put(player.getName(), 0);
        if(!(Path_UUID.getConfig().getString("user-data." + player.getName()) == null)) {
            if(Path_UUID.getConfig().getString("user-data." + player.getName() + ".uuid").contains(Path_UUID.getConfig().getString("user-data." + player.getUniqueId() + ".name"))) {
                if(Path_UUID.getConfig().getString("user-data." + player.getUniqueId() + ".name").contains(Path_UUID.getConfig().getString("user-data." + player.getUniqueId() + ".uuid"))) {
                    if (Path_UUID.getConfig().getBoolean("uuid-settings.login.information")) {
                        for (String information : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.login-information")) {
                            information = information.replace("<uuid>", player.getUniqueId().toString());
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', information));
                        }
                        if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                            Console.message("&b{ &9Helper | &bSuccess | &3Anti Null Nick &b} &7Player &f&o" + player.getName() + "&7 passed uuid spoof control.");
                        }
                    }
                } else {
                    if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                        Console.message("&b{ &9Helper | &bError | &3Anti UUID Spoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, Reason: &9UUID Spoof");
                    }
                    if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("directly-kick")) {
                        for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                        }
                    } else if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("count-for-ban")) {
                        if(Lists_And_Maps.__antiforceop.get(player.getName()) < Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count")) {
                            Lists_And_Maps.__antiforceop.put(player.getName(), (Lists_And_Maps.__antiforceop.get(player.getName()) + 1));
                            for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.kicked")) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                            }
                        } else {
                            for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.banned")) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                            }
                            Lists_And_Maps.__antiforceop.remove(player.getName());
                            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), Path_UUID.getConfig().getString("uuid-settings.visible-reason"), null, "Helper");
                        }
                    } else {
                        if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                            Console.message("&b{ &9Helper &3| &bError &3| &3uuid.yml &b} &7uuid-settings.spoof.kick &fcant understand ? &9&o" + Path_UUID.getConfig().getString("uuid-settings.spoof.kick"));
                            Console.message("&b{ &9Helper &3| &bError &3| &3AntiUUIDSpoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, please check &fuuid-settings.spoof.kick&7.");
                        }
                        for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                        }
                    }
                }
            } else {
                if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                    Console.message("&b{ &9Helper | &bError | &3Anti UUID Spoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, Reason: &9UUID Spoof");
                }
                if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("directly-kick")) {
                    for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                    }
                } else if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("count-for-ban")) {
                    if(Lists_And_Maps.__antiforceop.get(player.getName()) < Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count")) {
                        Lists_And_Maps.__antiforceop.put(player.getName(), (Lists_And_Maps.__antiforceop.get(player.getName()) + 1));
                        for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.kicked")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                        }
                    } else {
                        for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.banned")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                        }
                        Lists_And_Maps.__antiforceop.remove(player.getName());
                        Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), Path_UUID.getConfig().getString("uuid-settings.visible-reason"), null, "Helper");
                    }
                } else {
                    if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                        Console.message("&b{ &9Helper &3| &bError &3| &3uuid.yml &b} &7uuid-settings.spoof.kick &fcant understand ? &9&o" + Path_UUID.getConfig().getString("uuid-settings.spoof.kick"));
                        Console.message("&b{ &9Helper &3| &bError &3| &3AntiUUIDSpoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, please check &fuuid-settings.spoof.kick&7.");
                    }
                    for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                    }
                }
            }
        } else {
            if (Path_UUID.getConfig().getString("user-data." + player.getName()) == null) {
                Path_UUID.getConfig().set("user-data." + player.getName() + ".uuid", player.getUniqueId().toString());
                Path_UUID.getConfig().set("user-data." + player.getUniqueId() + ".name", player.getName());
                Path_UUID.saveConfig();
                if (Path_UUID.getConfig().getBoolean("uuid-settings.register.information")) {
                    for (String information : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.register-information")) {
                        information = information.replace("<uuid>", player.getUniqueId().toString());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', information));
                    }
                }
            } else {
                if(Path_UUID.getConfig().getString("user-data." + player.getName() + ".uuid").contains(Path_UUID.getConfig().getString("user-data." + player.getUniqueId() + ".name"))) {
                    if(Path_UUID.getConfig().getString("user-data." + player.getUniqueId() + ".name").contains(Path_UUID.getConfig().getString("user-data." + player.getUniqueId() + ".uuid"))) {
                        if (Path_UUID.getConfig().getBoolean("uuid-settings.login.information")) {
                            for (String information : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.login-information")) {
                                information = information.replace("<uuid>", player.getUniqueId().toString());
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', information));
                            }
                            if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                                Console.message("&b{ &9Helper | &bSuccess | &3Anti Null Nick &b} &7Player &f&o" + player.getName() + "&7 passed uuid spoof control.");
                            }
                        }
                    } else {
                        if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                            Console.message("&b{ &9Helper | &bError | &3Anti UUID Spoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, Reason: &9UUID Spoof");
                        }
                        if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("directly-kick")) {
                            for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                            }
                        } else if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("count-for-ban")) {
                            if(Lists_And_Maps.__antiforceop.get(player.getName()) < Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count")) {
                                Lists_And_Maps.__antiforceop.put(player.getName(), (Lists_And_Maps.__antiforceop.get(player.getName()) + 1));
                                for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.kicked")) {
                                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                                }
                            } else {
                                for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.banned")) {
                                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                                }
                                Lists_And_Maps.__antiforceop.remove(player.getName());
                                Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), Path_UUID.getConfig().getString("uuid-settings.visible-reason"), null, "Helper");
                            }
                        } else {
                            if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                                Console.message("&b{ &9Helper &3| &bError &3| &3uuid.yml &b} &7uuid-settings.spoof.kick &fcant understand ? &9&o" + Path_UUID.getConfig().getString("uuid-settings.spoof.kick"));
                                Console.message("&b{ &9Helper &3| &bError &3| &3AntiUUIDSpoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, please check &fuuid-settings.spoof.kick&7.");
                            }
                            for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                            }
                        }
                    }
                } else {
                    if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                        Console.message("&b{ &9Helper | &bError | &3Anti UUID Spoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, Reason: &9UUID Spoof");
                    }
                    if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("directly-kick")) {
                        for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                        }
                    } else if(Path_UUID.getConfig().getString("uuid-settings.spoof.kick").equalsIgnoreCase("count-for-ban")) {
                        if(Lists_And_Maps.__antiforceop.get(player.getName()) < Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count")) {
                            Lists_And_Maps.__antiforceop.put(player.getName(), (Lists_And_Maps.__antiforceop.get(player.getName()) + 1));
                            for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.kicked")) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                            }
                        } else {
                            for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.count-for-ban.banned")) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick.replace("<trigger-on>", String.valueOf(Path_UUID.getConfig().getInt("uuid-settings.spoof.trigger-count"))).replace("<count>", String.valueOf(Lists_And_Maps.__antiforceop.get(player.getName())))));
                            }
                            Lists_And_Maps.__antiforceop.remove(player.getName());
                            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), Path_UUID.getConfig().getString("uuid-settings.visible-reason"), null, "Helper");
                        }
                    } else {
                        if(Path_Config.getConfig().getBoolean("helper.send-information-message-to-console.uuid-control")) {
                            Console.message("&b{ &9Helper &3| &bError &3| &3uuid.yml &b} &7uuid-settings.spoof.kick &fcant understand ? &9&o" + Path_UUID.getConfig().getString("uuid-settings.spoof.kick"));
                            Console.message("&b{ &9Helper &3| &bError &3| &3AntiUUIDSpoof &b} &7Suspect &f&o" + player.getName() + "&7 directly kicked from server, please check &fuuid-settings.spoof.kick&7.");
                        }
                        for (String kick : Path_ProtectionsLocale.getConfig().getStringList("protections.anti-uuid-spoof.kick-reason.directly-kick")) {
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', kick));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void quit(PlayerQuitEvent event) {
        if (Path_UUID.getConfig().getBoolean("uuid-settings.remove-kick-count-when-player-left-the-game")) {
            if(!(Lists_And_Maps.__antiforceop.get(event.getPlayer()) == null)) {
                Lists_And_Maps.__antiforceop.remove(event.getPlayer());
            }
        }
    }
}
