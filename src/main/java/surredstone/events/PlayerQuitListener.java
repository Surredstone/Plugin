package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import surredstone.Bot;
import surredstone.Plugin;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Bot.getInstance().setPresence(Plugin.getInstance().getOnlinePlayersString());
    }
}
