package surredstone.bot.events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import surredstone.Log;
import surredstone.Logger;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        Logger.logDiscordGlobal(Log.getDiscordLog("SERVER_OPEN").getLog());

        Logger.logConsoleLog(
                Log.getMinecraftLog("BOT_LOGIN_SUCCESS").getLog()
                        .replace("%bot_name", event.getJDA().getSelfUser().getName()));
    }
}
