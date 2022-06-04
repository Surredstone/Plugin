package surredstone.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import surredstone.MessageLine;
import surredstone.Village;

public class VillageInfoSubcommand implements CommandExecutor {
    Village village;

    public VillageInfoSubcommand setVillage(Village village) {
        this.village = village;
        return this;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Village> villages = new ArrayList<Village>();

        if (village == null) {
            villages.addAll(Village.getAllVillages());
        } else {
            villages.add(village);
        }

        List<String> message = new ArrayList<String>();

        for (Village village : villages) {
            message.add(String.format(
                    "%s[%s] %s",
                    village.getTextColor(),
                    village.getAbbreviation().toUpperCase(),
                    village.getName()));

            message.add(String.format(
                    MessageLine.MEMBERS_LABEL,
                    ChatColor.WHITE + String.valueOf(village.getOnlinePlayers().size())));

            message.add(String.format(
                    MessageLine.INFO_LABEL,
                    ChatColor.WHITE + village.getInfo()));
        }

        for (String line : message) {
            sender.sendMessage(line);
        }

        return true;
    }
}
