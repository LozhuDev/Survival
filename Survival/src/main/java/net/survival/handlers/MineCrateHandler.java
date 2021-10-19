package net.survival.handlers;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.survival.main.Main;
import net.survival.utils.HoloGrams;
import net.survival.utils.Packets;
import net.survival.utils.Utils;

public class MineCrateHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public MineCrateHandler(Main hub) {
		MineCrateHandler.plugin = hub;
	}
	
	

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(e.getBlock().getType().equals(Material.IRON_ORE)
				|| e.getBlock().getType().equals(Material.COAL_ORE)
				|| e.getBlock().getType().equals(Material.DIAMOND_ORE)
				|| e.getBlock().getType().equals(Material.EMERALD_ORE)
				|| e.getBlock().getType().equals(Material.COPPER_ORE)
				|| e.getBlock().getType().equals(Material.GOLD_ORE)
				|| e.getBlock().getType().equals(Material.LAPIS_ORE)
				|| e.getBlock().getType().equals(Material.REDSTONE_ORE)) {
			Integer num = Utils.randomNum(1, 50);
			if(num == 5) {
				e.setCancelled(true);
				e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
				e.getBlock().setType(Material.CHEST);
				Packets.sendTitle(e.getPlayer(), Utils.color(" "), Utils.color("&cMinecrate Found"));
				HoloGrams.createTempHoloGram(e.getBlock().getLocation().add(0.5, 0.5, 0.5), Utils.color("&e&lMINECRATE"), Utils.randomNum(99,150), 3, false, true, false, null, null, null);
				Chest chest = (Chest) e.getBlock().getState();
				for(int i = 0; i < Utils.randomNum(10, 27); i++) {
					Integer num1 = Utils.randomNum(1, 50);
					switch(num1) {
					  case 3:
					    chest.getInventory().addItem(Utils.createItem(Material.COAL, Utils.randomNum(1, 64), 0, null, null));
					    break;
					  case 5:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_INGOT, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 48:
						  chest.getInventory().addItem(Utils.createItem(Material.TNT, Utils.randomNum(1, 5), 0, null, null));
					    break;
					  case 7:
						  chest.getInventory().addItem(Utils.createItem(Material.GOLD_INGOT, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 9:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_SWORD, 1, 0, null, null));
					    break;
					  case 11:
						  chest.getInventory().addItem(Utils.createItem(Material.EXPERIENCE_BOTTLE, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 13:
						  chest.getInventory().addItem(Utils.createItem(Material.BOOK, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 15:
						  chest.getInventory().addItem(Utils.createItem(Material.DIAMOND, Utils.randomNum(1, 3), 0, null, null));
					    break;
					  case 17:
						  chest.getInventory().addItem(Utils.createItem(Material.OAK_LOG, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 19:
						  chest.getInventory().addItem(Utils.createItem(Material.CARROTS, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 21:
						  chest.getInventory().addItem(Utils.createItem(Material.GOLDEN_APPLE, Utils.randomNum(1, 2), 0, null, null));
					    break;
					  case 23:
						  chest.getInventory().addItem(Utils.createItem(Material.COOKED_BEEF, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 25:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_HELMET, 1, 0, null, null));
					    break;
					  case 27:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_CHESTPLATE, 1, 0, null, null));
					    break;
					  case 29:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_LEGGINGS, 1, 0, null, null));
					    break;
					  case 31:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_BOOTS, 1, 0, null, null));
					    break;
					  case 33:
						  chest.getInventory().addItem(Utils.createItem(Material.IRON_PICKAXE, 1, 0, null, null));
					    break;
					  case 35:
						  chest.getInventory().addItem(Utils.createItem(Material.TURTLE_HELMET, 1, 0, null, null));
					    break;
					  case 37:
						  chest.getInventory().addItem(Utils.createItem(Material.ELYTRA, 1, 0, null, null));
					    break;
					  case 39:
						  chest.getInventory().addItem(Utils.createItem(Material.ARROW, Utils.randomNum(1, 16), 0, null, null));
					    break;
					  case 41:
						  chest.getInventory().addItem(Utils.createItem(Material.BLACK_SHULKER_BOX, 1, 0, null, null));
					    break;
					  case 43:
						  chest.getInventory().addItem(Utils.createItem(Material.NETHER_WART, Utils.randomNum(1, 8), 0, null, null));
					    break;
					  case 45:
						  chest.getInventory().addItem(Utils.createItem(Material.CROSSBOW, 1, 0, null, null));
					    break;
					  case 47:
						  chest.getInventory().addItem(Utils.createItem(Material.SHIELD, 1, 0, null, null));
					    break;
					  case 49:
						  chest.getInventory().addItem(Utils.createItem(Material.SOUL_CAMPFIRE, 1, 0, null, null));
					    break;
					  default:   
					}
				}
			}
		}
	}
	

}
