/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cbouton.plugins.spoutcoords;

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
        if(event.getKey() == Keyboard.KEY_F4){
            SpoutPlayer player = event.getPlayer();
            plugin.setCoords(player, !plugin.hasCoords(player));
            System.out.println(player + "has toggled coordinates.");
        }
    }

   /* @Override
    public void onKeyPressedEvent(KeyPressedEvent event) {
        Keyboard keypress = event.getKey();
        System.out.println(keypress.toString());
        SpoutPlayer player = event.getPlayer();
        if(keypress.compareTo(Keyboard.KEY_F4) == 0){
            plugin.setCoords(player, !plugin.hasCoords(player));
            System.out.println(player + "has enabled coordinates.");
            return;
        }
    }*/
    

    
    
}
