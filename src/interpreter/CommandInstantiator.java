package interpreter;

import java.util.List;

import interpreter.command.Command;
import interpreter.command.ReformatLine;
import interpreter.command.impl.CommandCommands;
import interpreter.command.impl.CommandEmote;
import interpreter.command.impl.CommandRude;
import interpreter.command.impl.CommandSay;
import interpreter.command.impl.CommandWho;
import world.Player;

public class CommandInstantiator {
	
	public static Command instantiate(Player player, List<String> parsedCommandSequence) {
		
		Command command = null;
		
		String commandWord = parsedCommandSequence.get(0);
		
		switch(commandWord) {

			case "say":  
				if(parsedCommandSequence.size()>1) {

					String message  = 
							ReformatLine.reformat(
									parsedCommandSequence.subList(1, parsedCommandSequence.size())
									);

					 command = new CommandSay(player, message);
				}
				else {
					 command = new CommandSay(player, "Say what?");					
				}
				break;

			case "emote":
				if(parsedCommandSequence.size()>1) {

					String message  = 
							ReformatLine.reformat(
									parsedCommandSequence.subList(1, parsedCommandSequence.size())
									);

					 command = new CommandEmote(player, message);
				}
				else {
					 command = new CommandEmote(player, "Emote what?");					
				}
				
				break;

			case "rude":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandRude(player, target);
				}
				else {
					 command = new CommandRude(player);					
				}
				
				break;

			case "commands":

				 command = new CommandCommands(player);	
				break;

			case "who":

				 command = new CommandWho(player);	
				break;
		}
		
		return command;		
	}
}
