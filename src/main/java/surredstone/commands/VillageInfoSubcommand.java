package surredstone.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Log;
import surredstone.Logger;
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

        List<String> logs = new ArrayList<String>();

        for (Village village : villages) {
            logs.add(
                    Log.getMinecraftLog("VILLAGE_NAME").getLog()
                            .replace("%village_color", village.getTextColor().toString())
                            .replace("%village_abbreviation", village.getAbbreviation().toUpperCase())
                            .replace("%village_name", village.getName()));

            logs.add(
                    Log.getMinecraftLog("VILLAGE_MEMBERS").getLog()
                            .replace("%value", String.valueOf(village.getOnlinePlayers().size())));

            logs.add(
                    Log.getMinecraftLog("VILLAGE_INFO").getLog()
                            .replace("%value", String.valueOf(village.getInfo())));
        }

        for (String log : logs) {
            Logger.logMinecraftPlayer((Player) sender, log);
        }

        return true;
    }
}
