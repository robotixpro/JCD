package me.starmech.JCD;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class JCD_CommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command command, String s, String[] args)
	{
		if(cs.hasPermission("jcd.use"))
		if(args.length != 3)
		{
			cs.sendMessage(ChatColor.RED +"Missing Arguments");
			cs.sendMessage(ChatColor.GREEN + "Usage: /jcd <add,remove,set> <Player> <Amount>");
			return true;
		}
			
		if(args[0].equalsIgnoreCase("add"))
		{
			if(!JCD_Manager.hasAccount(args[1]))
			{
				cs.sendMessage("Player does not have an account with this server!");
				return true;
			}
			double amount = 0;
			try
			{
				amount = Double.parseDouble(args[2]);
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED + "Enter a valid number!");
				return true;
			}
						
			JCD_Manager.setBalence(args[1], JCD_Manager.getBalence(args[1]) + amount);	
		}else if(args[0].equalsIgnoreCase("remove"))
		{
			if(!JCD_Manager.hasAccount(args[1]))
			{
				cs.sendMessage("Player does not have an account with this server!");
				return true;
			}
			double amount = 0;
			try
			{
				amount = Double.parseDouble(args[2]);
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED + "Enter a valid number!");
				return true;
			}
						
			JCD_Manager.setBalence(args[1], JCD_Manager.getBalence(args[1]) - amount);
			
		}else if(args[0].equalsIgnoreCase("set"))
		{
			if(!JCD_Manager.hasAccount(args[1]))
			{
				cs.sendMessage("Player does not have an account with this server!");
				return true;
			}
			double amount = 0;
			try
			{
				amount = Double.parseDouble(args[2]);
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED + "Enter a valid number!");
				return true;
			}
						
			JCD_Manager.setBalence(args[1], amount);
			
			
		}else
		{
			cs.sendMessage(ChatColor.RED + "Incorrect Argument");
		}
		
		return true;
	}
}

