package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import surredstone.Message;
import surredstone.MessageType;
import surredstone.Sender;
import surredstone.Village;

public class PlayerChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Village playerVillage = Village.getVillageByPlayer(event.getPlayer());

        Sender.sendMessage(playerVillage, new Message(
                event.getPlayer().getName(),
                event.getMessage(),
                false,
                MessageType.DEFAULT));

        event.setCancelled(true);
    }
}