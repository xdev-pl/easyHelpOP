package com.felulo.easyhelpop;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("easyHelpOP 1.0 has been enabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("helpop")) {
			if(sender.hasPermission("easyhelpop.use") || sender.hasPermission("easyhelpop.admin") || sender.isOp()) {
				if(args.length >= 1) {
					sender.sendMessage("§a[§7easyHelpOP§a] §2Zg³oszenie zosta³o wys³ane.");
					sender.sendMessage("§a[§7easyHelpOP§a] §2Administracja siê z tob¹ skontaktuje jak tylko bêdzie to mo¿liwe.");
					for(Player player : Bukkit.getServer().getOnlinePlayers()) {
						if(player.isOp() || player.hasPermission("easyhelpop.admin")) {
							StringBuilder builder = new StringBuilder();
							for (String str : args) {
								builder.append(" ").append(str);
							}
							player.sendMessage("§a[§7easyHelpOP§a] §6" + sender.getName().toString() + " §e>>§2" + builder.toString());
						}
					}
				} else {
					sender.sendMessage("§a[§7easyHelpOP§a] §cMusisz podaæ treœæ zg³oszenia!");
				}
			} else {
				sender.sendMessage("§a[§7easyHelpOP§a] §cNie masz uprawnieñ do u¿ywania tej komendy!");
			}
		}
		return false;
	}

}
