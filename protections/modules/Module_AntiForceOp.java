package eu.mixeration.protections.modules;

import eu.mixeration.helper.paths.Path_UUID;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class Module_AntiForceOp {
    public static @Nullable String id(Player player) {
        return Path_UUID.getConfig().getString("user-data.data." + player.getName() + ".uuid-to-name");
    }

    public static @Nullable String socketAddress(Player player) {
        return Path_UUID.getConfig().getString("user-data.data." + player.getName() + ".address");
    }

    public static @Nullable String name(Player player) {
        return Path_UUID.getConfig().getString("user-data.data." + player.getName() + ".name-to-id");
    }

    public static @Nullable String set(String type, String value ,Player player) {
        if (Path_UUID.getConfig().getString("user-data.data." + player.getName() + "." + type) == null) {
            Path_UUID.getConfig().set("user-data.data." + player.getName() + "." + type, value);
            Path_UUID.reloadConfig();
            Path_UUID.saveConfig();
        }
        return "Unknow";
    }

}
