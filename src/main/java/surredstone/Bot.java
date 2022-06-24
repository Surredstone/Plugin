package surredstone;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import surredstone.bot.events.MessageReceivedListener;
import surredstone.bot.events.ReadyListener;

public class Bot {
    private static Bot _instance;
    JDA bot;

    private Bot(String token) {
        try {

            this.bot = JDABuilder
                    .createDefault(token)
                    .disableIntents(
                            GatewayIntent.GUILD_PRESENCES,
                            GatewayIntent.GUILD_MESSAGE_TYPING)
                    .addEventListeners(new ReadyListener())
                    .addEventListeners(new MessageReceivedListener())
                    .setActivity(Activity.playing(
                            Presence.getPresenceMessage(
                                    Presence.getCurrentOnlinePlayersMessage(
                                            Plugin.getOnlinePlayers().size()))))
                    .build();

        } catch (LoginException e) {
            Logger.logConsoleLog(Log.getMinecraftLog("BOT_LOGIN_FAILURE").getLog());
        }
    }

    public static Bot getInstance(String token) {
        if (_instance == null)
            _instance = new Bot(token);
        return _instance;
    }

    private static Bot getInstance() {
        return _instance;
    }

    public static SelfUser getBotUser() {
        return getInstance().bot.getSelfUser();
    }

    public static void stop() {
        Logger.logDiscordGlobal(Log.getDiscordLog("SERVER_CLOSE").getLog());
        Logger.logConsoleLog(Log.getMinecraftLog("BOT_SHUTDOWN_SUCCESS").getLog());
        getInstance().bot.shutdownNow();
    }

    public static TextChannel getGlobalChannel() {
        return getInstance().bot.getTextChannelById(Plugin.getDiscordMainChannelId());
    }

    public static TextChannel getVillageChannel(Village village) {
        return getInstance().bot.getTextChannelById(village.getDiscordChannelId());
    }

    public static void sendMessageToVillage(Village village, String message) {
        getVillageChannel(village).sendMessage(message).complete();
    }

    public static void sendMessageToMainChannel(String message) {
        getGlobalChannel().sendMessage(message).complete();
    }

    public static void updatePresenceMessage(String message) {
        getInstance().bot.getPresence().setActivity(Activity.playing(message));
    }
}
