package net.survival.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class InventoryHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public InventoryHandler(Main hub) {
		InventoryHandler.plugin = hub;
	}
	
	@EventHandler
	public void onClickEvent(InventoryClickEvent e) {
		if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&8[&eSurvival Menu&8]"))) {
				e.setCancelled(true);
			}else {
				e.setCancelled(false);
			}
		}
		
		
			
	}

}
