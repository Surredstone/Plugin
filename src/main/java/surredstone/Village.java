package surredstone;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Village {
    final int id;
    String name;
    String abbreviation;
    String color;
    String info;

    static private List<Village> villages = new ArrayList<Village>();

    private Village(
            final int id,
            String name,
            String abbreviation,
            String color,
            String info) {
        if (abbreviation.contains(" ") || abbreviation.contains("   "))
            throw new Error(Message.INVALID_VILLAGE_STORAGE_ERROR);

        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation.toLowerCase();
        this.color = color;
        this.info = info;
    }

    static private YamlConfiguration getVillageStorage() {
        return YamlConfiguration.loadConfiguration(new File(Plugin.getInstance().getDataFolder() + "/villages.yml"));
    }

    static public List<Village> getAllVillages() {
        if (villages.size() == 0) {
            YamlConfiguration villageStorage = getVillageStorage();

            for (int i = 0; i < villageStorage.getKeys(false).size(); i++) {
                String idStringfied = String.valueOf(i);

                villages.add(new Village(
                        i,
                        villageStorage.getString(idStringfied + ".name"),
                        villageStorage.getString(idStringfied + ".abbreviation"),
                        villageStorage.getString(idStringfied + ".color"),
                        villageStorage.getString(idStringfied + ".info")));
            }
        }

        return villages;
    }

    static public Village getVillageByAbbreviation(String abbreviation) {
        for (Village village : getAllVillages()) {
            if (village.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return village;
            }
        }

        return null;
    }

    static public Village getVillageById(int id) {
        for (Village village : getAllVillages()) {
            if (village.getId() == id) {
                return village;
            }
        }

        return null;
    }

    static public Village getVillageByPlayer(Player player) {
        for (Village village : getAllVillages()) {
            if (player.hasPermission(village.getPermission())) {
                return village;
            }
        }

        return null;
    }

    public List<Player> getOnlinePlayers() {
        Collection<? extends Player> onlinePlayers = Plugin.getInstance().getServer().getOnlinePlayers();

        List<Player> players = new ArrayList<Player>();

        for (Player player : onlinePlayers) {
            if (player.hasPermission(getPermission())) {
                players.add(player);
            }
        }

        return players;
    }

    public String getPermission() {
        return "surredstone.villages." + getAbbreviation();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation.toLowerCase();
    }

    public String getColorName() {
        return color;
    }

    public ChatColor getTextColor() {
        for (ChatColor c : ChatColor.class.getEnumConstants()) {
            if (c.name().equalsIgnoreCase(getColorName())) {
                return c;
            }
        }

        return null;
    }

    public String getInfo() {
        return info;
    }
}
