package me.starmech.JCD;

public class SLAPI 
{
	private static Main plugin = JCD_Manager.getPlugin();
	public static void saveBalences()
	{
		for(String p : JCD_Manager.getBalanceMap().keySet())
		{
			plugin.getConfig().set("Balence."+ p, JCD_Manager.getBalanceMap().get(p));
		}
		plugin.saveConfig();
	}
	
	public static void loadBalences()
	{
		if(plugin.getConfig().contains("balence")) return;
		for(String s : plugin.getConfig().getConfigurationSection("balence").getKeys(false))
		{
			JCD_Manager.setBalence(s, plugin.getConfig().getDouble("balence."+ s));
		}
	}
}
