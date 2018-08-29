package bluebot.commands.fun.quickreactions;

import bluebot.utils.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @file NopeCommand.java
 * @author Blue
 * @version 0.2
 * @brief Posts https://www.youtube.com/watch?v=vsa1ZvzFgvU
 */
public class IDGFCommand implements Command {

    private final String HELP = "The command `idgf` posts a link to a fanfare. \n\nUsage : `!idgf`";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length != 0 && args[0].equals("help") || args.length != 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
            event.getTextChannel().sendMessage("https://www.youtube.com/watch?v=vsa1ZvzFgvU").queue();
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