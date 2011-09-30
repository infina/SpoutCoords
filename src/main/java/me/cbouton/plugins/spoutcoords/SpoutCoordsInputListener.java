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

	public SpoutCoordsInputListener(Spoutcoords plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onKeyPressedEvent(KeyPressedEvent event) {
		if (event.getKey() == Keyboard.KEY_F4) {
			if (event.getPlayer().hasPermission("spoutcoords.toggle")) {
				SpoutPlayer player = event.getPlayer();
				plugin.setCoords(player, !plugin.hasCoords(player));
				Spoutcoords.log.info(player.getName()
						+ " has toggled coordinates.");
			}
		}
	}
}
