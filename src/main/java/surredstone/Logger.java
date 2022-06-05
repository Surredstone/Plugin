package surredstone;

import org.bukkit.entity.Player;

public class Logger {
    public static void logGlobal(MinecraftLog minecraftLog, DiscordLog discordLog) {
        logConsoleLog(minecraftLog);
        logMinecraftGlobal(minecraftLog);
        logDiscordGlobal(discordLog);
    }

    public static void logVillage(Village village, MinecraftLog minecraftLog, DiscordLog discordLog) {
        logMinecraftVillage(village, minecraftLog);
        logDiscordVillage(village, discordLog);
    }

    public static void logConsoleLog(MinecraftLog log) {
        Plugin.consoleLog(log.getLog());
    }

    public static void logDiscordGlobal(DiscordLog log) {
        Bot.sendMessageToMainChannel(log.getLog());
    }

    public static void logDiscordVillage(Village village, DiscordLog log) {
        Bot.sendMessageToVillage(village, log.getLog());
    }

    public static void logMinecraftGlobal(MinecraftLog log) {
        for (Player player : Plugin.getOnlinePlayers()) {
            player.sendMessage(log.getLog());
        }
    }

    public static void logMinecraftVillage(Village village, MinecraftLog log) {
        for (Player player : village.getOnlinePlayers()) {
            player.sendMessage(log.getLog());
        }
    }

    public static void logMinecraftPlayer(Player player, MinecraftLog log) {
        player.sendMessage(log.getLog());
    }
}
