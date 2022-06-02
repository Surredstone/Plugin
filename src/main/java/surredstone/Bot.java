package surredstone;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
    JDA bot;

    Bot(String token) {
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING);
        builder.setActivity(Activity.playing("Surredstone"));

        try {
            this.bot = builder.build();
        } catch (LoginException e) {
            Plugin.getInstance().getServer().getConsoleSender().sendMessage(Message.BOT_LOGIN_FAILURE);
        }
    }
}
