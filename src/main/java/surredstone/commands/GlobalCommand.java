package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Message;
import surredstone.MessageLine;
import surredstone.MessageType;
import surredstone.Sender;

public class GlobalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageLine.COMMAND_EXECUTED_PLAYER);
            return false;
        }

        Sender.sendGlobalMessage(
                new Message(
                        sender.getName(),
                        String.join(" ", args),
                        false,
                        MessageType.GLOBAL));

        return true;
    }
}
