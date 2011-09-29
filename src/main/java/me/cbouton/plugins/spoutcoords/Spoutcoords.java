package me.cbouton.plugins.spoutcoords;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Spoutcoords extends JavaPlugin {

	public static final Logger log = Logger.getLogger("Minecraft");
	private InputListener inputListener = new SpoutCoordsInputListener(this);
	private PlayerListener playerListener = new SpoutCoordsPlayerListener(this);
	private Set<SpoutPlayer> coordinates = new HashSet<SpoutPlayer>();
	public GenericLabel label = new GenericLabel();

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[" + pdfFile.getName() + "] v" + pdfFile.getVersion()
				+ " is now disabled!");
	}

	public void onEnable() {
		if (!this.getDataFolder().exists())
			this.getDataFolder().mkdirs();

		Config.Load(getConfiguration());
		PluginDescriptionFile pdfFile = this.getDescription();
		boolean Spout = getServer().getPluginManager().isPluginEnabled("Spout");
		if (Spout) {
			log.info("[" + pdfFile.getName() + "] v" + pdfFile.getVersion()
					+ " is now enabled!");
		} else {
			getServer().getPluginManager().disablePlugin(this);
			log.info("[" + pdfFile.getName() + "] v" + pdfFile.getVersion()
					+ " is now disabled. Please install the spout plugin");
			return;
		}
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Type.PLAYER_MOVE, playerListener, Priority.Normal,
				this);
		pm.registerEvent(Type.CUSTOM_EVENT, inputListener, Priority.Normal,
				this);
	}

	public boolean hasCoords(SpoutPlayer player) {
		return coordinates.contains(player);
	}

	public void setCoords(SpoutPlayer player, boolean enabled) {
		if (enabled) {
			coordinates.add(player);
			label.setAuto(false).setX(Config.widgetX).setY(Config.widgetY)
					.setWidth(Config.widgetWidth)
					.setHeight(Config.widgetHeight);

			player.getMainScreen().attachWidget(this, label);
		} else {
			coordinates.remove(player);
			player.getMainScreen().removeWidget(label);
		}
	}
}
