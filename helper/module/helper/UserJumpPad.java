package eu.mixeration.helper.module.helper;

import eu.mixeration.helper.paths.Path_Helper;

public class UserJumpPad {

    public static boolean get() {
        return Path_Helper.getConfig().getBoolean("use-jump-pad");
    }
}
