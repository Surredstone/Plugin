package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Message;
import surredstone.MessageLine;
import surredstone.MessageType;
import surredstone.Sender;
import surredstone.Village;

public class VillageChatSubcommand implements CommandExecutor {
    Village village;

    public VillageChatSubcommand setVillage(Village village) {
        this.village = village;
        return this;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageLine.COMMAND_EXECUTED_PLAYER);
            return false;
        }

        if (village == null) {
            sender.sendMessage(MessageLine.VILLAGE_NOT_FOUND);
            return false;
        }

        if (Village.getVillageByPlayer((Player) sender) == null) {
            sender.sendMessage(MessageLine.PLAYER_VILLAGE_NULL);
            return false;
        }

        if (String.valueOf(args).isBlank()) {
            sender.sendMessage(MessageLine.PARAMETERS_NULL);
            return false;
        }

        Sender.sendVillageMessage((Player) sender, village, new Message(
                sender.getName(),
                String.join(" ", args),
                false,
                MessageType.VILLAGE));

        return true;
    }
}
