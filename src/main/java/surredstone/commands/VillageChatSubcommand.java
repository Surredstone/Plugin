package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Log;
import surredstone.Logger;
import surredstone.Message;
import surredstone.MessageType;
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
            Logger.logMinecraftPlayer((Player) sender, Log.getMinecraftLog("COMMAND_EXECUTED_PLAYER").getLog());
            return false;
        }

        if (village == null) {
            Logger.logMinecraftPlayer((Player) sender, Log.getMinecraftLog("VILLAGE_NOT_FOUND").getLog());
            return false;
        }

        if (Village.getVillageByPlayer((Player) sender) == null) {
            Logger.logMinecraftPlayer((Player) sender, Log.getMinecraftLog("PLAYER_VILLAGE_NULL").getLog());
            return false;
        }

        if (String.valueOf(args).isBlank()) {
            Logger.logMinecraftPlayer((Player) sender, Log.getMinecraftLog("PARAMETERS_NULL").getLog());
            return false;
        }

        Message message = new Message(
                sender.getName(),
                String.join(" ", args),
                false,
                MessageType.VILLAGE);

        Logger.logVillage(village, message.toMinecraftLog(), message.toDiscordLog());

        return true;
    }
}
