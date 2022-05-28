package surredstone.events;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import surredstone.Village;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        List<Village> villages = Village.getAllVillages();

        for (Village village : villages) {
            if (event.getPlayer().hasPermission(village.getPermission())) {
                for (Player player : village.getOnlinePlayers()) {
                    player.sendMessage(String.format(
                            "%s[%s] %s<%s> %s",
                            village.getColor(),
                            village.getAbbreviation(),
                            ChatColor.WHITE,
                            player.getName(),
                            event.getMessage()));
                }
            }
        }
    }
}