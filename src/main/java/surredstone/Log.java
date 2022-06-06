package surredstone;

public class Log {
    public static DiscordLog getDiscordLog(String logName) {
        for (DiscordLog discordLog : DiscordLog.class.getEnumConstants()) {
            if (discordLog.name().equalsIgnoreCase(logName)) {
                return discordLog;
            }
        }

        return null;
    }

    public static MinecraftLog getMinecraftLog(String logName) {
        for (MinecraftLog minecraftLog : MinecraftLog.class.getEnumConstants()) {
            if (minecraftLog.name().equalsIgnoreCase(logName)) {
                return minecraftLog;
            }
        }

        return null;
    }
}
