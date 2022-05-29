package surredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import surredstone.Message;
import surredstone.Village;

public class VillageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("surredstone.village")) {
            sender.sendMessage(Message.PERMISSIONS_INSUFICIENTS);
            return false;
        }

        Village requestedVillage = Village.getVillageByAbbreviation(args[0].toString());

        if (requestedVillage == null) {
            sender.sendMessage(Message.VILLAGE_NOT_FOUND);
            return false;
        }

        switch (args[1].toLowerCase()) {
            case "info":
                return new VillageInfoSubcommand().setVillage(requestedVillage).onCommand(sender, command, label, args);
            default:
                sender.sendMessage(Message.SUBCOMMAND_INVALID);
                return false;
        }
    }
}
