package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import surredstone.Plugin;
import surredstone.Presence;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Presence.updatePresence(
                Presence.getCurrentOnlinePlayersMessage(
                        Plugin.getInstance().getServer().getOnlinePlayers().size() - 1));
    }
}
