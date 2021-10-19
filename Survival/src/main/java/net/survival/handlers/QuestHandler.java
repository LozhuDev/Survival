package net.survival.handlers;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class QuestHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public QuestHandler(Main hub) {
		QuestHandler.plugin = hub;
		particleHandler();
	}
	
	
	Location skull1 = new Location(Bukkit.getWorld("Lobby"), 67, 60, 0);
	Location skull2 = new Location(Bukkit.getWorld("Lobby"), 0, 70, 25);
	Location skull3 = new Location(Bukkit.getWorld("Lobby"), -16, 110, 24);
	Location skull4 = new Location(Bukkit.getWorld("Lobby"), 13, 57, -44);
	Location skull5 = new Location(Bukkit.getWorld("Lobby"), -28, 55, 3);
	Location skull6 = new Location(Bukkit.getWorld("Lobby"), 0, 58, 5);
	Location skull7 = new Location(Bukkit.getWorld("Lobby"), -32, 68, 36);
	Location skull8 = new Location(Bukkit.getWorld("Lobby"), 19, 68, 42);
	Location skull9 = new Location(Bukkit.getWorld("Lobby"), -46, 95, 27);
	Location skull10 = new Location(Bukkit.getWorld("Lobby"), -24, 74, -10);

	
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getHand() == EquipmentSlot.HAND){
					if (e.getClickedBlock().getType() != null) {
						if (e.getClickedBlock().getType() == Material.SKELETON_SKULL){
							if(p.getWorld().equals(Bukkit.getWorld("Lobby"))) {
								
							
								if(e.getClickedBlock().getLocation().equals(skull1)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull1").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull1", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull2)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull2").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull2", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull3)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull3").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull3", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull4)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull4").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull4", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull5)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull5").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull5", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull6)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull6").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull6", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull7)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull7").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull7", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull8)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull8").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull8", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull9)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull9").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull9", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}else if(e.getClickedBlock().getLocation().equals(skull10)) {
									HashMap data = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
									if(data.get("skull10").equals(false)) {
										Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).update(Main.r.hashMap("skull10", true).with("skullsObtained", (data.get("skullsObtained").hashCode()+1))).run(Main.conn);
										p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
										HashMap data1 = Main.r.db("vibexo").table("quests").get(p.getUniqueId().toString()).run(Main.conn);
										p.setMaxHealth(20+(data1.get("skullsObtained").hashCode()*2));
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &bYou found a skull for the &c&lHEALTH QUEST"));
									}else {
										p.sendMessage(Utils.color("&8[&b&lQUEST&8] &cYou have already gotten that skull!"));
									}
								}

								
								
							}
						}
					}
				}
			}
	}
	
	
	public void particleHandler() {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    	    		public void run() {
    	    			skull1.getWorld().spawnParticle(Particle.HEART, skull1.getX() + 0.5, skull1.getY() + 1, skull1.getZ() + 0.5, 0);
    					skull2.getWorld().spawnParticle(Particle.HEART, skull2.getX() + 0.5, skull2.getY() + 1, skull2.getZ() + 0.5, 0);
    					skull3.getWorld().spawnParticle(Particle.HEART, skull3.getX() + 0.5, skull3.getY() + 1, skull3.getZ() + 0.5, 0);
    					skull4.getWorld().spawnParticle(Particle.HEART, skull4.getX() + 0.5, skull4.getY() + 1, skull4.getZ() + 0.5, 0);
    					skull5.getWorld().spawnParticle(Particle.HEART, skull5.getX() + 0.5, skull5.getY() + 1, skull5.getZ() + 0.5, 0);
    					skull6.getWorld().spawnParticle(Particle.HEART, skull6.getX() + 0.5, skull6.getY() + 1, skull6.getZ() + 0.5, 0);
    					skull7.getWorld().spawnParticle(Particle.HEART, skull7.getX() + 0.5, skull7.getY() + 1, skull7.getZ() + 0.5, 0);
    					skull8.getWorld().spawnParticle(Particle.HEART, skull8.getX() + 0.5, skull8.getY() + 1, skull8.getZ() + 0.5, 0);
    					skull9.getWorld().spawnParticle(Particle.HEART, skull9.getX() + 0.5, skull9.getY() + 1, skull9.getZ() + 0.5, 0);
    					skull10.getWorld().spawnParticle(Particle.HEART, skull10.getX() + 0.5, skull10.getY() + 1, skull10.getZ() + 0.5, 0);
    	    		}
    			}, 0, 10);
    		}
		}, 40);
	}

}
