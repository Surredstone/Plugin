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
        Village playerVillage = Village.getVillageByPlayer(event.getPlayer());

        if (playerVillage == null) {
            return;
        }

        for (Player player : playerVillage.getOnlinePlayers()) {
            player.sendMessage(String.format(
                "%s[%s] %s<%s> %s",
                playerVillage.getColor(),
                playerVillage.getAbbreviation().toUpperCase(),
                ChatColor.WHITE,
                player.getName(),
                event.getMessage()));
        }

        event.setCancelled(true);
    }
}