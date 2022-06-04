package surredstone;

import org.bukkit.plugin.java.JavaPlugin;

import surredstone.commands.GlobalCommand;
import surredstone.commands.VillageCommand;
import surredstone.events.PlayerChatListener;
import surredstone.events.PlayerJoinListener;
import surredstone.events.PlayerQuitListener;

public class Plugin extends JavaPlugin {
    static Plugin _instance;

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

        Bot.getInstance(getConfig().getString("discord.token"));

        getServer().getConsoleSender().sendMessage(MessageLine.PLUGIN_ENABLE);
    }

    @Override
    public void onDisable() {
        Bot.getInstance().stop();
        getServer().getConsoleSender().sendMessage(MessageLine.PLUGIN_DISABLE);
    }

    public static Plugin getInstance() {
        return _instance;
    }

    public String getDiscordMainChannelId() {
        return getConfig().getString("discord.main");
    }
}
