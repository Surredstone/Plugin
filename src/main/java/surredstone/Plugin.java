package surredstone;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import surredstone.events.PlayerChat;

public class Plugin extends JavaPlugin {
    final String ON_ENABLE_LOG = ChatColor.GREEN + "Surredstone Plugin enabled";
    final String ON_DISABLE_LOG = ChatColor.RED + "Surredstone Plugin disabled";

    static Plugin _instance;

    @Override
    public void onEnable() {
        _instance = this;

        saveResource("villages.yml", false);

        getServer().getPluginManager().registerEvents(new PlayerChat(), getInstance());

        getServer().getConsoleSender().sendMessage(ON_ENABLE_LOG);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ON_DISABLE_LOG);
    }

    public static Plugin getInstance() {
        return _instance;
    }
}
