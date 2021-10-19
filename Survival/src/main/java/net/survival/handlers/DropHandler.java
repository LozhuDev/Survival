package net.survival.handlers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class DropHandler implements Listener {
	@SuppressWarnings("unused")
	private static Main plugin;

	public DropHandler(Main hub) {
		DropHandler.plugin = hub;
	}

	@EventHandler
	public void onDropItemEvent(PlayerDropItemEvent e) {
			if(e.getItemDrop().getItemStack().getType().equals(Material.NETHER_STAR) && e.getItemDrop().getItemStack().hasItemMeta() && e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(Utils.color("&8[&eSurvival Menu&8]"))) {
				e.setCancelled(true);
			}
	}

}
