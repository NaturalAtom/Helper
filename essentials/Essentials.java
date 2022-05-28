package eu.mixeration.essentials;

import eu.mixeration.essentials.commands.EssentialsSetup;
import eu.mixeration.helper.Helper;

public class Essentials {
    public Essentials(Helper helper) {}

    public static void essLoad() {
        EssentialsSetup.register();
    }
}
