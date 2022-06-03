package surredstone.commands;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import surredstone.Message;
import surredstone.Village;

public class VillageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Message.PARAM_INSUFICIENTS);
            return false;
        }

        String subcommand = args[0].toLowerCase();
        Village requestedVillage = (args.length <= 1) ? null : Village.getVillageByAbbreviation(args[1]);

        args = (String[]) ArrayUtils.remove(args, 0);
        args = (requestedVillage == null) ? args : (String[]) ArrayUtils.remove(args, 0);

        switch (subcommand) {
            case "info":
                return new VillageInfoSubcommand().setVillage(requestedVillage).onCommand(sender, command, label, args);
            case "chat":
                return new VillageChatSubcommand().setVillage(requestedVillage).onCommand(sender, command, label, args);
            default:
                sender.sendMessage(Message.SUBCOMMAND_INVALID);
                return false;
        }
    }
}
