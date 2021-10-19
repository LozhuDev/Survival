package net.survival.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.survival.main.Main;

public class MoveHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public MoveHandler(Main hub) {
		MoveHandler.plugin = hub;
	}
	
	
	@EventHandler
	public void fallOutOfWorld(PlayerMoveEvent e){
		if(e.getPlayer().getLocation().getY() <= 1 && e.getPlayer().getWorld().getName().equals("Lobby")) {
			Location loc = new Location(Bukkit.getWorld("Lobby"), 26.5, 59, 4.5, 0, 0);
			e.getPlayer().teleport(loc);
		}
	}

}
