package net.survival.main;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.survival.handlers.ScoreboardHandler;
import net.survival.utils.Packets;
import net.survival.utils.Utils;

public class PlayerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public PlayerJoin(Main hub) {
		PlayerJoin.plugin = hub;
	}
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Main.r.db("vibexo").table("players").get(e.getPlayer().getUniqueId().toString()).run(Main.conn) == null) {
			Main.r.table("players").insert(Main.r.array(Main.r.hashMap("id", e.getPlayer().getUniqueId().toString()).with("username", e.getPlayer().getName()).with("rank", "MEMBER").with("rankId", 0).with("bannedBy", "none").with("banDate", "none").with("unbanDate", 0).with("banLength", "none").with("bans", Main.r.array()).with("banned", false).with("banReason", "Not Banned!").with("rankColor", "&f").with("chatColor", "&f").with("level", 1).with("xp", 0).with("xpNeeded", 100).with("shards", 0).with("coins", 0).with("crateKeys", 0))).run(Main.conn);
		}else {
			HashMap data = Main.r.db("vibexo").table("players").get(e.getPlayer().getUniqueId().toString()).run(Main.conn);
			if(data.get("banned").equals(true)) {
				e.getPlayer().kickPlayer(Utils.color("&c&lYOU HAVE BEEN BANNED!" + "\n \n" + "&8Reason: &e" + data.get("banReason") + "\n" + "&8Banned By:&e" + data.get("bannedBy") + "\n" + "&8Ban Date:&e" + data.get("banDate") + "\n \n" + "&8Punishment Length:&e" + data.get("banLength") + "\n \n" + "&8If you feel like this ban was a mistake or unnecessary please appeal in our discord: &bDISCORD LINK HERE"));
			}
		}
		
		if(Main.r.db("vibexo").table("skills").get(e.getPlayer().getUniqueId().toString()).run(Main.conn) == null) {
			Main.r.table("skills").insert(Main.r.array(Main.r.hashMap("id", e.getPlayer().getUniqueId().toString()).with("username", e.getPlayer().getName()).with("mineLevel", 1).with("mineXp", 0).with("mineXpNeeded", 100).with("woodLevel", 1).with("woodXp", 0).with("woodXpNeeded", 100).with("digLevel", 1).with("digXp", 0).with("digXpNeeded", 100).with("fishLevel", 1).with("fishXp", 0).with("fishXpNeeded", 100).with("farmLevel", 1).with("farmXp", 0).with("farmXpNeeded", 100).with("handLevel", 1).with("handXp", 0).with("handXpNeeded", 100).with("bowLevel", 1).with("bowXp", 0).with("bowXpNeeded", 100).with("swordLevel", 1).with("swordXp", 0).with("swordXpNeeded", 100).with("axeLevel", 1).with("axeXp", 0).with("axeXpNeeded", 100).with("smeltLevel", 1).with("smeltXp", 0).with("smeltXpNeeded", 100).with("brewLevel", 1).with("brewXp", 0).with("brewXpNeeded", 100).with("repairLevel", 1).with("repairXp", 0).with("repairXpNeeded", 100))).run(Main.conn);
		}
		
		if(Main.r.db("vibexo").table("quests").get(e.getPlayer().getUniqueId().toString()).run(Main.conn) == null) {
			Main.r.table("quests").insert(Main.r.array(Main.r.hashMap("id", e.getPlayer().getUniqueId().toString()).with("username", e.getPlayer().getName()).with("skullsObtained", 0).with("skullsNeeded", 10).with("skull1", false).with("skull2", false).with("skull3", false).with("skull4", false).with("skull5", false).with("skull6", false).with("skull7", false).with("skull8", false).with("skull9", false).with("skull10", false))).run(Main.conn);
		}
		
		if(!e.getPlayer().hasPlayedBefore()) {
			Location loc = new Location(Bukkit.getWorld("Lobby"), 26.5, 59, 4.5, 0, 0);
			e.getPlayer().teleport(loc);
		}
		HashMap data1 = Main.r.db("vibexo").table("players").get(e.getPlayer().getUniqueId().toString()).run(Main.conn);
		e.setJoinMessage(Utils.color("&8[&a+&8] " + data1.get("rankColor") + "&l" + data1.get("rank") + " " + data1.get("rankColor") + e.getPlayer().getName()));
		e.getPlayer().setFoodLevel(20);
		Packets.sendTitle(e.getPlayer(), Utils.color("&eVIBE&bXO"), Utils.color("&7Custom Survival"));
		Packets.sendTabTitle(e.getPlayer(), Utils.color("&8&l[&e&lVIBE&b&lXO&8&l]"), Utils.color("&8&l&m---===[XO]===---"));
		e.getPlayer().getInventory().setItem(8, Utils.createItem(Material.NETHER_STAR, 1, 0, Utils.color("&8[&eSurvival Menu&8]"), Arrays.asList("", Utils.color("&cThis item cannot be moved!"))));
		ScoreboardHandler.makeScoreBoard(e.getPlayer());
		//DATABASE INSERT
		e.getPlayer().setHealthScale(20);
		e.getPlayer().setPlayerListName(Utils.color(data1.get("rankColor").toString() + "&l" + data1.get("rank").toString() + " " + data1.get("rankColor").toString() + e.getPlayer().getName()));
	}

}
