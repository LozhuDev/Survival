package net.survival.handlers;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import net.survival.main.Main;

public class BuildHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public BuildHandler(Main hub) {
		BuildHandler.plugin = hub;
	}
	
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e){
		if(e.getPlayer().getWorld().getName().equals("Lobby") && e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(false);
		}else if(e.getPlayer().getWorld().getName().equals("Lobby") && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void blockPlace(BlockPlaceEvent e){
		if(e.getPlayer().getWorld().getName().equals("Lobby") && e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(false);
		}else if(e.getPlayer().getWorld().getName().equals("Lobby") && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void bucketEmpty(PlayerBucketEmptyEvent e) {
		if(e.getPlayer().getWorld().getName().equals("Lobby")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void entityPlace(EntityPlaceEvent e) {
		if(e.getPlayer().getWorld().getName().equals("Lobby") && e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(false);
		}else if(e.getPlayer().getWorld().getName().equals("Lobby") && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void HangingEntityPlace(HangingPlaceEvent e) {
		if(e.getPlayer().getWorld().getName().equals("Lobby") && e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(false);
		}else if(e.getPlayer().getWorld().getName().equals("Lobby") && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}

}
