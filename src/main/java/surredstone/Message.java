package surredstone;

import org.bukkit.ChatColor;

public interface Message {
    public String ON_PLUGIN_ENABLE = ChatColor.GREEN + "Surredstone Plugin enabled";
    public String ON_PLUGIN_DISABLE = ChatColor.RED + "Surredstone Plugin disabled";
    public String INVALID_VILLAGE_STORAGE_ERROR = "Invalid Village Storage";
    public String COMMAND_MUST_BE_EXECUTED_BY_PLAYER = "This command must be executed by a player";
    public String PLAYER_WITHOUT_VILLAGE = "To run this command you must be in a Village";
}
