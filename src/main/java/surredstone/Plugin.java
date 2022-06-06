package surredstone;

import java.io.File;
import java.util.Collection;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import surredstone.commands.GlobalCommand;
import surredstone.commands.VillageCommand;
import surredstone.events.PlayerChatListener;
import surredstone.events.PlayerJoinListener;
import surredstone.events.PlayerQuitListener;

public class Plugin extends JavaPlugin {
    private static Plugin _instance;

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

        Logger.logConsoleLog(Log.getMinecraftLog("PLUGIN_ENABLE").getLog());
    }

    @Override
    public void onDisable() {
        Bot.stop();
        Logger.logConsoleLog(Log.getMinecraftLog("PLUGIN_DISABLE").getLog());
    }

    private static Plugin getInstance() {
        return _instance;
    }

    public static String getDiscordMainChannelId() {
        return getInstance().getConfig().getString("discord.main");
    }

    public static void consoleLog(String message) {
        getInstance().getServer().getConsoleSender().sendMessage(message);
    }

    public static Player getPlayerByName(String playerName) {
        return getInstance().getServer().getPlayer(playerName);
    }

    public static Collection<? extends Player> getOnlinePlayers() {
        return getInstance().getServer().getOnlinePlayers();
    }

    public static int getMaxPlayers() {
        return getInstance().getServer().getMaxPlayers();
    }

    public static File getDataFolderFile() {
        return getInstance().getDataFolder();
    }
}
