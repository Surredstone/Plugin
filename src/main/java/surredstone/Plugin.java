package surredstone;

import org.bukkit.plugin.java.JavaPlugin;

import surredstone.commands.GlobalCommand;
import surredstone.commands.VillageCommand;
import surredstone.events.PlayerChatListener;
import surredstone.events.PlayerJoinListener;
import surredstone.events.PlayerQuitListener;

public class Plugin extends JavaPlugin {
    static Plugin _instance;
    Bot bot;

    @Override
    public void onEnable() {
        _instance = this;

        saveDefaultConfig();
        saveResource("villages.yml", false);

        getServer().getPluginManager().registerEvents(new PlayerChatListener(), getInstance());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), getInstance());
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), getInstance());

        getCommand("global").setExecutor(new GlobalCommand());
        getCommand("village").setExecutor(new VillageCommand());

        createBot(getConfig().getString("discord.token"));

        getServer().getConsoleSender().sendMessage(Message.ON_PLUGIN_ENABLE);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(Message.ON_PLUGIN_DISABLE);
    }

    public static Plugin getInstance() {
        return _instance;
    }

    public Bot createBot(String token) {
        this.bot = Bot.getInstance(token);
        return this.bot;
    }

    public String getOnlinePlayersString() {
        return String.valueOf(
            getServer().getOnlinePlayers().size())
            + "/" +
            String.valueOf(getServer().getMaxPlayers());
    }
}
