package me.starmech.JCD;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Currencies extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("jcd").setExecutor(new JCD_CommandExecutor(this));
		new JCD_CommandExecutor(this);
		getConfig();
	}
	
	@EventHandler 
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();

		if(!getConfig().contains(p.getName())){
			getConfig().set(p.getName() + ".CocoaBean", 0);
			
		}
	
	}
	
	public void giveCocoaBean(Player p, int B){
		getConfig().set(p.getName() + ".CocoaBean", getConfig().getInt(p.getName() + ".CocoaBean" , 0) + B);
		saveConfig();
		p.sendMessage(B + " CocoaBeans given");
	}
	public void takeCocoaBean(Player p, int B){
		getConfig().set(p.getName() + ".CocoaBean", getConfig().getInt(p.getName() + ".CocoaBean" , 0) - B);
		saveConfig();
		p.sendMessage(B + " CocoaBeans taken");
	}
	
	public void setBalance(String player, double amount)
	{
		getConfig().set(player, amount);
	}
	
	public double getBalance(String player)
	{
		return getConfig().getDouble(player);
	}
	
	public boolean hasAccount(String player)
	{
		return getConfig().contains(player);
	}
	
	public void onDisable() {
		saveConfig();
	}
}
