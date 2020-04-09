package interpreter;

import java.util.List;

import interpreter.command.Command;
import interpreter.command.ReformatLine;
import interpreter.command.impl.CommandCommands;
import interpreter.command.impl.CommandDescribeMe;
import interpreter.command.impl.CommandEmote;
import interpreter.command.impl.CommandLook;
import interpreter.command.impl.CommandRude;
import interpreter.command.impl.CommandSave;
import interpreter.command.impl.CommandSay;
import interpreter.command.impl.CommandTell;
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

			case "save":

				 command = new CommandSave(player);	
				break;

			case "describeme":
				if(parsedCommandSequence.size()>1) {

					String description  = 
							ReformatLine.reformat(
									parsedCommandSequence.subList(1, parsedCommandSequence.size())
									);

					 command = new CommandDescribeMe(player, description);
				}
				else {
					 command = new CommandDescribeMe(player);					
				}
				
				break;

			case "tell":

				command = 
				     new CommandTell(
						player, 
						parsedCommandSequence.subList(1, parsedCommandSequence.size()));
				
				break;

			case "look":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandLook(player, target);
				}
				else {
					 command = new CommandLook(player);					
				}
				
				break;
		}
		
		return command;		
	}
}
