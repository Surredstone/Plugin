package surredstone.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import surredstone.Village;

public class VillageInfoSubcommand implements CommandExecutor {
    Village village;

    public VillageInfoSubcommand setVillage(Village village) {
        this.village = village;
        return this;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> message = new ArrayList<String>();

        message.add(String.format(
                "%s[%s] %s",
                village.getTextColor(),
                village.getAbbreviation(),
                village.getName()));

        message.add(String.format(
                "%sBandeira: %s",
                ChatColor.AQUA,
                village.getFlag()));

        for (String line : message) {
            sender.sendMessage(line);
        }

        return true;
    }
}
