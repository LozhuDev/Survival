package net.survival.main;

import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.survival.utils.Utils;

public class PlayerLeave implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public PlayerLeave(Main hub) {
		PlayerLeave.plugin = hub;
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		HashMap data1 = Main.r.db("vibexo").table("players").get(e.getPlayer().getUniqueId().toString()).run(Main.conn);
		e.setQuitMessage(Utils.color("&8[&c-&8] " + data1.get("rankColor") + "&l" + data1.get("rank") + " " + data1.get("rankColor") + e.getPlayer().getName()));
	}

}
