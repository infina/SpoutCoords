/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cbouton.plugins.spoutcoords;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author Corey
 */
class SpoutCoordsPlayerListener extends PlayerListener{
    private final Spoutcoords plugin;
    public String compdir;
    
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
        int compass = (int) ((player.getLocation().getYaw()) * -1);
        {if(compass == 0 || compass == 360){
            compdir = "S";
        }
        if(compass == 90){
            compdir = "W";
        }
        if(compass == 180){
            compdir = "N";
        }
        if(compass == 270){
            compdir = "E";
        }
        else{
            compdir = "" + compass;
        }}
        
        plugin.label.setText("x = " + xcoords +", y = " + ycoords + ", z = " + zcoords + "\n" + compdir).setDirty(true);
            
    }



    
    
}
