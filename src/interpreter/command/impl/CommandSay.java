package interpreter.command.impl;

import java.util.List;

import interpreter.command.ReformatLine;
import interpreter.command.Trace;
import world.Player;
import world.Room;

public class CommandSay extends AbstractCommand {
	
	Player player;
	String message;

	public CommandSay() {
		
	}

	public CommandSay(Player player, String message) {
		this.message = message;
	}

	@Override
	public void execute() {
		
		if(Trace.getTraceSwitch()) {

			System.out.println("SAY");
			
			System.out.println(message);
		}
		else {
			((Room) this.world.getDatabaseObject(player.getRoomId()))
			.sendToRoom("chat " + player.getName() + " says: " + message);
		}

	}
}
