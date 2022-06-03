package surredstone;

import javax.security.auth.login.LoginException;

import org.bukkit.ChatColor;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
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
                    .setActivity(Activity.playing(
                            "Surredstone - "
                                    + Plugin.getInstance().getOnlinePlayersString()))
                    .build();

        } catch (LoginException e) {
            Plugin.getInstance().getServer().getConsoleSender().sendMessage(Message.BOT_LOGIN_FAILURE);
        }
    }

    public static Bot getInstance(String token) {
        if (_instance == null)
            _instance = new Bot(token);
        return _instance;
    }

    public static Bot getInstance() {
        return _instance;
    }

    public void stop() {
        bot.shutdown();
    }

    public void setPresence(String text) {
        bot.getPresence().setActivity(Activity.playing("Surredstone - " + text));
    }

    public void sendMessageToVillage(Village village, String message) {
        bot.getTextChannelById(village.getDiscordChannelId())
                .sendMessage(ChatColor.stripColor(message));
    }

    public void sendMessageToMainChannel(String message) {
        bot.getTextChannelById(Plugin.getInstance().getDiscordMainChannelId())
                .sendMessage(ChatColor.stripColor(message));
    }
}
