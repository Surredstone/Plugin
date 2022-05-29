package surredstone;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Village {
    final int id;
    String name;
    String abbreviation;
    String color;
    String flag;

    static private List<Village> villages = new ArrayList<Village>();

    private Village(
            final int id,
            String name,
            String abbreviation,
            String color,
            String flag) {
        if (abbreviation.contains(" ") || abbreviation.contains("   "))
            throw new Error(Message.INVALID_VILLAGE_STORAGE_ERROR);

        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation.toLowerCase();
        this.color = color;
        this.flag = flag;
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
                        villageStorage.getString(idStringfied + ".flag")));
            }
        }

        return villages;
    }

    static public Village getVillageByAbbreviation(String abbreviation) {
        return getAllVillages()
                .stream()
                .filter(village -> village.getAbbreviation() == abbreviation.toLowerCase())
                .findFirst()
                .orElse(null);
    }

    static public Village getVillageById(int id) {
        List<Village> villages = getAllVillages();

        return villages
                .stream()
                .filter(village -> village.getId() == id)
                .findFirst()
                .orElse(null);
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

    public String getColor() {
        return color;
    }

    public String getFlag() {
        return flag;
    }
}
