package eu.mixeration.helper.module.helper;

import eu.mixeration.helper.paths.Path_Helper;

public class AntiMessageSpam {

    public static boolean get() {
        return Path_Helper.getConfig().getBoolean("anti-message-spam.enable");
    }

}
