package me.starmech.JCD;

import java.util.HashMap;

public class JCD_Manager {

	private static Main plugin;
	
	public JCD_Manager(Main instance)
	{
		plugin = instance;
	}
	public static HashMap<String, Double> bal = new HashMap<>();
	
	public static void setBalence(String player, double amount)
	{
		bal.put(player, amount);
	}
	
	public static double getBalence(String player)
	{
		return bal.get(player);
	}
	
	public static boolean hasAccount(String player)
	{
		return bal.containsKey(player);
	}
	
	public static HashMap<String, Double> getBalanceMap()
	{
		return bal;
	}
	public static Main getPlugin()
	{
		return plugin;
	}
	
	
	
}
