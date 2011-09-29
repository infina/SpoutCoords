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
class SpoutCoordsPlayerListener extends PlayerListener {
	private final Spoutcoords plugin;

	public SpoutCoordsPlayerListener(Spoutcoords plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		SpoutPlayer player = (SpoutPlayer) event.getPlayer();
		if (!plugin.hasCoords(player)) {
			return;
		}

		int xcoords = player.getLocation().getBlockX();
		int ycoords = player.getLocation().getBlockY();
		int zcoords = player.getLocation().getBlockZ();

		plugin.label.setText(xcoords + ", " + ycoords + ", " + zcoords)
				.setDirty(true);

	}

}
