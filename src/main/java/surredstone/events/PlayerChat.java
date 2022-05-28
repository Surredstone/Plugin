package surredstone.events;

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

        Village playerVillage = Village.getVillageByPlayer(event.getPlayer());

        for (Player player : playerVillage.getOnlinePlayers()) {
            player.sendMessage(String.format(
                "%s[%s] %s<%s> %s",
                playerVillage.getColor(),
                playerVillage.getAbbreviation(),
                ChatColor.WHITE,
                player.getName(),
                event.getMessage()));
        }
    }
}