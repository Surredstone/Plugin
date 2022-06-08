package surredstone;

public enum DiscordLog {
    PLAYER_DEATH(":emote:", "%death_message"),
    PLAYER_JOIN(":emote:", "%player entrou no servidor"),
    PLAYER_QUIT(":emote:", "%player saiu do servidor"),
    SERVER_OPEN(":emote:", "Servidor aberto"),
    SERVER_CLOSE(":emote:", "Servidor fechado"),
    MESSAGE("", "%message_syntax");

    public String emote;
    public String message;

    private DiscordLog(String emote, String message) {
        this.emote = emote;
        this.message = message;
    }

    public String getLog() {
        return emote + " " + message;
    }

    public String getLogWithoutEmote() {
        return message;
    }

    public String getLogEmote() {
        return emote;
    }
}
