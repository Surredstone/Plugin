package surredstone;

public class Presence {
    Presence _instance;

    public static void updatePresence(String message) {
        Bot.updatePresenceMessage(getPresenceMessage(message));
    }

    public static String getPresenceMessage(String message) {
        return "Surredstone - " + message;
    }

    public static String getCurrentOnlinePlayersMessage(int currentOnlinePlayers) {
        return String.valueOf(currentOnlinePlayers)
                + "/" +
                String.valueOf(Plugin.getMaxPlayers());
    }
}
