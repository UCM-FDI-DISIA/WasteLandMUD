package interpreter.command.impl;

import world.Player;
import world.Room;

public class CommandEmote extends AbstractCommand {

	Player player;
	String message;

	public CommandEmote() {
	}

	public CommandEmote(Player player, String message) {
		this.player = player;
		this.message = message;
	}

	@Override
	public synchronized void execute() {
		
		message = player.getName() + " " +message;

		((Room) player.getLocation()).sendToRoom(player.getName()
				+ " " + message);		
	}
}
