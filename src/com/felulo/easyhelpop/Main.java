package com.felulo.easyhelpop;

import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private Map<UUID, Long> helpopCooldown;

        @Override
        public void onEnable() {
            this.helpopCooldown = new HashMap<>();

            this.getLogger().info("easyHelpOP 1.0.1 has been enabled.");
        }

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("helpop")) {
                if(sender.hasPermission("easyhelpop.use") || sender.hasPermission("easyhelpop.admin") || sender.isOp()) {
                    if(args.length >= 1) {
                        if(this.helpopCooldown.get(player.getUniqueId() != null && System.currentTimeMillis() < this.helpopCooldown.get(player.getUniqueId())){
                            player.sendMessage(this.color("&a[&7easyHelpOP&a] &2Musisz odczekac przed napisaniem kolejnego zgloszenia."));
                            return false;
                        }

                        String message = String.join(" ", args);

                        sender.sendMessage(this.color("&a[&7easyHelpOP&a] &2Zgłoszenie zostało wysłane."));
                        sender.sendMessage(this.color("&a[&7easyHelpOP&a] &2Administracja się z tobą skontaktuje jak tylko będzie to możliwe."));

                        Bukkit.broadcast(this.color("&a[&7easyHelpOP&a] &6" + sender.getName() + " &e>>&2 " + message), "easyhelpop.admin");

                        this.helpopCooldown.put(player.getUniqueId(), System.currentTimeMillis() + 60000);
                    } else {
                        sender.sendMessage(this.color("&a[&7easyHelpOP&a] &cMusisz podać treść zgłoszenia!"));
                    }
                } else {
                    sender.sendMessage(this.color("&a[&7easyHelpOP&a] &cNie masz uprawnień do używania tej komendy!"));
                }
            }
            return false;
        }

        private String color(String s){
            return s != null ? ChatColor.translateAlternateColorCodes('&', s) : null;
        }
}
