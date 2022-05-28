package eu.mixeration.helper.module.helper.helper$modules;

import eu.mixeration.helper.paths.Path_Config;
import eu.mixeration.helper.paths.Path_Locale;
import eu.mixeration.helper.paths.Path_Maintenancer;

public class Module_Reload {

    public static void mixeration() {
        Path_Config.saveConfig();
        Path_Locale.saveConfig();
        Path_Maintenancer.saveConfig();
        Path_Config.reloadConfig();
        Path_Locale.reloadConfig();
        Path_Maintenancer.reloadConfig();
        Path_Config.saveConfig();
        Path_Locale.saveConfig();
        Path_Maintenancer.saveConfig();
    }

}
