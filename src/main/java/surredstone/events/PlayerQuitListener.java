package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import surredstone.Log;
import surredstone.Logger;
import surredstone.Plugin;
import surredstone.Presence;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Logger.logDiscordGlobal(
                Log.getDiscordLog("PLAYER_QUIT").getLog()
                        .replace("%player", event.getPlayer().getName()));

        Presence.updatePresence(
                Presence.getCurrentOnlinePlayersMessage(
                        Plugin.getOnlinePlayers().size() - 1));
    }
}
