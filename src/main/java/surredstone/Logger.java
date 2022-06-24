package surredstone;

import org.bukkit.entity.Player;

public class Logger {
    public static void logGlobal(String minecraftLog, String discordLog) {
        logConsoleLog(minecraftLog);
        logMinecraftGlobal(minecraftLog);
        logDiscordGlobal(discordLog);
    }

    public static void logVillage(Village village, String minecraftLog, String discordLog) {
        logMinecraftVillage(village, minecraftLog);
        logDiscordVillage(village, discordLog);
    }

    public static void logVillage(Village village, String minecraftLog, String discordLog, Player sender) {
        logMinecraftVillage(village, minecraftLog);
        logDiscordVillage(village, discordLog);
        if (Village.getVillageByPlayer(sender) != village)
            logMinecraftPlayer(sender, minecraftLog);
    }

    public static void logConsoleLog(String log) {
        Plugin.consoleLog(log);
    }

    public static void logDiscordGlobal(String log) {
        Bot.sendMessageToMainChannel(log);
    }

    public static void logDiscordVillage(Village village, String log) {
        Bot.sendMessageToVillage(village, log);
    }

    public static void logMinecraftGlobalAndConsole(String log) {
        logMinecraftGlobal(log);
        logConsoleLog(log);
    }

    public static void logMinecraftGlobal(String log) {
        for (Player player : Plugin.getOnlinePlayers()) {
            player.sendMessage(log);
        }
    }

    public static void logMinecraftVillage(Village village, String log) {
        for (Player player : village.getOnlinePlayers()) {
            player.sendMessage(log);
        }
    }

    public static void logMinecraftPlayer(Player player, String log) {
        player.sendMessage(log);
    }
}
