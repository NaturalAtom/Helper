package eu.mixeration.world;

import eu.mixeration.helper.paths.Path_WorldSettings;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public class WorldSettings_Modules {

    public static @Nullable String getWorldName(String world) {
        return Path_WorldSettings.getConfig().getString("world-loader." + world + ".world-name");
    }

    public static @Nullable String getAnimals(String world) {
        return Path_WorldSettings.getConfig().getString("world-loader." + world + ".animals");
    }

    public static @Nullable String getMonsters(String world) {
        return Path_WorldSettings.getConfig().getString("world-loader." + world + ".monsters");
    }

    public static @Nullable String getEntity(String world) {
        return Path_WorldSettings.getConfig().getString("world-loader." + world + ".entity");
    }

    public static void registerWorld(World world) {
        String name = world.getName();
        Path_WorldSettings.getConfig().set("world-loader." + name + ".world-name", name);
        Path_WorldSettings.getConfig().set("world-loader." + name + ".animals", 20);
        Path_WorldSettings.getConfig().set("world-loader." + name + ".monsters", 20);
        Path_WorldSettings.getConfig().set("world-loader." + name + ".entity", 20);
        Path_WorldSettings.saveConfig();
    }

}
