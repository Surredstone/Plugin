package surredstone;

import org.bukkit.ChatColor;

public interface MessageLine {
    String BOT_LOGIN_FAILURE = ChatColor.RED + "Falha ao conectar ao Discord";
    String BOT_LOGIN_SUCCESS = ChatColor.GREEN + "Bot connectado como %s";
    String COMMAND_EXECUTED_PLAYER = ChatColor.RED
            + "Este comando deve ser executado por um player";
    String DISCORD_LABEL = String.format("%s%sDC", ChatColor.BOLD, ChatColor.BLUE);
    String GLOBAL_LABEL = String.format("%s%s[G]", ChatColor.BOLD, ChatColor.GOLD);
    String INFO_LABEL = ChatColor.AQUA + "Informa\u00E7\u00F5es: %s";
    String INVALID_SUBCOMMAND = ChatColor.RED + "Subcomando inv\u00E1lido";
    String INVALID_VILLAGE_STORAGE = ChatColor.RED + "Armazenamento da Vila inv\u00E1lido";
    String MEMBERS_LABEL = ChatColor.AQUA + "Membros online: %s";
    String PARAMETERS_NULL = ChatColor.RED + "Par\u00E2metros insuficientes";
    String PERMISSIONS_NULL = ChatColor.RED + "Permiss\u00F5es insuficientes";
    String PLAYER_VILLAGE_NULL = ChatColor.RED
            + "Voc\u00EA deve estar em uma vila para executar esse comando";
    String PLUGIN_DISABLE = ChatColor.RED + "Plugin Surredstone desabilitado";
    String PLUGIN_ENABLE = ChatColor.GREEN + "Plugin Surredstone habilitado";
    String DC_SERVER_OPEN = "Servidor aberto";
    String DC_SERVER_CLOSE = "Servidor fechado";
    String VILLAGE_LABEL = ChatColor.GOLD + "Vila";
    String VILLAGE_NOT_FOUND = ChatColor.RED + "Vila n\u00E3o encontrada";
}
