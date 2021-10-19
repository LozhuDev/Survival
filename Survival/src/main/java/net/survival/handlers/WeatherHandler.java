package net.survival.handlers;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import net.survival.main.Main;

public class WeatherHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public WeatherHandler(Main hub) {
		WeatherHandler.plugin = hub;
	}
	
	
	@EventHandler
	  public void weatherChange(WeatherChangeEvent event){
		if(event.getWorld().getName().equals("Lobby")) {
			if (event.toWeatherState()) {
		        World world = event.getWorld();
		          event.setCancelled(true);
		          world.setStorm(false);
		          world.setThundering(false);
		          world.setWeatherDuration(0);
		    }
		}
	  }

}
