package surredstone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import surredstone.Log;
import surredstone.Logger;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Logger.logDiscordGlobal(
                Log.getDiscordLog("PLAYER_DEATH").getLog()
                        .replace("%death_message", event.getDeathMessage()));
    }
}