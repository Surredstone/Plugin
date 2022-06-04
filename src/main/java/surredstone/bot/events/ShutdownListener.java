package surredstone.bot.events;

import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import surredstone.Bot;
import surredstone.MessageLine;
import surredstone.Plugin;

public class ShutdownListener extends ListenerAdapter {
    @Override
    public void onShutdown(ShutdownEvent event) {
        Bot.sendMessageToMainChannel(MessageLine.DC_SERVER_CLOSE);

        Plugin.consoleLog(MessageLine.BOT_SHUTDOWN_SUCCESS);
    }
}
