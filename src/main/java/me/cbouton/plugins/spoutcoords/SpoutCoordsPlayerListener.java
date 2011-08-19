/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cbouton.plugins.spoutcoords;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author Corey
 */
class SpoutCoordsPlayerListener extends PlayerListener{
    private final Spoutcoords plugin;
    
    public SpoutCoordsPlayerListener(Spoutcoords plugin){
        this.plugin = plugin;
    }
    


    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
        SpoutPlayer player = (SpoutPlayer) event.getPlayer();
        if(!plugin.hasCoords(player)){
            return;
        }
       
        int xcoords = player.getLocation().getBlockX();
        int ycoords = player.getLocation().getBlockY();
        int zcoords = player.getLocation().getBlockZ();
        
        GenericLabel label = new GenericLabel();
        label.setAuto(false).setX(10).setY(10).setWidth(100).setHeight(30);
        GenericPopup coordpopup = new GenericPopup();
        coordpopup.attachWidget(label);
        label.setText("x = " + xcoords +", y = " + ycoords + ", z = " + zcoords).setDirty(true);
            
    }



    
    
}
