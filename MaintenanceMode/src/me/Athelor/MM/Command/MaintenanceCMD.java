package me.Athelor.MM.Command;

import java.util.Iterator;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Athelor.MM.API.API;

public class MaintenanceCMD implements CommandExecutor {
    public MaintenanceCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("maintenance")) {
            return false;
        } else {
            Player player = (Player)sender;
            if(args.length == 0) {
                if(!sender.hasPermission("maintenance.use")) {
                    sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                } else if(sender.hasPermission("maintenance.use")) {
                    sender.sendMessage("§7============[ §cMaintenance §7]============");
                    sender.sendMessage("§c/maintenance §8- §7Shows this");
                    sender.sendMessage("§c/maintenance enable §8- §7Enable maintenance mode");
                    sender.sendMessage("§c/maintenance disable §8- §7Disable maintenance mode");
                    sender.sendMessage("§7============[ §cMaintenance §7]============");
                }
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("enable")) {
                    if(!sender.hasPermission("maintenance.use")) {
                        sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    } else if(sender.hasPermission("maintenance.use")) {
                        sender.sendMessage(ChatColor.GREEN + "Maintenance mode enabled!");
                        API.setActivated(Boolean.valueOf(true));
                        Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                        while(var7.hasNext()) {
                            Player p = (Player)var7.next();
                            if(!player.hasPermission("maintenance.bypass")) {
                                String kickmessager = API.getKickMessage();
                                p.kickPlayer(kickmessager);
                            }
                        }
                    }
                } else if(args[0].equalsIgnoreCase("disable")) {
                    if(!sender.hasPermission("maintenance.use")) {
                        sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    } else if(sender.hasPermission("maintenance.use")) {
                        sender.sendMessage(ChatColor.GREEN + "Maintenance mode disabled!");
                        API.setActivated(Boolean.valueOf(false));
                    }
                }
            }

            return true;
        }
    }
}
