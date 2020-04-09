package interpreter;

import java.util.List;

import interpreter.command.Command;
import world.Player;

public class InterpreterRefactored {

	public InterpreterRefactored() {
		// TODO Auto-generated constructor stub
	}
	public synchronized void processCommand(Player player, String textCommand) {
		
		List<String> parsedCommandSequence = CommandParser.parseCommand(textCommand);
		
		Command command = CommandInstantiator.instantiate(player, parsedCommandSequence);
		
		command.execute();		
	}
}
