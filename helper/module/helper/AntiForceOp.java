package eu.mixeration.helper.module.helper;

import eu.mixeration.helper.paths.Path_Helper;

public class AntiForceOp {

    public static boolean get() {
        return Path_Helper.getConfig().getBoolean("use-anti-force-op");
    }

    public static long delay() {
        return Path_Helper.getConfig().getLong("anti-force-op-check-interval");
    }

}
