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

        if (event.getChannel() == Bot.getGlobalChannel()) {
            Logger.logMinecraftGlobal(
                    new Message(
                            event.getAuthor().getName(),
                            event.getMessage().getContentRaw(),
                            true,
                            MessageType.GLOBAL).toMinecraftLog());

            return;
        }

        for (Village village : Village.getAllVillages()) {
            if (event.getChannel() == Bot.getVillageChannel(village)) {
                Logger.logMinecraftVillage(
                        village,
                        new Message(
                                event.getAuthor().getName(),
                                event.getMessage().getContentRaw(),
                                true,
                                MessageType.VILLAGE).toMinecraftLog());

                return;
            }
        }
    }
}
