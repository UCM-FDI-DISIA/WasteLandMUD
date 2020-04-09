package interpreter.command.impl;

import interpreter.command.Trace;
import world.Player;
import world.Room;

public class CommandEmote extends AbstractCommand {

	Player player;
	String message;

	public CommandEmote() {
	}

	public CommandEmote(Player player, String message) {
		this.message = message;
	}

	@Override
	public void execute() {

		
		if(Trace.getTraceSwitch()) {

			System.out.println("EMOTE");
			
			System.out.println(message);
		}
		else {

			((Room) player.getLocation()).sendToRoom(player.getName()
					+ " " + message);
			
		}

	}

}
