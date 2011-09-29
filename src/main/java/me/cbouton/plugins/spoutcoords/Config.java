package me.cbouton.plugins.spoutcoords;

import java.util.List;

import org.bukkit.util.config.Configuration;

public class Config {
	public static int widgetX;
	public static int widgetY;
	public static int widgetHeight;
	public static int widgetWidth;

	static boolean Load(Configuration config) {
		config.load();
		List<String> keys = config.getKeys(null);
		if (!keys.contains("WIDGET_X"))
			config.setProperty("WIDGET_X", 10);
		if (!keys.contains("WIDGET_Y"))
			config.setProperty("WIDGET_Y", 10);
		if (!keys.contains("WIDGET_HEIGHT"))
			config.setProperty("WIDGET_HEIGHT", 10);
		if (!keys.contains("WIDGET_WIDTH"))
			config.setProperty("WIDGET_WIDTH", 100);
		if (!config.save()) {
			Spoutcoords.log
					.severe("[SpoutCoords] Error while writing to config.yml");
			return false;
		}
		
		widgetX = config.getInt("WIDGET_X", 10);
		widgetY = config.getInt("WIDGET_Y", 10);
		widgetHeight = config.getInt("WIDGET_HEIGHT", 10);
		widgetWidth = config.getInt("WIDGET_WIDTH", 100);
		return false;

	}

}
