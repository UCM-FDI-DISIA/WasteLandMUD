package interpreter.command.impl;

import world.Player;

public class CommandGet extends AbstractCommand {

	Player player;
	String target;

	public CommandGet() {

	}

	public CommandGet(Player player) {
		this.player = player;
	}

	public CommandGet(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {
		
		if(target == null) {
			player.sendToPlayer("Get what?");
		}
		else {
			player.use(target);			
		}
	}

}
