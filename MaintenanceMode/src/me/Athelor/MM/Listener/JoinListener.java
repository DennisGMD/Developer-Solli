package me.Athelor.MM.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.Athelor.MM.API.API;

public class JoinListener implements Listener {
    public JoinListener() {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Boolean activated = API.getActivated();
        String kickmessage = API.getKickMessage();
        if(activated.booleanValue() && !p.hasPermission("maintenance.allowjoin")) {
            p.kickPlayer(ChatColor.RED + kickmessage);
        }

    }

    @EventHandler
    public void onJoin(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        Boolean activated = API.getActivated();
        String kickmessage = API.getKickMessage();
        if(activated.booleanValue() && !p.hasPermission("maintenance.allowjoin")) {
            p.kickPlayer(ChatColor.RED + kickmessage);
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        Boolean activated = API.getActivated();
        String kickmessage = API.getKickMessage();
        if(activated.booleanValue() && !p.hasPermission("maintenance.allowjoin")) {
            p.kickPlayer(ChatColor.RED + kickmessage);
        }

    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        Boolean activated = API.getActivated();
        String kickmessage = API.getKickMessage();
        if(activated.booleanValue() && !p.hasPermission("maintenance.allowjoin")) {
            p.kickPlayer(ChatColor.RED + kickmessage);
        }

    }
}