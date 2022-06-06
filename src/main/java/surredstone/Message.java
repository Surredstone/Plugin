package surredstone;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {
    String senderName;
    Player senderPlayer;
    Village senderVillage;
    String message;
    boolean fromDiscord;
    MessageType type;

    public Message(String senderName, String message, boolean fromDiscord, MessageType type) {
        this.senderName = senderName;
        this.senderPlayer = Plugin.getPlayerByName(senderName);
        this.senderVillage = Village.getVillageByPlayer(senderPlayer);
        this.message = message;
        this.fromDiscord = fromDiscord;
        this.type = type;
    }

    public String getSenderVillageInformation(String infoType) {
        if (senderVillage == null)
            return null;

        return String.format(
                "%s[%s]",
                senderVillage.getTextColor(),
                (infoType == "name")
                        ? senderVillage.getName()
                        : senderVillage.getAbbreviation().toUpperCase());
    }

    public String getDiscordIndicator() {
        return (fromDiscord) ? ChatColor.BLUE + "DC" : null;
    }

    public String getTypeIndicator() {
        switch (type) {
            case VILLAGE:
                return ChatColor.GOLD + "[V]";
            case GLOBAL:
                return ChatColor.GOLD + "[G]";
            default:
                return null;
        }
    }

    public String getPlayerVillageIndicator() {
        switch (type) {
            case VILLAGE:
                return getSenderVillageInformation("name");
            case GLOBAL:
                return getSenderVillageInformation("name");
            default:
                return getSenderVillageInformation("abbreviation");
        }
    }

    public String getUsernameIndicator() {
        return ((senderVillage != null)
                ? senderVillage.getTextColor()
                : "") + senderName + ":";
    }

    public String getMessageContent() {
        return ChatColor.WHITE + message;
    }

    public void sanitizeMessageContent(List<String> components) {
        components.removeIf(component -> (component == null));
    }

    public String uncolorMessage(String message) {
        return ChatColor.stripColor(message);
    }

    public String generateDiscordMessage() {
        List<String> components = new ArrayList<String>();

        if (type == MessageType.VILLAGE)
            components.add(getTypeIndicator());
        if (type != MessageType.DEFAULT)
            components.add(getPlayerVillageIndicator());
        components.add(getUsernameIndicator());
        components.add(getMessageContent());

        sanitizeMessageContent(components);

        return uncolorMessage(String.join(" ", components));
    }

    public String generateMinecraftMessage() {
        List<String> components = new ArrayList<String>();

        components.add(getDiscordIndicator());
        components.add(getTypeIndicator());
        components.add(getPlayerVillageIndicator());
        components.add(getUsernameIndicator());
        components.add(getMessageContent());

        sanitizeMessageContent(components);

        return String.join(" ", components);
    }

    public String toMinecraftLog() {
        return Log.getMinecraftLog("MESSAGE").getLog()
                .replace("%message_syntax", generateMinecraftMessage());
    }

    public String toDiscordLog() {
        return Log.getDiscordLog("MESSAGE").getLog()
                .replace("%message_syntax", generateDiscordMessage());
    }
}
