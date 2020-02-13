package br.com.finalcraft.authmeaux.config;

import br.com.finalcraft.evernifecore.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static Config fcAuth;

    public static Config getFcAuthConfig(){
        return fcAuth;
    }

    public static void initialize(JavaPlugin instance){
        fcAuth = new Config(instance,"FCAuthMeHelper.yml"      ,false);
    }
}
