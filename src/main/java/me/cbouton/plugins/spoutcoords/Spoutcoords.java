package me.cbouton.plugins.spoutcoords;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Spoutcoords extends JavaPlugin {

    private InputListener inputListener = new SpoutCoordsInputListener(this);
    private PlayerListener playerListener = new SpoutCoordsPlayerListener(this);
    private Set<SpoutPlayer> coordinates = new HashSet<SpoutPlayer>();
    public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        // TODO: Place any custom enable code here, such as registering events
        boolean Spout = getServer().getPluginManager().isPluginEnabled("Spout");
        if (Spout){
            System.out.println("[" + this + "] is now enabled!");
            return;
        }
        else{
            getServer().getPluginManager().disablePlugin(this);
            System.out.println("[" + this + "] is now disabled. Please install the spout plugin");
        }
        getServer().getPluginManager().registerEvent(Type.PLAYER_MOVE, playerListener, null, Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, inputListener, Priority.Normal, this);
        
 
        
    }
    public boolean hasCoords(SpoutPlayer player) {
        return coordinates.contains(player);
    }
    public void setCoords(SpoutPlayer player, boolean enabled){
        if(enabled) {
            coordinates.add(player);
        }
        else{
            coordinates.remove(player);
        }
    }
}
