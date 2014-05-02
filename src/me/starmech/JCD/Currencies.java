package me.starmech.JCD;

import me.starmech.JCD.JCD_Manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Currencies extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("jcd").setExecutor(new JCD_CommandExecutor());
		SLAPI.loadBalences();
	}
	
	@EventHandler 
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();

		if(!getConfig().contains(p.getName())){
			getConfig().set(p.getName() + ".Cocoa Bean", 0);
			
		if(JCD_Manager.hasAccount(e.getPlayer().getName())) return;
			JCD_Manager.setBalence(e.getPlayer().getName(), 0D);
		}
	
	}
	
	public void giveCocoaBean(Player p, int B){
		getConfig().set(p.getName() + ".Cocoa Bean", getConfig().getInt(p.getName() + ".Cocoa Bean" , 0) + B);
		saveConfig();
		p.sendMessage(B + " Cocoa Beans given");
	}
	public void takeCocoaBean(Player p, int B){
		getConfig().set(p.getName() + ".Cocoa Bean", getConfig().getInt(p.getName() + ".Cocoa Bean" , 0) - B);
		saveConfig();
		p.sendMessage(B + " Cocoa Beans taken");
	}
	public void onDisable() {
		SLAPI.saveBalences();
	}
}
