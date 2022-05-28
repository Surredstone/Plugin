package surredstone.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import surredstone.Message;
import surredstone.Plugin;
import surredstone.Village;

public class Global implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Message.COMMAND_MUST_BE_EXECUTED_BY_PLAYER);
            return false;
        }

        Village playerVillage = Village.getVillageByPlayer((Player) sender);

        if (playerVillage == null) {
            sender.sendMessage(Message.PLAYER_WITHOUT_VILLAGE);
            return false;
        }

        Plugin.getInstance().getServer().broadcastMessage(
                String.format("%s[%s] %s<%s> %s",
                        playerVillage.getColor(),
                        playerVillage.getName(),
                        ChatColor.WHITE,
                        sender.getName(),
                        args));

        return true;
    }
}
