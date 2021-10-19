package net.survival.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import net.survival.main.Main;

public class HungerHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public HungerHandler(Main hub) {
		HungerHandler.plugin = hub;
	}
	
	
	@EventHandler
	public void noHunger(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}

}
