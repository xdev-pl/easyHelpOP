package com.felulo.easyhelpop;

import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public String translateColors(String msg) {
		return msg.replace("&", "�");
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
					sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &2Zg�oszenie zosta�o wys�ane."));
					sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &2Administracja si� z tob� skontaktuje jak tylko b�dzie to mo�liwe."));
					Bukkit.broadcast(this.translateColors("&a[&7easyHelpOP&a] &6" + sender.getName().toString() + " &e>>&2 " + str), "easyhelpop.admin");
				} else {
					sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &cMusisz poda� tre�� zg�oszenia!"));
				}
			} else {
				sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &cNie masz uprawnie� do u�ywania tej komendy!"));
			}
		}
		return false;
	}

}