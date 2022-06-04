package surredstone;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import surredstone.bot.events.ReadyListener;
import surredstone.bot.events.ShutdownListener;

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
                    .addEventListeners(new ShutdownListener())
                    .setActivity(Activity.playing(
                            Presence.getPresenceMessage(
                                    Presence.getCurrentOnlinePlayersMessage(
                                            Plugin.getOnlinePlayers().size()))))
                    .build();

        } catch (LoginException e) {
            Plugin.consoleLog(MessageLine.BOT_LOGIN_FAILURE);
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

    public static void stop() {
        getInstance().bot.shutdownNow();
    }

    public static void sendMessageToVillage(Village village, String message) {
        getInstance().bot.getTextChannelById(village.getDiscordChannelId())
                .sendMessage(message).complete();
    }

    public static void sendMessageToMainChannel(String message) {
        getInstance().bot.getTextChannelById(Plugin.getDiscordMainChannelId())
                .sendMessage(message).complete();
    }

    public static void updatePresenceMessage(String message) {
        getInstance().bot.getPresence().setActivity(Activity.playing(message));
    }
}
