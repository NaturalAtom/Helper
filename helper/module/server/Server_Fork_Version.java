package eu.mixeration.helper.module.server;

import eu.mixeration.helper.paths.Path_Helper;

public class Server_Fork_Version {

    public static String get(){
        return Path_Helper.getConfig().getString("server-version");
    }

}
