package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import surredstone.Log;
import surredstone.Logger;
import surredstone.Plugin;
import surredstone.Presence;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Logger.logDiscordGlobal(
                Log.getDiscordLog("PLAYER_JOIN").getLog()
                        .replace("%player", event.getPlayer().getName()));

        Presence.updatePresence(
                Presence.getCurrentOnlinePlayersMessage(
                        Plugin.getOnlinePlayers().size()));
    }
}
