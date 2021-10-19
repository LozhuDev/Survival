package net.survival.utils;


import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.survival.main.Main;

public class Packets implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public Packets(Main hub) {
		Packets.plugin = hub;
	}

	public static void sendTabTitle(Player player, String header1, String footer1) {
		player.setPlayerListHeaderFooter(header1, footer1);
	}

	public static void sendTitle(Player player, String titlestr, String subtitlestr) {
		player.sendTitle(titlestr, subtitlestr, 20 * 1, 20 * 3, 20 * 1);
	}
	
	public static void sendActionBar(Player player, String message) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
	}
	
	
	
	
}
