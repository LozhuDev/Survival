package net.survival.handlers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class ChatHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public ChatHandler(Main hub) {
		ChatHandler.plugin = hub;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onDeath(AsyncPlayerChatEvent e) {
		HashMap data = Main.r.db("vibexo").table("players").get(e.getPlayer().getUniqueId().toString()).run(Main.conn);
		e.setFormat(Utils.color("&8&l[&e" + data.get("level") + "&8&l][" + data.get("rankColor") + "&l" + data.get("rank") + "&8&l]" + data.get("rankColor") + e.getPlayer().getName() + " " + data.get("chatColor")) + e.getMessage());
	}
	
	@SuppressWarnings("rawtypes")
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();
            if (e.getMessage().startsWith("/help")) {
                    e.getPlayer().sendMessage(Utils.color("&c&lTHIS COMMAND IS COMING SOON"));
                    e.setCancelled(true);
            }else if(e.getMessage().startsWith("/kick")) {
				HashMap data = Main.r.db("vibexo").table("players").get(player.getUniqueId().toString()).run(Main.conn);
				if(data.get("rankId").hashCode() >= Rank.MOD.getID() || player.isOp()) {
					
				
					
					
					if(e.getMessage().split(" ").length >= 2) {
						String[] args = e.getMessage().split(" ");
						
						if(args.length == 0 || args.length == 1) {
							player.sendMessage(Utils.color("&8[&c&lKICK&8] &eUsage: &b/kick [playerName] [reason]"));
						}else if(args.length == 2) {
							player.sendMessage(Utils.color("&8[&c&lKICK&8] &eYou must supply a reason!"));
						}else if(args.length == 3 || args.length >= 3) {
							if(Bukkit.getServer().getPlayer(args[1]) != null) {
								HashMap data1 = Main.r.db("vibexo").table("players").get(Bukkit.getServer().getPlayer(args[1]).getUniqueId().toString()).run(Main.conn);
									if(data1.get("rankId").hashCode() < data.get("rankId").hashCode() || player.isOp()) {
										
									    String[] reason = e.getMessage().split(" ", 3);
									    DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
								    	String dateString2 = dateFormat2.format(new Date()).toString(); 
									    
									    Bukkit.getServer().getPlayer(args[1]).kickPlayer(Utils.color("&c&lYOU HAVE BEEN KICKED!" + "\n \n" + "&8Reason: &e" + reason[2] + "\n" + "&8Kicked By: &e" + data.get("rankColor") + "&l" + data.get("rank") + data.get("rankColor") + " " + player.getName() + "\n" + "&8Date: &a" + dateString2));
										
									}else {
										player.sendMessage(Utils.color("&8[&c&lKICK&8] &eYou do not have permission to kick a player that has a rank higher than or equal to yours!"));
									}
								}else {
									player.sendMessage(Utils.color("&8[&c&lKICK&8] &eYou must supply a valid player name!"));
								}
						}
					}else {
						player.sendMessage(Utils.color("&8[&c&lKICK&8] &eUsage: &b/kick [playerName] [reason]"));
					}
				
					
					
					
					
				}else {
					player.sendMessage(Utils.color("&8[&c&lKICK&8] &eYou do not have permission to kick players!"));
				}
            	e.setCancelled(true);
            }
    }


}
