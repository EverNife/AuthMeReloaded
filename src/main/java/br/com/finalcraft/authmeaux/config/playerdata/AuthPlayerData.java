package br.com.finalcraft.authmeaux.config.playerdata;

import br.com.finalcraft.evernifecore.config.playerdata.PDSection;
import br.com.finalcraft.evernifecore.config.playerdata.PlayerData;
import org.bukkit.Location;

public class AuthPlayerData extends PDSection {

    public Location quitLocation;

    public AuthPlayerData(PlayerData playerData) {
        super(playerData);
    }

    @Override
    public void save() {
        //Code goes in here!
    }

    @Override
    public void saveIfRecentChanged() {
        this.getPlayerData().getConfig().setValue("AuthMe.quitLocation", this.quitLocation);
    }

    @Override
    public void loadUp() {
        quitLocation = this.getPlayerData().getConfig().getLocation("AuthMe.quitLocation",null);
    }

    public Location getQuitLocation() {
        return quitLocation;
    }

    public void setQuitLocation(Location quitLocation) {
        this.quitLocation = quitLocation;
        this.setRecentChanged();
        this.forceSavePlayerDataOnYML();
    }

    // -----------------------------------------------------------------------------------------------------------------------------//
    // Controller Section
    // -----------------------------------------------------------------------------------------------------------------------------//

    public static AuthPlayerData getOrCreateAuthPlayerData(PlayerData playerData){
        return (AuthPlayerData) playerData.getOrCreatePDSection(AuthPlayerData.class);
    }

}
