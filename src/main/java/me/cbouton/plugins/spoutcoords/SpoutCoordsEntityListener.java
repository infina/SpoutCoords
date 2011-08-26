/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cbouton.plugins.spoutcoords;

import org.bukkit.entity.CreatureType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityListener;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author Corey
 */
class SpoutCoordsEntityListener extends EntityListener {

    private final Spoutcoords plugin;
    
    public SpoutCoordsEntityListener(Spoutcoords plugin){
        this.plugin = plugin;
    }
    @Override
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        CreatureType mobtype = event.getCreatureType(); 
        LivingEntity entity = (LivingEntity) event.getEntity();
        for (int i = 0; i < plugin.mobtypes.size(); i++) {
            SpoutPlayer player = plugin.mobtypes.iterator().next();
            SpoutManager.getAppearanceManager().setPlayerTitle(player, entity, mobtype.toString());
        }
    }

    
    

    

  

   

    
    
    
    
}
