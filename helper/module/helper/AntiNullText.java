package eu.mixeration.helper.module.helper;

import eu.mixeration.helper.paths.Path_Helper;

public class AntiNullText {

    public static boolean get() {
        return Path_Helper.getConfig().getBoolean("anti-null-text");
    }
}
