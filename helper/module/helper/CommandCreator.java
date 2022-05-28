package eu.mixeration.helper.module.helper;

import eu.mixeration.helper.paths.Path_Helper;

public class CommandCreator {

    public static boolean creatorEvent() {
        return Path_Helper.getConfig().getBoolean("command-creator");
    }

}
