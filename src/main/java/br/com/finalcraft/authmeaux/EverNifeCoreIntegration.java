package br.com.finalcraft.authmeaux;

import org.bukkit.Bukkit;

public class EverNifeCoreIntegration {

    private static Boolean enabled = null;

    public static boolean isEnabled(){
        if (enabled == null){
            enabled = Bukkit.getPluginManager().isPluginEnabled("EverNifeCore");
        }
        return enabled;
    }

}
