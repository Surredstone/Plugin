package surredstone.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Log;
import surredstone.Logger;
import surredstone.MinecraftLog;
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

        List<MinecraftLog> log = new ArrayList<MinecraftLog>();

        for (Village village : villages) {
            log.add(
                    Log.getMinecraftLog("VILLAGE_NAME")
                            .setToken("village_color", village.getTextColor().toString())
                            .setToken("village_abbreviation", village.getAbbreviation().toUpperCase())
                            .setToken("village_name", village.getName()));

            log.add(
                    Log.getMinecraftLog("VILLAGE_MEMBERS")
                            .setToken("value", String.valueOf(village.getOnlinePlayers().size())));

            log.add(
                    Log.getMinecraftLog("VILLAGE_INFO")
                            .setToken("value", String.valueOf(village.getOnlinePlayers().size())));
        }

        for (MinecraftLog line : log) {
            Logger.logMinecraftPlayer((Player) sender, line);
        }

        return true;
    }
}
