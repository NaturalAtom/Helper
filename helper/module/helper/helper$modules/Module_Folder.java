package eu.mixeration.helper.module.helper.helper$modules;

import eu.mixeration.helper.Helper;

import java.io.File;

public class Module_Folder {

    public static void createFolder(String name) {
        File folder = new File(Helper.get().getDataFolder(), name);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
