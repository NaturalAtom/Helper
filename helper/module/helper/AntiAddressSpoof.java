package eu.mixeration.helper.module.helper;

import eu.mixeration.helper.paths.Path_Helper;

public class AntiAddressSpoof {

    public static boolean get() {
        return Path_Helper.getConfig().getBoolean("anti-address-spoof");
    }

}
