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
        this.senderPlayer = Plugin.getInstance().getServer().getPlayer(senderName);
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
                        : senderVillage.getAbbreviation());
    }

    public String generateMessage() {
        List<String> components = new ArrayList<String>();

        components.add((fromDiscord) ? MessageLine.DISCORD_LABEL : null);

        switch (type) {
            case DEFAULT:
                components.add(getSenderVillageInformation("abbreviation"));
                break;
            case VILLAGE:
                components.add(MessageLine.VILLAGE_LABEL);
                components.add(getSenderVillageInformation("name"));
                break;
            case GLOBAL:
                components.add(MessageLine.GLOBAL_LABEL);
                components.add(getSenderVillageInformation("name"));
                break;
        }

        components.add(((senderVillage != null)
                ? senderVillage.getTextColor()
                : "") + senderName + ":");

        components.add(message);

        components.removeIf(component -> (component == null));

        return String.join(" ", components);
    }

    public String generateMessageUncolor() {
        return ChatColor.stripColor(generateMessage());
    }
}
