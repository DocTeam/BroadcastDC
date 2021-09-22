package fr.ninedocteur.broadcastdc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public class BroadcastDCMain extends JavaPlugin implements Listener {
	
	String prefix = getConfig().getString("Prefix");
	String bcmessage = getConfig().getString("BroadcastMessage");
	String version = ("1.2 - 1.17");
	
	
		public void onEnable() {
			getConfig().options().copyDefaults(true);
			saveConfig();
			System.out.println("[BroadcastDC]" + ChatColor.GREEN + " Enable with success");
			System.out.println("[BroadcastDC]" + ChatColor.GREEN + " You are using the version " + version);
		}
		
		
		public void onDisable() {
			saveConfig();
			System.out.println("[BroadcastDC]" + ChatColor.RED + " ShutDown");
		}
		
		
		public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
			if(sender instanceof Player) {
				Player player = (Player)sender;
			
				//no argument
				if(args.length == 0) {
					player.sendMessage(prefix + ChatColor.RED + " There is no arguments, please add argument");
					player.sendMessage(ChatColor.RED + "Usage: /broadcast <message>");
				}
			
				//if argumemnt are present.
				if(args.length >= 1) {
				
					StringBuilder bc = new StringBuilder();
					for(String part : args){
						bc.append(part + " ");
					}
					Bukkit.broadcastMessage(bcmessage + " " + bc.toString());
				}
		
}
			return true;
		}
}



