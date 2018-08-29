package bluebot.commands.utility;

import bluebot.utils.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @file SayCommand.java
 * @author Blue
 * @version 0.4
 * @brief Make the bot say the string given in parameter. Originally created to try giving parameters to bot commands
 */
public class SayCommand implements Command {

    private final String HELP = "The command `say` makes the bot say what you want. \n\nUsage : `!say your message`";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length == 0 || args[0].equals("help")) {
            return false;
        } else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String text = new String();
        for(String arg : args) {
            if(arg.equals("@everyone")) continue; //cause people don't like to be ping'd at all it seems
            text += arg + " ";
        }
        event.getMessage().delete().queue();
        event.getTextChannel().sendMessage(text).queue();
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getTextChannel().sendMessage(help()).queue();
        }
    }
}
