package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import surredstone.Bot;
import surredstone.Plugin;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bot.getInstance().setPresence(Plugin.getInstance().getOnlinePlayersString());
    }
}
