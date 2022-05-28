package surredstone;

import org.bukkit.plugin.java.JavaPlugin;

import surredstone.commands.Global;
import surredstone.events.PlayerChat;

public class Plugin extends JavaPlugin {
    static Plugin _instance;

    @Override
    public void onEnable() {
        _instance = this;

        saveResource("villages.yml", false);

        getServer().getPluginManager().registerEvents(new PlayerChat(), getInstance());

        getCommand("global").setExecutor(new Global());

        getServer().getConsoleSender().sendMessage(Message.ON_PLUGIN_ENABLE);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(Message.ON_PLUGIN_DISABLE);
    }

    public static Plugin getInstance() {
        return _instance;
    }
}
