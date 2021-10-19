package net.survival.handlers;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class PingHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public PingHandler(Main hub) {
		PingHandler.plugin = hub;
	}
	
	

	@EventHandler
	public void onDeath(ServerListPingEvent e) {
		e.setMaxPlayers((Bukkit.getServer().getOnlinePlayers().size()+1));
		e.setMotd(Utils.color("             &e&lVIBE&b&lXO &e&lNETWORK &7[1.17+]" + "\n" + "     &7Completely custom coded survival server!"));
	}
	

}
