package net.survival.main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import net.survival.handlers.BuildHandler;
import net.survival.handlers.ChatHandler;
import net.survival.handlers.CommandHandler;
import net.survival.handlers.CrateHandler;
import net.survival.handlers.DamageHandler;
import net.survival.handlers.DeathHandler;
import net.survival.handlers.DropHandler;
import net.survival.handlers.HungerHandler;
import net.survival.handlers.InventoryHandler;
import net.survival.handlers.LevelHandler;
import net.survival.handlers.MenuHandler;
import net.survival.handlers.MineCrateHandler;
import net.survival.handlers.MoveHandler;
import net.survival.handlers.PingHandler;
import net.survival.handlers.QuestHandler;
import net.survival.handlers.ScoreboardHandler;
import net.survival.handlers.SkillsHandler;
import net.survival.handlers.WeatherHandler;
import net.survival.menus.QuestMenu;
import net.survival.menus.RtpMenu;
import net.survival.menus.SkillsMenu;
import net.survival.menus.SurvivalMenu;
import net.survival.menus.WarpMenu;
import net.survival.utils.HoloGrams;
import net.survival.utils.Packets;
import net.survival.utils.Utils;

public class Main extends JavaPlugin implements Listener{

	public static final RethinkDB r = RethinkDB.r;
	public static Connection conn = r.connection().hostname("localhost").db("vibexo").port(28015).connect();
	
