package eu.mixeration.$mixeration;

import eu.mixeration.helper.paths.Path_Essentials;

public class PermissionHandler {

    public static @org.jetbrains.annotations.Nullable String getEssentialsPermPath(String permPath) {
        return Path_Essentials.getConfig().getString("essentials.custom-permissions." + permPath);
    }

}
