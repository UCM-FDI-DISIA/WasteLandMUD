package interpreter;

import java.util.List;

import interpreter.command.Command;
import interpreter.command.ReformatLine;
import interpreter.command.impl.CommandSay;
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

		}
		
		return command;		
	}
}
