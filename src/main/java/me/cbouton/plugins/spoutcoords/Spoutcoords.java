package me.cbouton.plugins.spoutcoords;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Spoutcoords extends JavaPlugin {


    

    private InputListener inputListener = new SpoutCoordsInputListener(this);
    private PlayerListener playerListener = new SpoutCoordsPlayerListener(this);
    private Set<SpoutPlayer> coordinates = new HashSet<SpoutPlayer>();
    public Set<SpoutPlayer> mobtypes = new HashSet<SpoutPlayer>();
    private EntityListener entityListener = new SpoutCoordsEntityListener(this);
    public GenericLabel label = new GenericLabel();
    public Server server = getServer();
    public String[] mobbers = null;
    public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        // TODO: Place any custom enable code here, such as registering events
        boolean Spout = getServer().getPluginManager().isPluginEnabled("Spout");
        if (Spout){
            System.out.println("[" + this + "] is now enabled!");
        }
        else{
            getServer().getPluginManager().disablePlugin(this);
            System.out.println("[" + this + "] is now disabled. Please install the spout plugin");
            return;
        }
        getServer().getPluginManager().registerEvent(Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, inputListener, Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Type.CREATURE_SPAWN, entityListener, Priority.Monitor, this);
    }
    public boolean hasCoords(SpoutPlayer player) {
        return coordinates.contains(player);
    }
    public void setCoords(SpoutPlayer player, boolean enabled){
        if(enabled) {
            coordinates.add(player);
            label.setAuto(false).setX(10).setY(10).setWidth(100).setHeight(20);
            player.getMainScreen().attachWidget(this, label);
        }
        else{
            coordinates.remove(player);
            player.getMainScreen().removeWidget(label);
        }
    }
    public boolean hasmobtypes(SpoutPlayer player){
        return mobtypes.contains(player);
    }
    public void setmobtypes(SpoutPlayer player, boolean enabled){
        if(enabled){
            mobtypes.add(player);
            
        }
        else{
            mobtypes.remove(player);
           
            SpoutManager.getAppearanceManager().resetAllTitles();
        }
    }

}

