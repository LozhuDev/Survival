package net.survival.handlers;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import net.survival.main.Main;
import net.survival.utils.Utils;

public class ScoreboardHandler implements Listener{
	
	private static Main plugin;

	public ScoreboardHandler(Main hub) {
		ScoreboardHandler.plugin = hub;
	}
	
	public static Scoreboard board;
	public static Objective objective;

    @SuppressWarnings("deprecation")
	public static void makeScoreBoard(Player p){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        board = scoreboardManager.getNewScoreboard();
        objective = board.registerNewObjective("lobby1","dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(Utils.color("&e&lVIBE&b&lXO"));
        Score score1 = objective.getScore(ChatColor.AQUA + "");
        score1.setScore(15);
        Score score = objective.getScore(ChatColor.BLACK + "");
        score.setScore(14);
        Score score2 = objective.getScore(ChatColor.BLUE + "");
        score2.setScore(13);
        Score score3 = objective.getScore(ChatColor.WHITE + "");
        score3.setScore(12);
        Score score4 = objective.getScore(ChatColor.DARK_AQUA + "");
        score4.setScore(11);
        Score score5 = objective.getScore(ChatColor.DARK_BLUE + "");
        score5.setScore(10);
        Score score6 = objective.getScore(ChatColor.DARK_GRAY + "");
        score6.setScore(9);
        Score score7 = objective.getScore(ChatColor.DARK_GREEN + "");
        score7.setScore(8);
        /*Score score8 = objective.getScore(ChatColor.DARK_PURPLE + "");
        score8.setScore(7);
        Score score9 = objective.getScore(ChatColor.DARK_RED + "");
        score9.setScore(6);
        Score score10 = objective.getScore(ChatColor.GOLD + "");
        score10.setScore(5);
        Score score11 = objective.getScore(ChatColor.GRAY + "");
        score11.setScore(4);
        Score score12 = objective.getScore(ChatColor.GREEN + "");
        score12.setScore(3);
        Score score13 = objective.getScore(ChatColor.LIGHT_PURPLE + "");
        score13.setScore(2);
        Score score14 = objective.getScore(ChatColor.RED + "");
        score14.setScore(1);*/
        
        Team team1 = board.registerNewTeam("team1");
        team1.addEntry(ChatColor.AQUA + "");
        
        Team team2 = board.registerNewTeam("team2");
        team2.addEntry(ChatColor.BLACK + "");

        Team team3 = board.registerNewTeam("team3");
        team3.addEntry(ChatColor.BLUE + "");
        
        Team team4 = board.registerNewTeam("team4");
        team4.addEntry(ChatColor.WHITE + "");
        
        Team team5 = board.registerNewTeam("team5");
        team5.addEntry(ChatColor.DARK_AQUA + "");
		
		Team team6 = board.registerNewTeam("team6");
        team6.addEntry(ChatColor.DARK_BLUE + "");
        
        Team team7 = board.registerNewTeam("team7");
        team7.addEntry(ChatColor.DARK_GRAY + "");

        Team team8 = board.registerNewTeam("team8");
        team8.addEntry(ChatColor.DARK_GREEN + "");
        
        /*Team team9 = board.registerNewTeam("team9");
        team9.addEntry(ChatColor.DARK_PURPLE + "");
        
        Team team10 = board.registerNewTeam("team10");
        team10.addEntry(ChatColor.DARK_RED + "");
        
        Team team11 = board.registerNewTeam("team11");
        team11.addEntry(ChatColor.GOLD + "");
        
        Team team12 = board.registerNewTeam("team12");
        team12.addEntry(ChatColor.GRAY + "");
        Team team13 = board.registerNewTeam("team13");
        team13.addEntry(ChatColor.GREEN + "");
        
        Team team14 = board.registerNewTeam("team14");
        team14.addEntry(ChatColor.LIGHT_PURPLE + "");
        
        Team team15 = board.registerNewTeam("team15");
        team15.addEntry(ChatColor.RED + "");*/
        p.setScoreboard(board);
    }
    
    
    public static void boardUpdater(){
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
        		public void run() {
        			
        			for(final Player p : Bukkit.getOnlinePlayers()){
        				if(!(p.equals(null))){
        					
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&6&lV&e&lIBE&b&lXO"));
        			    			}
        			    		}
        					}, 3);
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&e&lV&6&lI&e&lBE&b&lXO"));
        			    			}
        			    		}
        					}, 6);
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&e&lVI&6&lB&e&lE&b&lXO"));
        			    			}
        			    		}
        					}, 9);
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&e&lVIB&6&lE&b&lXO"));
        			    			}
        			    		}
        					}, 12);
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&e&lVIBE&9&lX&b&lO"));
        			    			}
        			    		}
        					}, 15);
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&e&lVIBE&b&lX&9&lO"));
        			    			}
        			    		}
        					}, 18);
        					
        					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			    		public void run() {
        			    			if(p.getScoreboard().getObjective("lobby1") != null) {
        			    				p.getScoreboard().getObjective("lobby1").setDisplayName(Utils.color("&e&lVIBE&b&lXO"));
        			    			}
        			    		}
        					}, 20);
        					
        					
        					
        					
        					
        					
        					
        					@SuppressWarnings("rawtypes")
							HashMap data = Main.r.db("vibexo").table("players").get(p.getUniqueId().toString()).run(Main.conn);
        					
        					Team team1 = p.getScoreboard().getTeam("team1");
            				team1.setPrefix(Utils.color(" "));
            				team1.setSuffix(Utils.color(" "));

            				Team team2 = p.getScoreboard().getTeam("team2");
            				team2.setPrefix(Utils.color("&7Level:"));
            				team2.setSuffix(Utils.color(" &e" + data.get("level")));
            				
            				Team team3 = p.getScoreboard().getTeam("team3");
            				team3.setPrefix(Utils.color("&7Xp:"));
            				team3.setSuffix(Utils.color(" &b" + data.get("xp") + "&7/&b" + data.get("xpNeeded")));
            				
            				Team team4 = p.getScoreboard().getTeam("team4");
            				team4.setPrefix(Utils.color("&7Coins:"));
            				team4.setSuffix(Utils.color(" &e" + data.get("coins")));

            				Team team5 = p.getScoreboard().getTeam("team5");
            				team5.setPrefix(Utils.color("&7Shards:"));
            				team5.setSuffix(Utils.color(" &5" + data.get("shards")));
        			
            				Team team6 = p.getScoreboard().getTeam("team6"); 
            				team6.setPrefix(Utils.color("&7Crate Keys:"));
            				team6.setSuffix(Utils.color(" &c" + data.get("crateKeys")));
    				
            				Team team7 = p.getScoreboard().getTeam("team7");
            				team7.setPrefix(Utils.color("    "));
            				team7.setSuffix(Utils.color(""));
    				
            				Team team8 = p.getScoreboard().getTeam("team8");
            				team8.setPrefix(Utils.color("&evibexo.io"));
            				team8.setSuffix(Utils.color(""));
    				
            				/*Team team9 = p.getScoreboard().getTeam("team9");
            				team9.setPrefix(Utils.color("9"));
            				team9.setSuffix(Utils.color(""));
    				
            				Team team10 = p.getScoreboard().getTeam("team10");
            				team10.setPrefix(Utils.color("10"));
            				team10.setSuffix(Utils.color(""));
    				
            				Team team11 = p.getScoreboard().getTeam("team11");
            				team11.setPrefix(Utils.color("11"));
            				team11.setSuffix(Utils.color(""));
        			
            				Team team12 = p.getScoreboard().getTeam("team12"); 
            				team12.setPrefix(Utils.color("12"));
            				team12.setSuffix(Utils.color(""));
    				
            				Team team13 = p.getScoreboard().getTeam("team13");
            				team13.setPrefix(Utils.color("13"));
            				team13.setSuffix(Utils.color(""));
    				
            				Team team14 = p.getScoreboard().getTeam("team14");
            				team14.setPrefix(Utils.color("14"));
            				team14.setSuffix(Utils.color(""));
    				
            				Team team15 = p.getScoreboard().getTeam("team15");
            				team15.setPrefix(Utils.color("15"));
            				team15.setSuffix(Utils.color(""));*/
        					}
        				}
        			}
            	}, 0, 20 * 3);
					//END OF SCOREBOARD DISPLAYNAME
    }
}