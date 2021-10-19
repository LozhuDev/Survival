package net.survival.handlers;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import net.survival.main.Main;
import net.survival.utils.HoloGrams;
import net.survival.utils.Utils;

@SuppressWarnings("deprecation")
public class CrateHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public CrateHandler(Main hub) {
		CrateHandler.plugin = hub;
	}
	
	public static HashMap<String, BukkitTask> bulletMap1 = new HashMap<String, BukkitTask>();
	public static HashMap<String, BukkitTask> bulletMap2 = new HashMap<String, BukkitTask>();
	public static HashMap<String, BukkitTask> bulletMap3 = new HashMap<String, BukkitTask>();
	public static HashMap<String, String> crate1 = new HashMap<String, String>();
	public static HashMap<String, String> crate2 = new HashMap<String, String>();
	public static HashMap<String, String> crate3 = new HashMap<String, String>();
	
	public static HashMap<String, Item> item1 = new HashMap<String, Item>();
	public static HashMap<String, Item> item2 = new HashMap<String, Item>();
	public static HashMap<String, Item> item3 = new HashMap<String, Item>();
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getHand() == EquipmentSlot.HAND){
					if (e.getClickedBlock() != null) {
						if (e.getClickedBlock().getType() == Material.CHEST){
							HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
							if(data.get("crateKeys").hashCode() >= 1) {
								Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).update(Main.r.hashMap("crateKeys", (data.get("crateKeys").hashCode()-1))).run(Main.conn);
							Location loc1 = new Location(Bukkit.getWorld("Lobby"), 46, 58, 12);
							Location loc2 = new Location(Bukkit.getWorld("Lobby"), 46, 58, 15);
							Location loc3 = new Location(Bukkit.getWorld("Lobby"), 46, 58, 18);
							if(p.getWorld().equals(Bukkit.getWorld("Lobby"))) {
								e.setCancelled(true);
								
								
								if(e.getClickedBlock().getLocation().equals(loc1)) {
									if(!crate1.containsKey("inUse")) {
										final ShulkerBullet bullet1 = (ShulkerBullet) e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 1.5, 0.5), ShulkerBullet.class);
										runCrate(p, e.getClickedBlock(), crate1, 1, bullet1, bulletMap1, item1);
									}else {
										p.sendMessage(Utils.color("&cThis crate is in use!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(loc2)) {
									if(!crate2.containsKey("inUse")) {
										final ShulkerBullet bullet2 = (ShulkerBullet) e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 1.5, 0.5), ShulkerBullet.class);
										runCrate(p, e.getClickedBlock(), crate2, 2, bullet2, bulletMap2, item2);
									}else {
										p.sendMessage(Utils.color("&cThis crate is in use!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(loc3)) {
									if(!crate3.containsKey("inUse")) {
										final ShulkerBullet bullet3 = (ShulkerBullet) e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 1.5, 0.5), ShulkerBullet.class);
										runCrate(p, e.getClickedBlock(), crate3, 3, bullet3, bulletMap3, item3);
									}else {
										p.sendMessage(Utils.color("&cThis crate is in use!"));
									}
								}
							}
							}else {
								e.setCancelled(true);
								p.sendMessage(Utils.color("&8[&b&lCRATE&8]&e You dont have enough &c&lCRATE KEYS"));
							}
							}
				
					}
				}
			}
	}
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void runCrate(Player p, Block block, HashMap map, int hologramnum, ShulkerBullet bullet, HashMap map1, HashMap item) {
		HoloGrams.renameHoloGram(Utils.color("&eCalculating Reward"), hologramnum);
		map.put("inUse", "true");
		bullet.setGravity(false);
		p.playSound(block.getLocation(), Sound.ENTITY_SHULKER_OPEN, Integer.MAX_VALUE, Integer.MAX_VALUE);
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		map1.put("particles", scheduler.runTaskTimer(plugin, new Runnable() {
			public void run() {
				bullet.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, bullet.getLocation().add(0, 0.2, 0), 0);
				bullet.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, bullet.getLocation().add(0, 0.2, 0), 0);
				bullet.getWorld().spawnParticle(Particle.PORTAL, bullet.getLocation().add(0, 0.2, 0), 1);
				bullet.getWorld().spawnParticle(Particle.NAUTILUS, bullet.getLocation().add(0, 0.2, 0), 0);
				bullet.getWorld().spawnParticle(Particle.SOUL, bullet.getLocation().add(0, 0.2, 0), 1);
			}
}, 0, 20L));
		scheduler.runTaskLater(plugin, new Runnable() {
			public void run() {
				BukkitTask run = (BukkitTask) map1.get("particles");
				run.cancel();
				if(block.getType().equals(Material.CHEST)) {
					Chest chest = (Chest) block.getState();
					chest.open();
					p.sendMessage(Utils.color("&8[&b&lCRATE&8] &eCrate reward: &b&lREWARD HERE"));
					
					
					
					Item item2 = block.getWorld().dropItem(block.getLocation().add(0.5, 1, 0.5), Utils.createItem(Material.DIAMOND_SWORD, 1, 0, Utils.color("&cNoPickup"), null));
					item2.setVelocity(new Vector(0,0,0));
					item.put("item", item2);
					HoloGrams.renameHoloGram(Utils.color("&eReward Name"), hologramnum);
					p.playSound(block.getLocation(), Sound.ENTITY_ITEM_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
					
				}
				bullet.setGravity(true);
				bullet.getWorld().spawnParticle(Particle.SMOKE_NORMAL, bullet.getLocation().add(0, 0.2, 0), 1);
			}
}, 5 * 20);
		scheduler.runTaskLater(plugin, new Runnable() {
			public void run() {
				bullet.remove();
				map.remove("inUse");
				if(block.getType().equals(Material.CHEST)) {
					Chest chest = (Chest) block.getState();
					chest.close();
					Item item1 = (Item) item.get("item");
					item1.remove();
					HoloGrams.renameHoloGram(Utils.color("&8---[ &b&lCRATE &8]---"), hologramnum);
				}
			}
}, 10 * 20);
	}
	
	
	
	
	public void randomItem() {
		int num = Utils.randomNum(1, 10);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if(e.getItem().getItemStack().getItemMeta().getDisplayName().equals(Utils.color("&cNoPickup"))) {
			e.setCancelled(true);
		}
	}

}
