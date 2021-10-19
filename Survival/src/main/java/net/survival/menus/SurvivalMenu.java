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

public class SurvivalMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public SurvivalMenu(Main listener) {
		SurvivalMenu.plugin = listener;	
	}
	
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Survival Menu"));
		inv = inventory;
		Border();
		Quests(p, 13);
		Crates(p, 22);
		Skills(p, 23);
		Achievements(p, 24);
		Pets(p, 21);
		Particles(p, 20);
		Profile(p, 31);
		Auction(p, 33);
		Warps(p, 29);
		Shop(p, 30);
		EChest(p, 32);
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
	
	public static void Crates(Player p, Integer slotNumber){
			ItemStack t = Utils.createItem(Material.CYAN_SHULKER_BOX, 1, 0, Utils.color("&aCrates"), Arrays.asList(Utils.color(" "), Utils.color("&7Open crates for a chance"), Utils.color("&7to get rare items!"), Utils.color(" "), Utils.color("&8Click to warp to Crates!")));
			inv.setItem(slotNumber, t);
	}
	
	public static void Skills(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.DIAMOND_AXE, 1, 0, Utils.color("&aSkills"), Arrays.asList(Utils.color(" "), Utils.color("&7Skills allow you to level up"), Utils.color("&7and gain special perks based"), Utils.color("&7on every day tasks!"), Utils.color(" "), Utils.color("&8Click to open up the Skills menu!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Achievements(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.EXPERIENCE_BOTTLE, 1, 0, Utils.color("&aAchievements"), Arrays.asList(Utils.color(" "), Utils.color("&cAchievements Coming Soon!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Pets(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.BONE, 1, 0, Utils.color("&aPets"), Arrays.asList(Utils.color(" ")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Particles(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.REDSTONE, 1, 0, Utils.color("&aParticles"), Arrays.asList(Utils.color(" ")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Quests(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.WRITABLE_BOOK, 1, 0, Utils.color("&aQuests"), Arrays.asList(Utils.color(" "), Utils.color("&7Complete quests to unlock"), Utils.color("&7special items and perks!"), Utils.color(" "), Utils.color("&8Click to open the Quests Menu!")));
		inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Profile(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
		ItemStack t = Utils.createSkull(p.getName(), Utils.color("&a" + p.getName() + "'s Profile"), Arrays.asList(Utils.color(" "), Utils.color("&7Username: &a" + p.getName()) ,Utils.color("&7Rank: " + data.get("rankColor") + "&l" + data.get("rank")), Utils.color("&7Level: " + "&e" + data.get("level")), Utils.color("&7Xp: " + "&e" + data.get("xp") + "&7/&e" + data.get("xpNeeded")), Utils.color(" "), Utils.color("&8Click to open Profile Menu!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Auction(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.GOLD_INGOT, 1, 0, Utils.color("&aAuction"), Arrays.asList(Utils.color(" ")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Warps(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.BEACON, 1, 0, Utils.color("&aWarps"), Arrays.asList(Utils.color(" "), Utils.color("&7Open the list of"), Utils.color("&7warps to the server!"), Utils.color(" "), Utils.color("&8Click to open the warp menu!")));
		inv.setItem(slotNumber, t);
	}
	
	public static void Shop(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.ANVIL, 1, 0, Utils.color("&aShop"), Arrays.asList(Utils.color(" ")));
		inv.setItem(slotNumber, t);
	}
	
	public static void EChest(Player p, Integer slotNumber){
		ItemStack t = Utils.createItem(Material.ENDER_CHEST, 1, 0, Utils.color("&aEnder Chest"), Arrays.asList(Utils.color(" "), Utils.color("&7Portable ender chest!"), Utils.color(" "), Utils.color("&8Click to open Ender Chest!")));
		inv.setItem(slotNumber, t);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equals(Utils.color("&8Survival Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(e.getInventory() != null){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							if(e.getCurrentItem().getType().equals(Material.CYAN_SHULKER_BOX)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aCrates"))){
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lCrates &ein &c&l3 &eseconds!"));
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							    		public void run() {
							    			Location loc = new Location(Bukkit.getWorld("Lobby"), 41.5, 58, 15.5, -90, 0);
											p.teleport(loc);
							    		}
									}, 20 * 3);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.DIAMOND_AXE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aSkills"))){
									e.setCancelled(true);
									SkillsMenu.Menu(p);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.EXPERIENCE_BOTTLE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aAchievements"))){
									e.setCancelled(true);
									p.sendMessage(Utils.color("&8[&c&lERROR&8] &cTHIS ITEM IS NOT AVAILABLE YET!"));
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.BONE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aPets"))){
									e.setCancelled(true);
									p.sendMessage(Utils.color("&8[&c&lERROR&8] &cTHIS ITEM IS NOT AVAILABLE YET!"));
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.REDSTONE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aParticles"))){
									e.setCancelled(true);
									p.sendMessage(Utils.color("&8[&c&lERROR&8] &cTHIS ITEM IS NOT AVAILABLE YET!"));
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.WRITABLE_BOOK)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aQuests"))){
									e.setCancelled(true);
									QuestMenu.Menu(p);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&a" + p.getName() + "'s Profile"))){
									e.setCancelled(true);
									p.sendMessage(Utils.color("&8[&c&lERROR&8] &cTHIS ITEM IS NOT AVAILABLE YET!"));
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.GOLD_INGOT)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aAuction"))){
									e.setCancelled(true);
									p.sendMessage(Utils.color("&8[&c&lERROR&8] &cTHIS ITEM IS NOT AVAILABLE YET!"));
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.BEACON)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aWarps"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
									WarpMenu.Menu(p);
								}
							}else if(e.getCurrentItem().getType().equals(Material.ANVIL)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aShop"))){
									e.setCancelled(true);
									p.sendMessage(Utils.color("&8[&c&lERROR&8] &cTHIS ITEM IS NOT AVAILABLE YET!"));
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.ENDER_CHEST)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aEnder Chest"))){
									e.setCancelled(true);
									p.openInventory(p.getEnderChest());
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