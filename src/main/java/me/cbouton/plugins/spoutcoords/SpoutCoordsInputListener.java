/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cbouton.plugins.spoutcoords;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author Corey
 */
class SpoutCoordsInputListener extends InputListener {
    private final Spoutcoords plugin;
    
    public SpoutCoordsInputListener(Spoutcoords plugin){
        this.plugin = plugin;
    }

    @Override
    public void onKeyPressedEvent(KeyPressedEvent event) {
        if(event.getPlayer().hasPermission("SpoutCoords.Coords")){
            if(event.getKey() == Keyboard.KEY_F4){
                SpoutPlayer player = event.getPlayer();
                plugin.setCoords(player, !plugin.hasCoords(player));
                if(plugin.hasCoords(player)){
                    System.out.println(player.getDisplayName() + " has enabled coordinates.");
                }
                else{
                    System.out.println(player.getDisplayName() + " has diabled coordinates");
                }
            }
        }
        else{
            event.getPlayer().sendMessage(ChatColor.DARK_RED + "You don't have permissions for that.");
            return;
        }
        if(event.getKey() == Keyboard.KEY_F6 && event.getPlayer().hasPermission("SpoutCoords.Mobs")){
            Player player = event.getPlayer();
            SpoutPlayer plyr = event.getPlayer();
            plugin.setmobtypes(plyr, !plugin.hasmobtypes(plyr));
            System.out.println(player.getDisplayName() + " has toggled mob titles.");
        }
    }

     

    
    
}
