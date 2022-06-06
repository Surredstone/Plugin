package surredstone;

import org.bukkit.ChatColor;

public enum MinecraftLog {
    ACHIEVEMENT("green", "%player conseguiu a conquista %achievement"),
    PLAYER_DEATH("red", "%death_message"),
    PLAYER_JOIN("green", "%player entrou no servidor"),
    PLAYER_QUIT("red", "%player saiu do servidor"),
    PLUGIN_ENABLE("green", "Plugin Surredstone habilitado"),
    PLUGIN_DISABLE("red", "Plugin Surredstone desabilitado"),
    BOT_LOGIN_FAILURE("red", "Falha ao conectar ao Discord"),
    BOT_LOGIN_SUCCESS("green", "Bot connectado como %bot_name"),
    BOT_SHUTDOWN_SUCCESS("red", "Bot desconectado"),
    COMMAND_EXECUTED_PLAYER("red", "Este comando deve ser executado por um player"),
    INVALID_SUBCOMMAND("red", "Subcomando inv\u00E1lido"),
    INVALID_VILLAGE_STORAGE("red", "Armazenamento da Vila inv\u00E1lido"),
    MEMBERS_LABEL("aqua", "Membros online: %village_online_members"),
    PARAMETERS_NULL("red", "Par\u00E2metros insuficientes"),
    PERMISSIONS_NULL("red", "Permiss\u00F5es insuficientes"),
    PLAYER_VILLAGE_NULL("red", "Voc\u00EA deve estar em uma vila para executar esse comando"),
    VILLAGE_NOT_FOUND("red", "Vila n\u00E3o encontrada"),
    MESSAGE("white", "%message_syntax"),
    VILLAGE_NAME("white", "%village_color[%village_abbreviation] %village_name"),
    VILLAGE_MEMBERS("aqua", "Membros online: " + ChatColor.WHITE + "%value"),
    VILLAGE_INFO("aqua", "Informa\u00E7\u00F5es: " + ChatColor.WHITE + "%value");

    public ChatColor color;
    public String message;

    private MinecraftLog(String colorName, String message) {
        this.message = message;

        for (ChatColor chatColor : ChatColor.class.getEnumConstants()) {
            if (chatColor.name().equalsIgnoreCase(colorName)) {
                this.color = chatColor;
            }
        }

        if (color == null)
            this.color = ChatColor.WHITE;
    }

    public String getLog() {
        return color + message;
    }

    public String getUncolorLog() {
        return message;
    }

    public ChatColor getLogColor() {
        return color;
    }
}
