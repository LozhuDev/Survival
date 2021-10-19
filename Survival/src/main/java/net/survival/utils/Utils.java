package net.survival.utils;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.survival.main.Main;

public class Utils implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public Utils(Main hub) {
		Utils.plugin = hub;
	}

	public static String color(String string){
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static int randomNum(int Low, int High){
		Random r = new Random();
		int R = r.nextInt(High-Low) + Low;
		return R;
	}	
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItem(Material material, int amount ,int dataValue, String name,
			List<String> list) {
		ItemStack selector = new ItemStack(material, amount, (short) dataValue);
		ItemMeta selectorMeta = selector.getItemMeta();
		selectorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		selectorMeta.setDisplayName(name);
		if (list != null)
			selectorMeta.setLore(list);
		selector.setItemMeta(selectorMeta);
		return selector;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createSkull(String pname, String name,
			List<String> lore) {
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
		SkullMeta meta3 = (SkullMeta) skull.getItemMeta();
		meta3.setOwner(pname);
		meta3.setDisplayName(name);
		meta3.setLore(lore);
		skull.setItemMeta(meta3);
		return skull;
	}
	
	public static Location getRandomLocation(int min, int max) {
	    World world = Bukkit.getWorld("world");
	    Random rand = new Random();
	    // Adjust the range max for the maximum X and Z value, and the range min for the minimum X and Z value.
	    int rangeMax = max;
	    int rangeMin = min;

	    int X = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
	    int Z = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
	    int Y = world.getHighestBlockYAt(X, Z);

	    return new Location(world, X, Y, Z).add(0.5, 0, 0.5);
	}
}
