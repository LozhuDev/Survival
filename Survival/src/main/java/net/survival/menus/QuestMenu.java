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

public class QuestMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public QuestMenu(Main listener) {
		QuestMenu.plugin = listener;	
	}
	
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Quest Menu"));
		inv = inventory;
		Border();
		Health(p, 13);
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
	
	public static void Health(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
		String completed = null;
		if(data.get("skullsObtained").hashCode() == data.get("skullsNeeded").hashCode()) {
			completed = Utils.color("&a&lTRUE");
		}else {
			completed = Utils.color("&c&lFALSE");
		}
			ItemStack t = Utils.createItem(Material.SKELETON_SKULL, 1, 0, Utils.color("&aHealth Quest"), Arrays.asList(Utils.color(" "), Utils.color("&7Find all the skeleton"), Utils.color("&7skulls in spawn to"), Utils.color("&7gain extra health!"), Utils.color(" "), Utils.color("&bSkulls: &e" + data.get("skullsObtained").hashCode() + "&7/&e" + data.get("skullsNeeded").hashCode()), Utils.color(" "), Utils.color("&8Quest Completed: " + completed)));
			inv.setItem(slotNumber, t);
	}
	
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equals(Utils.color("&8Quest Menu"))){
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