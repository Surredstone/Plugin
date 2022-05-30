package surredstone;

import org.bukkit.ChatColor;

public interface Message {
    public String ON_PLUGIN_ENABLE = ChatColor.GREEN + "Plugin Surredstone habilitado";
    public String ON_PLUGIN_DISABLE = ChatColor.RED + "Plugin Surredstone desabilitado";
    public String INVALID_VILLAGE_STORAGE_ERROR = "Armazenamento da Vila inválido";
    public String COMMAND_MUST_BE_EXECUTED_BY_PLAYER = "Este comando deve ser executado por um player";
    public String PLAYER_WITHOUT_VILLAGE = "Você deve estar em uma vila para executar esse comando";
    public String PERMISSIONS_INSUFICIENTS = "Permissões insuficientes";
    public String VILLAGE_NOT_FOUND = "Vila não encontrada";
    public String SUBCOMMAND_INVALID = "Subcomando inválido";
}
