package net.survival.menus;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class RtpMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public RtpMenu(Main listener) {
		RtpMenu.plugin = listener;	
	}
	
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8RTP Menu"));
		inv = inventory;
		Border();
		ThirtyK(p, 22);
		TwentyK(p, 21);
		FortyK(p, 23);
		TenK(p, 20);
		FiftyK(p, 24);
		p.openInventory(inv);
		p.updateInventory();
	}
	
	public static void Border(){
		ItemStack border = Utils.createItem(Material.GRAY_STAINED_GLASS_PANE, 1, 0, Utils.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	public static void TenK(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.COMPASS, 10, 0, Utils.color("&a10k"), Arrays.asList(Utils.color(" "), Utils.color("&7Randomly teleport 10,000"), Utils.color("&7blocks out in the world!"), Utils.color(" "), Utils.color("&8Click to Randomly Teleport!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void TwentyK(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.COMPASS, 20, 0, Utils.color("&a20k"), Arrays.asList(Utils.color(" "), Utils.color("&7Randomly teleport 20,000"), Utils.color("&7blocks out in the world!"), Utils.color(" "), Utils.color("&8Click to Randomly Teleport!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void ThirtyK(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.COMPASS, 30, 0, Utils.color("&a30k"), Arrays.asList(Utils.color(" "), Utils.color("&7Randomly teleport 30,000"), Utils.color("&7blocks out in the world!"), Utils.color(" "), Utils.color("&8Click to Randomly Teleport!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void FortyK(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.COMPASS, 40, 0, Utils.color("&a40k"), Arrays.asList(Utils.color(" "), Utils.color("&7Randomly teleport 40,000"), Utils.color("&7blocks out in the world!"), Utils.color(" "), Utils.color("&8Click to Randomly Teleport!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void FiftyK(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.COMPASS, 50, 0, Utils.color("&a50k"), Arrays.asList(Utils.color(" "), Utils.color("&7Randomly teleport 50,000"), Utils.color("&7blocks out in the world!"), Utils.color(" "), Utils.color("&8Click to Randomly Teleport!")));
		inv.setItem(slotNumber, t);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equals(Utils.color("&8RTP Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(e.getInventory() != null){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							if(e.getCurrentItem().getType().equals(Material.COMPASS)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&a10k"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lRandom Location &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = Utils.getRandomLocation(-10000, 10000);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&a20k"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lRandom Location &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = Utils.getRandomLocation(-20000, 20000);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&a30k"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lRandom Location &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = Utils.getRandomLocation(-30000, 30000);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&a40k"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lRandom Location &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = Utils.getRandomLocation(-40000, 40000);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&a50k"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lRandom Location &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = Utils.getRandomLocation(-50000, 50000);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							//BORDER
							if(e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(" "))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							
						}
					}
				}
			}
		}
	}

}