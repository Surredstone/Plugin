package surredstone;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import surredstone.bot.events.ReadyListener;

public class Bot {
    JDA bot;

    Bot(String token) {
        try {

            this.bot = JDABuilder
                    .createDefault(token)
                    .disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING)
                    .addEventListeners(new ReadyListener())
                    .setActivity(Activity.playing("Surredstone"))
                    .build();

        } catch (LoginException e) {
            Plugin.getInstance().getServer().getConsoleSender().sendMessage(Message.BOT_LOGIN_FAILURE);
        }
    }
}
