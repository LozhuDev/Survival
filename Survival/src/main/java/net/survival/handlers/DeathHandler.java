package net.survival.handlers;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class DeathHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public DeathHandler(Main hub) {
		DeathHandler.plugin = hub;
	}
	
	
	@EventHandler
	public void onDeath(PlayerRespawnEvent e) {
		Location loc = new Location(Bukkit.getWorld("Lobby"), 26.5, 59, 4.5, 0, 0);
		e.getPlayer().teleport(loc);
		e.getPlayer().getInventory().setItem(8, Utils.createItem(Material.NETHER_STAR, 1, 0, Utils.color("&8[&eSurvival Menu&8]"), Arrays.asList("", Utils.color("&cThis item cannot be moved!"))));
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			HashMap data1 = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
			Bukkit.getServer().broadcastMessage(Utils.color(data1.get("rankColor") + "&l" + data1.get("rank") + " " + data1.get("rankColor") + p.getName() + " &ehas died from: &c" + p.getLastDamageCause().getCause().toString()));
		}
	}
	
	@EventHandler
	public void removeDeathMSG(PlayerDeathEvent e) {
		e.setDeathMessage("");
	}

}
