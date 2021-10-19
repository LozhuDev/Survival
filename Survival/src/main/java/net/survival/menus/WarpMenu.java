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

public class WarpMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public WarpMenu(Main listener) {
		WarpMenu.plugin = listener;	
	}
	
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Warp Menu"));
		inv = inventory;
		Border();
		Spawn(p, 13);
		rtp(p, 22);
		parkour(p, 21);
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
	
	public static void Spawn(Player p, Integer slotNumber){
			ItemStack t = Utils.createItem(Material.DIAMOND, 1, 0, Utils.color("&aSpawn"), Arrays.asList(Utils.color(" "), Utils.color("&7Spawn provides crates"), Utils.color("&7enchantments and shops!"), Utils.color(" "), Utils.color("&8Click to warp to Spawn!")));
			inv.setItem(slotNumber, t);
	}
	
	public static void rtp(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.COMPASS, 1, 0, Utils.color("&aRandom Teleport"), Arrays.asList(Utils.color(" "), Utils.color("&7Randomly teleport to a"), Utils.color("&7location in the survival world!"), Utils.color(" "), Utils.color("&8Click to randomly warp!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void parkour(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.CYAN_WOOL, 1, 0, Utils.color("&aParkour"), Arrays.asList(Utils.color(" "), Utils.color("&7Warp to the beginning"), Utils.color("&7of the parkour area!"), Utils.color(" "), Utils.color("&8Click to warp to Parkour!")));
		inv.setItem(slotNumber, t);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equals(Utils.color("&8Warp Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(e.getInventory() != null){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							if(e.getCurrentItem().getType().equals(Material.DIAMOND)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aSpawn"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lSpawn &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = new Location(Bukkit.getWorld("Lobby"), 26.5, 59, 4.5, 0, 0);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.COMPASS)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aRandom Teleport"))){
									e.setCancelled(true);
									RtpMenu.Menu(p);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.CYAN_WOOL)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aParkour"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lParkour &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = new Location(Bukkit.getWorld("Lobby"), -21.5, 61, -40.5, 20, 5);
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