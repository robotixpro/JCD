package me.starmech.JCD;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		getCommand("jcd").setExecutor(new JCD_CommandExecutor());
		SLAPI.loadBalences();
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
		    playerList.put(player.getName(), playerData(player));
		}
			
	}
	
	@Override
	public void onDisable(){
		SLAPI.saveBalences();
	}
}
