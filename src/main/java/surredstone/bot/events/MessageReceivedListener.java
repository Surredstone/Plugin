package surredstone.bot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import surredstone.Bot;
import surredstone.Logger;
import surredstone.Message;
import surredstone.MessageType;
import surredstone.Village;

public class MessageReceivedListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMember().getUser().isBot()) {
            return;
        }

        if (event.getChannel().getId().contentEquals(Bot.getGlobalChannel().getId())) {
            Logger.logMinecraftGlobalAndConsole(
                    new Message(
                            event.getMember().getEffectiveName(),
                            event.getMessage().getContentStripped(),
                            true,
                            MessageType.GLOBAL).toMinecraftLog());

            return;
        }

        for (Village village : Village.getAllVillages()) {
            if (event.getChannel().getId().contentEquals(Bot.getVillageChannel(village).getId())) {
                Logger.logMinecraftVillage(
                        village,
                        new Message(
                                event.getMember().getEffectiveName(),
                                event.getMessage().getContentDisplay(),
                                true,
                                MessageType.VILLAGE).toMinecraftLog());

                return;
            }
        }
    }
}
