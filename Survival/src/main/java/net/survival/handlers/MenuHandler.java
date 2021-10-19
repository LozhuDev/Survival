package net.survival.handlers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.survival.main.Main;
import net.survival.menus.SurvivalMenu;
import net.survival.utils.Utils;

public class MenuHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public MenuHandler(Main hub) {
		MenuHandler.plugin = hub;
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void survivalmenu(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.NETHER_STAR) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Utils.color("&8[&eSurvival Menu&8]"))){
							SurvivalMenu.Menu(e.getPlayer());
						}
					}
				}
			}
		}
	}

}
