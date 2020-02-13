package br.com.finalcraft.authmeaux.config.playerdata;

import br.com.finalcraft.evernifecore.config.playerdata.PDSection;
import br.com.finalcraft.evernifecore.config.playerdata.PlayerData;
import org.bukkit.Location;

public class AuthPlayerData extends PDSection {

    private Location quitLocation;
    private boolean wasFlying;
    private boolean wasAllowFlight;

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
        this.getPlayerData().getConfig().setValue("AuthMe.wasFlying", this.wasFlying);
        this.getPlayerData().getConfig().setValue("AuthMe.wasAllowFlight", this.wasAllowFlight);
    }

    @Override
    public void loadUp() {
        quitLocation    = this.getPlayerData().getConfig().getLocation("AuthMe.quitLocation",null);
        wasFlying       = this.getPlayerData().getConfig().getBoolean("AuthMe.wasFlying",false);
        wasAllowFlight = this.getPlayerData().getConfig().getBoolean("AuthMe.wasAllowFlight",false);
    }

    public Location getQuitLocation() {
        return quitLocation;
    }

    public void setQuitLocation(Location quitLocation) {
        this.quitLocation = quitLocation;
        this.setRecentChanged();
        this.forceSavePlayerDataOnYML();
    }

    public void performePlayerQuit(){
        this.quitLocation   = getPlayerData().getPlayer().getLocation();
        this.wasFlying      = getPlayerData().getPlayer().isFlying();
        this.wasAllowFlight = getPlayerData().getPlayer().getAllowFlight();
        this.setRecentChanged();
        this.forceSavePlayerDataOnYML();
    }

    public boolean wasFlying() {
        return wasFlying;
    }

    public boolean wasAllowFlight() {
        return wasAllowFlight;
    }

    // -----------------------------------------------------------------------------------------------------------------------------//
    // Controller Section
    // -----------------------------------------------------------------------------------------------------------------------------//

    public static AuthPlayerData getOrCreateAuthPlayerData(PlayerData playerData){
        return playerData.getOrCreatePDSection(AuthPlayerData.class);
    }

}
