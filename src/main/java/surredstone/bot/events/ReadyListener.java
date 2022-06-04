package surredstone.bot.events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import surredstone.MessageLine;
import surredstone.Plugin;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        Plugin.getInstance().getServer().getConsoleSender().sendMessage(
            String.format(
                MessageLine.BOT_LOGIN_SUCCESS, 
                event.getJDA().getSelfUser().getName()));
    }
}
