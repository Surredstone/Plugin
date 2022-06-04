package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import surredstone.Plugin;
import surredstone.Presence;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Presence.updatePresence(
                Presence.getCurrentOnlinePlayersMessage(
                        Plugin.getInstance().getServer().getOnlinePlayers().size()));
    }
}
