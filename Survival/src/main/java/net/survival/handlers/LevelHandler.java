package net.survival.handlers;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerFishEvent;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class LevelHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public LevelHandler(Main hub) {
		LevelHandler.plugin = hub;
	}
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			Integer xpToAdd = Utils.randomNum(1, 5);
			Integer coins = 1;
			if(Utils.randomNum(1, 3) == 2) {
				coins = Utils.randomNum(1, 3);
			}
			HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("level").hashCode()+1);
			if(e.getEntity() instanceof Monster || e.getEntity() instanceof Player) {
				if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
				}
			}
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(e.getBlock().getType().equals(Material.IRON_ORE)  
				|| e.getBlock().getType().equals(Material.GOLD_ORE)
				|| e.getBlock().getType().equals(Material.DIAMOND_ORE)
				|| e.getBlock().getType().equals(Material.EMERALD_ORE)
				|| e.getBlock().getType().equals(Material.ANCIENT_DEBRIS)
				|| e.getBlock().getType().equals(Material.COAL_ORE)
				|| e.getBlock().getType().equals(Material.LAPIS_ORE)
				|| e.getBlock().getType().equals(Material.REDSTONE_ORE)
				|| e.getBlock().getType().equals(Material.OBSIDIAN)) {
			Player p = e.getPlayer();
			Integer xpToAdd = Utils.randomNum(1, 5);
			Integer coins = 1;
			if(Utils.randomNum(1, 3) == 2) {
				coins = Utils.randomNum(1, 3);
			}
			HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("level").hashCode()+1);
				if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
				}
		}
		
		
		
		else //FORAGING SKILL
			if(e.getBlock().getType().equals(Material.ACACIA_LOG) 
					|| e.getBlock().getType().equals(Material.BIRCH_LOG)
					|| e.getBlock().getType().equals(Material.DARK_OAK_LOG)
					|| e.getBlock().getType().equals(Material.JUNGLE_LOG)
					|| e.getBlock().getType().equals(Material.OAK_LOG)
					|| e.getBlock().getType().equals(Material.SPRUCE_LOG)) {
				Player p = e.getPlayer();
				Integer xpToAdd = Utils.randomNum(1, 5);
				Integer coins = 1;
				if(Utils.randomNum(1, 3) == 2) {
					coins = Utils.randomNum(1, 3);
				}
				HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
				Integer newLevel = (data.get("level").hashCode()+1);
					if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
						Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
					}	
			}
		
		
			else if(e.getBlock().getType().equals(Material.DIRT) 
					|| e.getBlock().getType().equals(Material.GRASS_BLOCK)
					|| e.getBlock().getType().equals(Material.SAND)
					|| e.getBlock().getType().equals(Material.GRAVEL)
					|| e.getBlock().getType().equals(Material.RED_SAND)
					|| e.getBlock().getType().equals(Material.SOUL_SAND)
					|| e.getBlock().getType().equals(Material.PODZOL)
					|| e.getBlock().getType().equals(Material.CLAY)) {
					Player p = e.getPlayer();
					Integer xpToAdd = Utils.randomNum(1, 5);
					Integer coins = 1;
					if(Utils.randomNum(1, 3) == 2) {
						coins = Utils.randomNum(1, 3);
					}
					HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
					Integer newLevel = (data.get("level").hashCode()+1);
						if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
							p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
							p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
							Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
						}else {
							Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
						}	
			}
		
		
			else if(e.getBlock().getType().equals(Material.WHEAT_SEEDS) 
					|| e.getBlock().getType().equals(Material.BEETROOT_SEEDS)
					|| e.getBlock().getType().equals(Material.PUMPKIN_SEEDS)
					|| e.getBlock().getType().equals(Material.MELON_SEEDS)
					|| e.getBlock().getType().equals(Material.SUGAR_CANE)
					|| e.getBlock().getType().equals(Material.CARROT)
					|| e.getBlock().getType().equals(Material.CARROTS)
					|| e.getBlock().getType().equals(Material.POTATO)
					|| e.getBlock().getType().equals(Material.POTATOES)) {
					Player p = e.getPlayer();
					Integer xpToAdd = Utils.randomNum(1, 5);
					Integer coins = 1;
					if(Utils.randomNum(1, 3) == 2) {
						coins = Utils.randomNum(1, 3);
					}
					HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
					Integer newLevel = (data.get("level").hashCode()+1);
						if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
							p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
							p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
							Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
						}else {
							Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
						}
			}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onSmelt(FurnaceExtractEvent e) {
		if(e.getItemType().equals(Material.COPPER_INGOT)
				|| e.getItemType().equals(Material.GOLD_INGOT)
				|| e.getItemType().equals(Material.IRON_INGOT)
				|| e.getItemType().equals(Material.NETHERITE_INGOT)) {
			Player p = e.getPlayer();
			Integer xpToAdd = (Utils.randomNum(1, 5)*e.getItemAmount());
			Integer coins = 1;
			if(Utils.randomNum(1, 3) == 2) {
				coins = Utils.randomNum(1, 3);
			}
			HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("level").hashCode()+1);
				if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
				}
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onFish(PlayerFishEvent e) {
		if(e.getCaught() != null) {
			Player p = e.getPlayer();
			Integer xpToAdd = Utils.randomNum(1, 5);
			Integer coins = 1;
			if(Utils.randomNum(1, 3) == 2) {
				coins = Utils.randomNum(1, 3);
			}
			HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("level").hashCode()+1);
				if(data.get("xp").hashCode()+xpToAdd >= data.get("xpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up to level: &c" + newLevel));
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("level", data.get("level").hashCode()+1).with("xp", 0).with("xpNeeded", Math.round(data.get("xpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("xp", data.get("xp").hashCode() + xpToAdd).with("coins", data.get("coins").hashCode()+coins)).run(Main.conn);
				}
		}
	}

}
