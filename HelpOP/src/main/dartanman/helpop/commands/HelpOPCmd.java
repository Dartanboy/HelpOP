package main.dartanman.helpop.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.dartanman.helpop.Main;

public class HelpOPCmd implements CommandExecutor{
	
	private Main plugin;
	
	public HelpOPCmd(Main pl) {
		plugin = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender.hasPermission(plugin.getConfig().getString("Permissions.Use")))) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("No-Permission-Message")));
			return true;
		}else {
			String name = "";
			if(sender instanceof Player) {
				Player player = (Player) sender;
				name = player.getName();
			}else {
				name = "@console";
			}
			
			if (args.length >= 1) {
		        String msg = "";
		        for (int i = 0; i < args.length; i++)
		          msg = String.valueOf(msg) + args[i] + " "; 
		        String message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Message-Format"));
		        message = message.replace("<player>", name);
		        message = message.replace("<message>", msg);
		        Bukkit.broadcast(message, plugin.getConfig().getString("Permissions.Receive"));
		        sender.sendMessage(message);
		        return true;
		      }else {
		    	  sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Incorrect-Arguments-Message")));
		    	  return true;
		      }
		}
	}

}
