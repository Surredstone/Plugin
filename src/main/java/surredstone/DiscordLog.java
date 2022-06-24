package surredstone;

public enum DiscordLog {
    PLAYER_DEATH(":skull:", "%death_message"),
    PLAYER_JOIN(":thumbsup:", "%player entrou no servidor"),
    PLAYER_QUIT(":thumbsdown:", "%player saiu do servidor"),
    SERVER_OPEN(":white_check_mark:", "Servidor aberto"),
    SERVER_CLOSE(":octagonal_sign:", "Servidor fechado"),
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