	public void onEnable(){
		Listeners();
		Commands();
		ScoreboardHandler.boardUpdater();
		Bukkit.getConsoleSender().sendMessage(Utils.color("&8[&bDATABASE&8] &a" + conn.db()));
		List<Entity> entities = Bukkit.getWorld("Lobby").getEntities();
		for ( Entity entity : entities){
			if(entity != null) {
				if(!(entity instanceof Player)){
					entity.remove();
				}
			}
		}
		Bukkit.getConsoleSender().sendMessage(Utils.color("&8[&eSURVIVAL&8] &aEnabled!"));
		final Location loc = new Location(Bukkit.getWorld("Lobby"), 43.5, 59, 15.5, 0, 0);
		final Location loc2 = new Location(Bukkit.getWorld("Lobby"), 46.5, 59, 12.5, 0, 0);
		final Location loc3 = new Location(Bukkit.getWorld("Lobby"), 46.5, 59, 15.5, 0, 0);
		final Location loc4 = new Location(Bukkit.getWorld("Lobby"), 46.5, 59, 18.5, 0, 0);
		final Location loc1 = new Location(Bukkit.getWorld("Lobby"), 32.5, 58.5, 24.5, 0, 0);
		HoloGrams.createHoloGram(loc2, Utils.color("&8---[ &b&lCRATE &8]---"), 1, true, false, null, null, null);
		HoloGrams.createHoloGram(loc3, Utils.color("&8---[ &b&lCRATE &8]---"), 2, true, false, null, null, null);
		HoloGrams.createHoloGram(loc4, Utils.color("&8---[ &b&lCRATE &8]---"), 3, true, false, null, null, null);
		HoloGrams.createHoloGram(loc1, Utils.color("&8---[ &c&lENCHANTMENTS &8]---"), 5, true, false, null, null, null);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			double y = 0;
    		@SuppressWarnings("deprecation")
			public void run() {
    			
    			
    			if(y > 4){
    				y=0;
    			}
    				y = y + 0.3;
    				double a = 5 * Math.cos(y + 5);
    		        double b = 5 * Math.sin(y + 5);
    		        double c = 5 * Math.cos(y + 10);
    		        double d = 5 * Math.sin(y + 10);
    		        double e = 5 * Math.cos(y + 15);
    		        double f = 5 * Math.sin(y + 15);
    		        double g = 5 * Math.cos(y + 20);
    		        double h = 5 * Math.sin(y + 20);
    		        double i = 5 * Math.cos(y + 25);
    		        double j = 5 * Math.sin(y + 25);
    			for(Player p : Bukkit.getOnlinePlayers()) {
    				
    				Packets.sendActionBar(p, Utils.color("&c❤ " + Math.round(p.getHealth()) + "/" + Math.round(p.getMaxHealth()) + "      " + Utils.color("&b⚡ 20/20")));
    				loc.getWorld().spawnParticle(Particle.PORTAL, loc.getX() + a, loc.getY() + y, loc.getZ() + b, 0);
    				loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX() + a, loc.getY() + y, loc.getZ() + b, 0);
    				loc.getWorld().spawnParticle(Particle.PORTAL, loc.getX() + c, loc.getY() + y, loc.getZ() + d, 0);
    				loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX() + c, loc.getY() + y, loc.getZ() + d, 0);
    				loc.getWorld().spawnParticle(Particle.PORTAL, loc.getX() + e, loc.getY() + y, loc.getZ() + f, 0);
    				loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX() + e, loc.getY() + y, loc.getZ() + f, 0);
    				loc.getWorld().spawnParticle(Particle.PORTAL, loc.getX() + g, loc.getY() + y, loc.getZ() + h, 0);
    				loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX() + g, loc.getY() + y, loc.getZ() + h, 0);
    				loc.getWorld().spawnParticle(Particle.PORTAL, loc.getX() + i, loc.getY() + y, loc.getZ() + j, 0);
    				loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX() + i, loc.getY() + y, loc.getZ() + j, 0);
    				
    				loc1.getWorld().spawnParticle(Particle.PORTAL, loc1.getX() + a, loc1.getY() + y, loc1.getZ() + b, 0);
    				loc1.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc1.getX() + a, loc1.getY() + y, loc1.getZ() + b, 0);
    				loc1.getWorld().spawnParticle(Particle.PORTAL, loc1.getX() + c, loc1.getY() + y, loc1.getZ() + d, 0);
    				loc1.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc1.getX() + c, loc1.getY() + y, loc1.getZ() + d, 0);
    				loc1.getWorld().spawnParticle(Particle.PORTAL, loc1.getX() + e, loc1.getY() + y, loc1.getZ() + f, 0);
    				loc1.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc1.getX() + e, loc1.getY() + y, loc1.getZ() + f, 0);
    				loc1.getWorld().spawnParticle(Particle.PORTAL, loc1.getX() + g, loc1.getY() + y, loc1.getZ() + h, 0);
    				loc1.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc1.getX() + g, loc1.getY() + y, loc1.getZ() + h, 0);
    				loc1.getWorld().spawnParticle(Particle.PORTAL, loc1.getX() + i, loc1.getY() + y, loc1.getZ() + j, 0);
    				loc1.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc1.getX() + i, loc1.getY() + y, loc1.getZ() + j, 0);
    				if(p.getWorld().getName().equals("Lobby") && !p.getGameMode().equals(GameMode.CREATIVE)) {
    					p.setGameMode(GameMode.ADVENTURE);
    				}else if(p.getWorld().getName().equals("world") && !p.getGameMode().equals(GameMode.CREATIVE)) {
    					p.setGameMode(GameMode.SURVIVAL);
    				}
    			}
    		}
		}, 0, 10);
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(Utils.color("&8[&eSURVIVAL&8] &cDisabled!"));
		List<Entity> entities = Bukkit.getWorld("Lobby").getEntities();
		for ( Entity entity : entities){
			if(!(entity instanceof Player)){
				entity.remove();
			}
		}
	}
	
	public void Listeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Utils(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerLeave(this), this);
		pm.registerEvents(new HungerHandler(this), this);
		pm.registerEvents(new InventoryHandler(this), this);
		pm.registerEvents(new SurvivalMenu(this), this);
		pm.registerEvents(new Packets(this), this);
		pm.registerEvents(new MenuHandler(this), this);
		pm.registerEvents(new DeathHandler(this), this);
		pm.registerEvents(new DropHandler(this), this);
		pm.registerEvents(new BuildHandler(this), this);
		pm.registerEvents(new MoveHandler(this), this);
		pm.registerEvents(new DamageHandler(this), this);
		pm.registerEvents(new WeatherHandler(this), this);
		pm.registerEvents(new HoloGrams(this), this);
		pm.registerEvents(new ChatHandler(this), this);
		pm.registerEvents(new CrateHandler(this), this);
		pm.registerEvents(new ScoreboardHandler(this), this);
		pm.registerEvents(new LevelHandler(this), this);
		pm.registerEvents(new WarpMenu(this), this);
		pm.registerEvents(new PingHandler(this), this);
		pm.registerEvents(new SkillsHandler(this), this);
		pm.registerEvents(new SkillsMenu(this), this);
		pm.registerEvents(new QuestMenu(this), this);
		pm.registerEvents(new QuestHandler(this), this);
		pm.registerEvents(new MineCrateHandler(this), this);
		pm.registerEvents(new RtpMenu(this), this);
	}
	
	public void Commands(){
		getCommand("spawn").setExecutor(new CommandHandler(this));
		getCommand("rtp").setExecutor(new CommandHandler(this));
		getCommand("setrank").setExecutor(new CommandHandler(this));
		getCommand("ec").setExecutor(new CommandHandler(this));
		getCommand("skills").setExecutor(new CommandHandler(this));
		getCommand("quests").setExecutor(new CommandHandler(this));
		getCommand("warp").setExecutor(new CommandHandler(this));
		getCommand("warps").setExecutor(new CommandHandler(this));
	}
	
}
