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

public class SkillsMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public SkillsMenu(Main listener) {
		SkillsMenu.plugin = listener;	
	}
	
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Skills Menu"));
		inv = inventory;
		Border();
		Mining(p, 10);
		Foraging(p, 11);
		Farming(p, 19);
		Excavation(p, 28);
		Fishing(p, 29);
		
		Hand(p, 15);
		Bow(p, 16);
		Sword(p, 25);
		Axe(p, 33);
		Repair(p, 34);
		
		Smelt(p, 13);
		Brewing(p, 31);
		
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
		inv.setItem(12, border);
		inv.setItem(14, border);
		inv.setItem(20, border);
		inv.setItem(21, border);
		inv.setItem(22, border);
		inv.setItem(23, border);
		inv.setItem(24, border);
		inv.setItem(30, border);
		inv.setItem(32, border);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Mining(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.GOLDEN_PICKAXE, 1, 0, Utils.color("&aMining"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain mining XP by"), Utils.color("&7breaking ores!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("mineLevel")), Utils.color("&7Xp: &e" + data.get("mineXp") + "&7/&e" + data.get("mineXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Foraging(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.IRON_AXE, 1, 0, Utils.color("&aForaging"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain foraging XP by"), Utils.color("&7chopping down trees!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("woodLevel")), Utils.color("&7Xp: &e" + data.get("woodXp") + "&7/&e" + data.get("woodXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Farming(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.DIAMOND_HOE, 1, 0, Utils.color("&aFarming"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain farming XP by"), Utils.color("&7breaking crops!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("farmLevel")), Utils.color("&7Xp: &e" + data.get("farmXp") + "&7/&e" + data.get("farmXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Excavation(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.NETHERITE_SHOVEL, 1, 0, Utils.color("&aExcavation"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain excavation XP by"), Utils.color("&7digging blocks with a shovel!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("digLevel")), Utils.color("&7Xp: &e" + data.get("digXp") + "&7/&e" + data.get("digXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Fishing(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.FISHING_ROD, 1, 0, Utils.color("&aFishing"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain fishing XP by"), Utils.color("&7well... fishing?!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("fishLevel")), Utils.color("&7Xp: &e" + data.get("fishXp") + "&7/&e" + data.get("fishXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Hand(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.SUNFLOWER, 1, 0, Utils.color("&aHand"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain hand XP by slaying"), Utils.color("&7mobs with your fists!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("handLevel")), Utils.color("&7Xp: &e" + data.get("handXp") + "&7/&e" + data.get("handXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Bow(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.BOW, 1, 0, Utils.color("&aBow"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain bow XP by"), Utils.color("&7slaying mobs with a bow!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("bowLevel")), Utils.color("&7Xp: &e" + data.get("bowXp") + "&7/&e" + data.get("bowXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Sword(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.NETHERITE_SWORD, 1, 0, Utils.color("&aSword"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain sword XP by"), Utils.color("&7slaying mobs with a sword!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("swordLevel")), Utils.color("&7Xp: &e" + data.get("swordXp") + "&7/&e" + data.get("swordXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Axe(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.GOLDEN_AXE, 1, 0, Utils.color("&aAxe"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain axe XP by"), Utils.color("&7slaying mobs with an axe!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("axeLevel")), Utils.color("&7Xp: &e" + data.get("axeXp") + "&7/&e" + data.get("axeXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Repair(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.ANVIL, 1, 0, Utils.color("&aRepair"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain repair XP by"), Utils.color("&7repairing items in an anvil!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("repairLevel")), Utils.color("&7Xp: &e" + data.get("repairXp") + "&7/&e" + data.get("repairXpNeeded")), Utils.color("&cThis skill is currently disabled!")));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Smelt(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.BLAST_FURNACE, 1, 0, Utils.color("&aSmelting"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain smelting XP by"), Utils.color("&7smelting ores in a furnace!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("smeltLevel")), Utils.color("&7Xp: &e" + data.get("smeltXp") + "&7/&e" + data.get("smeltXpNeeded"))));
			inv.setItem(slotNumber, t);
	}
	
	@SuppressWarnings("rawtypes")
	public static void Brewing(Player p, Integer slotNumber){
		HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			ItemStack t = Utils.createItem(Material.BREWING_STAND, 1, 0, Utils.color("&aBrewing"), Arrays.asList(Utils.color(" "), Utils.color("&7Gain brewing XP by creating"), Utils.color("&7potions in a brewing stand!"), Utils.color(" "), Utils.color("&7Level: &c" + data.get("brewLevel")), Utils.color("&7Xp: &e" + data.get("brewXp") + "&7/&e" + data.get("brewXpNeeded")), Utils.color("&cThis skill is currently disabled!")));
			inv.setItem(slotNumber, t);
	}
	
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equals(Utils.color("&8Skills Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(e.getInventory() != null){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							if(e.getCurrentItem().getType().equals(Material.GOLDEN_PICKAXE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aMining"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.IRON_AXE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aForaging"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.DIAMOND_HOE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aFarming"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.NETHERITE_SHOVEL)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aExcavation"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.FISHING_ROD)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aFishing"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.SUNFLOWER)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aHand"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.BOW)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aBow"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.NETHERITE_SWORD)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aSword"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.GOLDEN_AXE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aAxe"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.ANVIL)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aRepair"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.BLAST_FURNACE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aSmelting"))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}else if(e.getCurrentItem().getType().equals(Material.BREWING_STAND)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&aBrewing"))){
									e.setCancelled(true);
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