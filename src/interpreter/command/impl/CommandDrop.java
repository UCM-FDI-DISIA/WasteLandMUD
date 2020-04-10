package interpreter.command.impl;

import world.Player;

public class CommandDrop extends AbstractCommand {

	Player player;
	String target;

	public CommandDrop() {

	}

	public CommandDrop(Player player) {
		this.player = player;
	}

	public CommandDrop(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public synchronized void execute() {
		
		if(target == null) {
			player.sendToPlayer("Drop what?");	
		}
		else {	
			player.dropGear(target);	
		}
	}
}
