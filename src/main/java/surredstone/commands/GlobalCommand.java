package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Message;

public class GlobalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Message.COMMAND_MUST_BE_EXECUTED_BY_PLAYER);
            return false;
        }

        new Message(sender.getName(), args.toString(), false).sendGlobalMessage();

        return true;
    }
}
