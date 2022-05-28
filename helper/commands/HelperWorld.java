package eu.mixeration.helper.commands;

import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.Entity;
import eu.mixeration.helper.module.Locale;
import eu.mixeration.world.CopyWorld;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperWorld implements CommandExecutor {
    public HelperWorld(Helper helper) {}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission("helper.world")) {
                if(command.getName().equalsIgnoreCase("HelperWorld")) {
                    if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
                        Locale.helpMessage(player, "help-messages.usage.helper*world");
                    } else if(args.length == 2) {
                        File world = Bukkit.getWorld(args[1]).getWorldFolder();
                        World world1 = Bukkit.getWorld(args[1]);
                        if(args[0].equalsIgnoreCase("copy-world")) {
                            if (world1 == null) {
                                Entity.send(player, Locale.WORLD_NOT_FOUND.replace("<world>", args[1].toUpperCase(java.util.Locale.ROOT)));
                            } else {
                                Date now = new Date();
                                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                File folder = new File(Helper.get().getDataFolder(), "worlds" + File.separator + (format.format(now) + args[1].toString()));
                                if (!folder.exists()) {
                                    try {
                                        folder.mkdir();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                CopyWorld.copyWorld(world, folder);
                                Entity.send(player, Locale.COPY_WORLD_PLEASE_CHECK_HELPER_FOLDER.replace("<world>", args[1].toUpperCase(java.util.Locale.ROOT)));
                            }
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.helper*world");
                        }
                    } else if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("world-list")) {
                            Entity.send(player, Locale.WORLD_TITLE);
                            for(World worlds : Bukkit.getServer().getWorlds()) {
                                Entity.send(player, " &a&l+ &f" + worlds.getName());
                            }
                        } else {
                            Locale.helpMessage(player, "help-messages.usage.helper*world");
                        }
                    } else {
                        Locale.helpMessage(player, "help-messages.usage.helper*world");
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
