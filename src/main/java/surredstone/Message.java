package surredstone;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {
    public static String ON_PLUGIN_ENABLE = ChatColor.GREEN + "Plugin Surredstone habilitado";
    public static String ON_PLUGIN_DISABLE = ChatColor.RED + "Plugin Surredstone desabilitado";
    public static String INVALID_VILLAGE_STORAGE_ERROR = "Armazenamento da Vila inválido";
    public static String COMMAND_MUST_BE_EXECUTED_BY_PLAYER = "Este comando deve ser executado por um player";
    public static String PLAYER_WITHOUT_VILLAGE = "Você deve estar em uma vila para executar esse comando";
    public static String PERMISSIONS_INSUFICIENTS = "Permissões insuficientes";
    public static String VILLAGE_NOT_FOUND = "Vila não encontrada";
    public static String SUBCOMMAND_INVALID = "Subcomando inválido";
    public static String DISCORD = ChatColor.AQUA + "[DC]";
    public static String GLOBAL = ChatColor.GOLD + "Global";

    private String name;
    private String message;
    private boolean fromDiscord;
    private Player player;

    Message(String name, String message, boolean fromDiscord) {
        this.name = name;
        this.message = message;

        this.player = Plugin.getInstance().getServer().getPlayer(name);
    }

    private String getDiscordNotation() {
        return (fromDiscord) ? DISCORD : "";
    }

    private String getPlayerCompleteVillagePrefix() {
        if (player == null) {
            return "";
        }

        Village playerVillage = Village.getVillageByPlayer(player);

        return playerVillage.getTextColor() + playerVillage.getName();
    }

    private String getPlayerName() {
        return ChatColor.WHITE + name + ":";
    }

    private void consoleLogMessage(String message) {
        Plugin.getInstance().getServer().getConsoleSender().sendMessage(message);
    }

    private void sendMessageToEveryone(String message) {
        for (Player player : Plugin.getInstance().getServer().getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    public String sendGlobalMessage() {
        List<String> splittedMessage = new ArrayList<String>();

        splittedMessage.add(getDiscordNotation());
        splittedMessage.add(GLOBAL);
        splittedMessage.add(getPlayerCompleteVillagePrefix());
        splittedMessage.add(getPlayerName());
        splittedMessage.add(message);

        String finalMessage = String.join(" ", splittedMessage);

        consoleLogMessage(finalMessage);
        sendMessageToEveryone(finalMessage);

        return finalMessage;
    }

}
