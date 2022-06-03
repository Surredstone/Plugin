package surredstone;

import org.bukkit.entity.Player;

public class Sender {
    public static void sendGlobalMessage(Message message) {
        Bot.getInstance().sendMessageToMainChannel(message.generateMessageUncolor());
        Plugin.getInstance().getServer().getConsoleSender().sendMessage(message.generateMessage());

        for (Player player : Plugin.getInstance().getServer().getOnlinePlayers()) {
            player.sendMessage(message.generateMessage());
        }
    }

    public static void sendVillageMessage(Player sender, Village villageToSendTo, Message message) {
        Bot.getInstance().sendMessageToVillage(villageToSendTo, message.generateMessageUncolor());

        for (Player player : villageToSendTo.getOnlinePlayers()) {
            player.sendMessage(message.generateMessage());
        }

        if (sender == null || Village.getVillageByPlayer(sender) != villageToSendTo) {
            sender.sendMessage(message.generateMessage());
        }
    }

    public static void sendMessage(Village villageToSendTo, Message message) {
        Bot.getInstance().sendMessageToVillage(villageToSendTo, message.generateMessageUncolor());

        for (Player player : villageToSendTo.getOnlinePlayers()) {
            player.sendMessage(message.generateMessage());
        }
    }
}
