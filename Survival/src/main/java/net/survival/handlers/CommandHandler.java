package net.survival.handlers;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.survival.main.Main;
import net.survival.menus.QuestMenu;
import net.survival.menus.RtpMenu;
import net.survival.menus.SkillsMenu;
import net.survival.menus.WarpMenu;
import net.survival.utils.Utils;

public class CommandHandler implements Listener, CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;

	public CommandHandler(Main hub) {
		this.plugin = hub;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		final Player player = (Player) sender;
		if(sender.equals(player)){
			if (command.getName().equalsIgnoreCase("spawn")){
				player.sendMessage(Utils.color("&8[&e&lWARP&8] &eWarping to: &c&lSPAWN &ein &c&l3 &eseconds!"));
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
		    		public void run() {
		    			Location loc = new Location(Bukkit.getWorld("Lobby"), 26.5, 59, 4.5, 0, 0);
						player.teleport(loc);
		    		}
				}, 20 * 3);
				
				
			}else if (command.getName().equalsIgnoreCase("rtp")){
				RtpMenu.Menu(player);
				
				
			}else if (command.getName().equalsIgnoreCase("skills")){
				SkillsMenu.Menu(player);
				
				
			}else if (command.getName().equalsIgnoreCase("quests")){
				QuestMenu.Menu(player);
				
				
			}else if (command.getName().equalsIgnoreCase("warp")){
				WarpMenu.Menu(player);
				
				
			}else if (command.getName().equalsIgnoreCase("warps")){
				WarpMenu.Menu(player);
				
				
			}else if (command.getName().equalsIgnoreCase("ec")){
				player.openInventory(player.getEnderChest());
				
				
			}else if(command.getName().equalsIgnoreCase("setrank")) {
				HashMap data = Main.r.db("vibexo").table("players").get(player.getUniqueId().toString()).run(Main.conn);
				
				if(data.get("rankId").hashCode() >= Rank.MOD.getID() || player.isOp()) {
				
					switch(args.length) {
						case 0:
							player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eUsage: &b/setrank [playerName] [rank]"));
							break;
						case 1:
							player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eUsage: &b/setrank [playerName] [rank]"));
							break;
						case 2:
							if(Bukkit.getServer().getPlayer(args[0]) != null) {
							if(checkRank(args[1].toUpperCase())) {
								if(Rank.valueOf(args[1].toUpperCase()).getID() < data.get("rankId").hashCode() || player.isOp()) {
									Main.r.db("vibexo").table("players").get(Bukkit.getServer().getPlayer(args[0]).getUniqueId().toString()).update(Main.r.hashMap("rank", Rank.valueOf(args[1].toUpperCase()).getName()).with("rankId", Rank.valueOf(args[1].toUpperCase()).getID()).with("rankColor", Rank.valueOf(args[1].toUpperCase()).getColor())).run(Main.conn);
									Bukkit.getServer().getPlayer(args[0]).sendMessage(Utils.color("&8[&c&lRANKS&8] &eYou have been given the " + Rank.valueOf(args[1].toUpperCase()).getColor() + Rank.valueOf(args[1].toUpperCase()).getName() + " &erank!"));
									player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eYou have given the " + Rank.valueOf(args[1].toUpperCase()).getColor() + Rank.valueOf(args[1].toUpperCase()).getName() + " &erank to: &b&l" + Bukkit.getServer().getPlayer(args[0]).getName()));
									Bukkit.getServer().getPlayer(args[0]).setPlayerListName(Utils.color(Rank.valueOf(args[1].toUpperCase()).getColor() + "&l" + Rank.valueOf(args[1].toUpperCase()).getName() + " " + Rank.valueOf(args[1].toUpperCase()).getColor() + Bukkit.getServer().getPlayer(args[0]).getName()));
								}else {
									player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eYou do not have permission to give a rank higher than or equal to yours!"));
								}
							}else {
								player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eYou must supply a valid rank name!"));
							}
							}else {
								player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eYou must supply a valid player name!"));
							}
							
							
							break;
						default:
							player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eUsage: &b/setrank [playerName] [rank]"));
					}
				
				}else {
					player.sendMessage(Utils.color("&8[&c&lRANKS&8] &eYou do not have permission to set ranks!"));
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean checkRank(String val) {
		for(Rank rank: Rank.values()) {
			if(rank.getName().equals(val)) {
				return true;
			}
		}
		return false;
	}

}
