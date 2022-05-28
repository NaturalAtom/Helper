package eu.mixeration.essentials.commands;

import eu.mixeration.essentials.commands.player.Player_GameMode;
import eu.mixeration.essentials.commands.player.Player_Manager;
import eu.mixeration.essentials.commands.player.Player_Ping;
import eu.mixeration.essentials.commands.staff.Broadcast;
import eu.mixeration.helper.Helper;
import eu.mixeration.helper.module.Console;
import org.bukkit.Bukkit;

public class EssentialsSetup {

    public static void register(){
        Helper.get().getCommand("broadcast").setExecutor(new Broadcast(Helper.get()));
        Helper.get().getCommand("manager").setExecutor(new Player_Manager(Helper.get()));
        Helper.get().getCommand("ping").setExecutor(new Player_Ping(Helper.get()));
        Helper.get().getCommand("gamemode").setExecutor(new Player_GameMode(Helper.get()));
        if(!(Bukkit.getPluginManager().getPlugin("Essentials").isEnabled())) {
            Console.message("&b{ &9Helper | &bHook | &3Essentials &b} &7Essentials not found, Helper will enable some &fessentials &7command.");
        } else {
            Console.message("&b{ &9Helper | &bHook | &3Essentials &b} &7Essentials found.");
        }
    }

}
