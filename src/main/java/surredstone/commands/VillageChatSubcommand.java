package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Message;
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
            sender.sendMessage(Message.COMMAND_MUST_BE_EXECUTED_BY_PLAYER);
            return false;
        }

        if (village == null) {
            sender.sendMessage(Message.VILLAGE_NOT_FOUND);
            return false;
        }

        if (Village.getVillageByPlayer((Player) sender) == null) {
            sender.sendMessage(Message.PLAYER_WITHOUT_VILLAGE);
            return false;
        }

        if (String.valueOf(args).isBlank()) {
            sender.sendMessage(Message.PARAM_INSUFICIENTS);
            return false;
        }

        new Message(sender.getName(), String.valueOf(args), false).sendVillageMessage(village);

        return true;
    }
}
