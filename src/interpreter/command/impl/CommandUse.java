package interpreter.command.impl;

import world.Player;

public class CommandUse extends AbstractCommand {

	Player player;
	String target;

	public CommandUse() {

	}

	public CommandUse(Player player) {
		this.player = player;
	}

	public CommandUse(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {
		
		if(target == null) {
			player.use(target);	
		}
		else {
			player.sendToPlayer("Use what?");		
		}
	}

}
