package net.survival.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import net.survival.main.Main;

public class DamageHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public DamageHandler(Main hub) {
		DamageHandler.plugin = hub;
	}
	
	
	@EventHandler
	  public void onEntityDamage(EntityDamageEvent e){
		if(e.getEntity().getWorld().getName().equals("Lobby")) {
			e.setCancelled(true);	
		}
	  }

	@EventHandler
	public void noPlayerDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity().getWorld().getName().equals("Lobby")) {
			e.setCancelled(true);	
		}
	}

}
