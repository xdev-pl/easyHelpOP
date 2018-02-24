package com.felulo.easyhelpop;

import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public String translateColors(String msg) {
		return msg.replace("&", "§");
	}
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("easyHelpOP 1.0.1 has been enabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("helpop")) {
			if(sender.hasPermission("easyhelpop.use") || sender.hasPermission("easyhelpop.admin") || sender.isOp()) {
				if(args.length >= 1) {
					String str = String.join(" ", args);
					sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &2Zgłoszenie zostało wysłane."));
					sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &2Administracja się z tobą skontaktuje jak tylko będzie to możliwe."));
					Bukkit.broadcast(this.translateColors("&a[&7easyHelpOP&a] &6" + sender.getName().toString() + " &e>>&2 " + str), "easyhelpop.admin");
				} else {
					sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &cMusisz podać treść zgłoszenia!"));
				}
			} else {
				sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &cNie masz uprawnień do używania tej komendy!"));
			}
		}
		return false;
	}

}
