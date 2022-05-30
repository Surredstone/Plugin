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
    public String DISCORD = ChatColor.AQUA + "[DC]";
    public String GLOBAL = ChatColor.GOLD + "Global";

    static String sendGlobalMessage(String userName, String message, boolean fromDiscord) {
        String prefix = "";

        if (fromDiscord) {
            prefix += String.format(
                    "%s %s",
                    DISCORD,
                    GLOBAL);
        } else {
            Village playerVillage = Village.getVillageByPlayer(Plugin.getInstance().getServer().getPlayer(userName));

            if (playerVillage == null)
                return null;

            prefix += String.format(
                    "%s %s[%s]",
                    GLOBAL,
                    playerVillage.getTextColor(),
                    playerVillage.getName());
        }

        String finalMessage = String.format(
                "%s %s%s: %s",
                prefix,
                ChatColor.WHITE,
                userName,
                message);

        Plugin.getInstance().getServer().getConsoleSender().sendMessage(finalMessage);
        Plugin.getInstance().getServer().broadcastMessage(finalMessage);

        return finalMessage;
    }
}
