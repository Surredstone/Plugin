package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Log;
import surredstone.Logger;
import surredstone.Message;
import surredstone.MessageType;

public class GlobalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Logger.logMinecraftPlayer((Player) sender, Log.getMinecraftLog("COMMAND_EXECUTED_PLAYER").getLog());
            return false;
        }

        Message message = new Message(
                sender.getName(),
                String.join(" ", args),
                false,
                MessageType.GLOBAL);

        Logger.logGlobal(message.toMinecraftLog(), message.toDiscordLog());

        return true;
    }
}
