package interpreter.command.impl;

import world.Movable;
import world.Player;
import world.Room;

public class CommandRude extends AbstractCommand {

	Player player;
	String target;

	public CommandRude() {

	}

	public CommandRude(Player player) {
		this.player = player;
	}

	public CommandRude(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {
		
		String message = player.getName() + " makes a rude gesture";
		
		if(target == null) {
			((Room) player.getLocation()).sendToRoom(message + "!");			
		}
		else {

			for (Movable mov : ((Room) player.getLocation())
					.listMovables()) {
				if (mov.getName().equalsIgnoreCase(target)) {
					((Room) player.getLocation()).sendToRoom(message + " at " + target + "!");
				}
			}			
		}
	}
}
