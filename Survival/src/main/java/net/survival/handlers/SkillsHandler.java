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

public class SkillsHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public SkillsHandler(Main hub) {
		SkillsHandler.plugin = hub;
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		//FORAGING SKILL
		if(e.getBlock().getType().equals(Material.ACACIA_LOG) 
				|| e.getBlock().getType().equals(Material.BIRCH_LOG)
				|| e.getBlock().getType().equals(Material.DARK_OAK_LOG)
				|| e.getBlock().getType().equals(Material.JUNGLE_LOG)
				|| e.getBlock().getType().equals(Material.OAK_LOG)
				|| e.getBlock().getType().equals(Material.SPRUCE_LOG)) {
			Player p = e.getPlayer();
			Integer xpToAdd = Utils.randomNum(1, 15);
			HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("woodLevel").hashCode()+1);
				if(data.get("woodXp").hashCode()+xpToAdd >= data.get("woodXpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lFORAGING &bto level: &c" + newLevel));
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("woodLevel", data.get("woodLevel").hashCode()+1).with("woodXp", 0).with("woodXpNeeded", Math.round(data.get("woodXpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("woodXp", data.get("woodXp").hashCode() + xpToAdd)).run(Main.conn);
				}		
		}
				
				//MINING SKILL
		else if(e.getBlock().getType().equals(Material.COAL_ORE) 
				|| e.getBlock().getType().equals(Material.COPPER_ORE)
				|| e.getBlock().getType().equals(Material.DIAMOND_ORE)
				|| e.getBlock().getType().equals(Material.EMERALD_ORE)
				|| e.getBlock().getType().equals(Material.GOLD_ORE)
				|| e.getBlock().getType().equals(Material.IRON_ORE)
				|| e.getBlock().getType().equals(Material.LAPIS_ORE)
				|| e.getBlock().getType().equals(Material.NETHER_GOLD_ORE)
				|| e.getBlock().getType().equals(Material.NETHER_QUARTZ_ORE)
				|| e.getBlock().getType().equals(Material.REDSTONE_ORE)) {
			Player p = e.getPlayer();
			Integer xpToAdd = Utils.randomNum(1, 15);
			HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("mineLevel").hashCode()+1);
				if(data.get("mineXp").hashCode()+xpToAdd >= data.get("mineXpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lMINING &bto level: &c" + newLevel));
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("mineLevel", data.get("mineLevel").hashCode()+1).with("mineXp", 0).with("mineXpNeeded", Math.round(data.get("mineXpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("mineXp", data.get("mineXp").hashCode() + xpToAdd)).run(Main.conn);
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
				Integer xpToAdd = Utils.randomNum(1, 15);
				HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
				Integer newLevel = (data.get("digLevel").hashCode()+1);
					if(data.get("digXp").hashCode()+xpToAdd >= data.get("digXpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lDIGGING &bto level: &c" + newLevel));
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("digLevel", data.get("digLevel").hashCode()+1).with("digXp", 0).with("digXpNeeded", Math.round(data.get("digXpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("digXp", data.get("digXp").hashCode() + xpToAdd)).run(Main.conn);
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
				Integer xpToAdd = Utils.randomNum(1, 15);
				HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
				Integer newLevel = (data.get("farmLevel").hashCode()+1);
					if(data.get("farmXp").hashCode()+xpToAdd >= data.get("farmXpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lFARMING &bto level: &c" + newLevel));
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("farmLevel", data.get("farmLevel").hashCode()+1).with("farmXp", 0).with("farmXpNeeded", Math.round(data.get("farmXpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("farmXp", data.get("farmXp").hashCode() + xpToAdd)).run(Main.conn);
					}
		}
		
		
		
		
		
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onFish(PlayerFishEvent e) {
		if(e.getCaught() != null) {
			Player p = e.getPlayer();
			Integer xpToAdd = Utils.randomNum(1, 15);
			HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("fishLevel").hashCode()+1);
				if(data.get("fishXp").hashCode()+xpToAdd >= data.get("fishXpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lFISHING &bto level: &c" + newLevel));
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("fishLevel", data.get("fishLevel").hashCode()+1).with("fishXp", 0).with("fishXpNeeded", Math.round(data.get("fishXpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("fishXp", data.get("fishXp").hashCode() + xpToAdd)).run(Main.conn);
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
			Integer xpToAdd = (Utils.randomNum(1, 15)*e.getItemAmount());
			HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
			Integer newLevel = (data.get("smeltLevel").hashCode()+1);
				if(data.get("smeltXp").hashCode()+xpToAdd >= data.get("smeltXpNeeded").hashCode()) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lSMELTING &bto level: &c" + newLevel));
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("smeltLevel", data.get("smeltLevel").hashCode()+1).with("smeltXp", 0).with("smeltXpNeeded", Math.round(data.get("smeltXpNeeded").hashCode()*1.3))).run(Main.conn);
				}else {
					Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("smeltXp", data.get("smeltXp").hashCode() + xpToAdd)).run(Main.conn);
				}
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			if(e.getEntity() instanceof Monster || e.getEntity() instanceof Player) {
				if(p.getItemInHand().getType().equals(Material.DIAMOND_SWORD)
						|| p.getItemInHand().getType().equals(Material.GOLDEN_SWORD)
						|| p.getItemInHand().getType().equals(Material.IRON_SWORD)
						|| p.getItemInHand().getType().equals(Material.NETHERITE_SWORD)
						|| p.getItemInHand().getType().equals(Material.STONE_SWORD)
						|| p.getItemInHand().getType().equals(Material.WOODEN_SWORD)) {
					Integer xpToAdd = Utils.randomNum(1, 15);
					HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
					Integer newLevel = (data.get("swordLevel").hashCode()+1);
					if(data.get("swordXp").hashCode()+xpToAdd >= data.get("swordXpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lSWORD &bto level: &c" + newLevel));
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("swordLevel", data.get("swordLevel").hashCode()+1).with("swordXp", 0).with("swordXpNeeded", Math.round(data.get("swordXpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("swordXp", data.get("swordXp").hashCode() + xpToAdd)).run(Main.conn);
					}
				}
				
				
				else if(p.getItemInHand().getType().equals(Material.DIAMOND_AXE)
						|| p.getItemInHand().getType().equals(Material.GOLDEN_AXE)
						|| p.getItemInHand().getType().equals(Material.IRON_AXE)
						|| p.getItemInHand().getType().equals(Material.NETHERITE_AXE)
						|| p.getItemInHand().getType().equals(Material.STONE_AXE)
						|| p.getItemInHand().getType().equals(Material.WOODEN_AXE)) {
					Integer xpToAdd = Utils.randomNum(1, 15);
					HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
					Integer newLevel = (data.get("axeLevel").hashCode()+1);
					if(data.get("axeXp").hashCode()+xpToAdd >= data.get("axeXpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lAXE &bto level: &c" + newLevel));
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("axeLevel", data.get("axeLevel").hashCode()+1).with("axeXp", 0).with("axeXpNeeded", Math.round(data.get("axeXpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("axeXp", data.get("axeXp").hashCode() + xpToAdd)).run(Main.conn);
					}
				}
				
				
				else if(p.getItemInHand().getType().equals(Material.BOW)) {
					Integer xpToAdd = Utils.randomNum(1, 15);
					HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
					Integer newLevel = (data.get("bowLevel").hashCode()+1);
					if(data.get("bowXp").hashCode()+xpToAdd >= data.get("bowXpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lBOW &bto level: &c" + newLevel));
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("bowLevel", data.get("bowLevel").hashCode()+1).with("bowXp", 0).with("bowXpNeeded", Math.round(data.get("bowXpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("bowXp", data.get("bowXp").hashCode() + xpToAdd)).run(Main.conn);
					}
				}
				
				
				
				else if(p.getItemInHand().getType().equals(Material.AIR)) {
					Integer xpToAdd = Utils.randomNum(1, 15);
					HashMap data = Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).run(Main.conn);
					Integer newLevel = (data.get("handLevel").hashCode()+1);
					if(data.get("handXp").hashCode()+xpToAdd >= data.get("handXpNeeded").hashCode()) {
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						p.sendMessage(Utils.color("&8[&e&lLEVEL&8] &bYou leveled up &c&lHAND &bto level: &c" + newLevel));
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("handLevel", data.get("handLevel").hashCode()+1).with("handXp", 0).with("handXpNeeded", Math.round(data.get("handXpNeeded").hashCode()*1.3))).run(Main.conn);
					}else {
						Main.r.db("vibexo").table("skills").get(p.getUniqueId().toString()).update(Main.r.hashMap("handXp", data.get("handXp").hashCode() + xpToAdd)).run(Main.conn);
					}
				}
			}
		}
	}
	
	

}
