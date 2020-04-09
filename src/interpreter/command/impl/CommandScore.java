package interpreter.command.impl;

import world.Player;

public class CommandScore extends AbstractCommand {

	Player player;
	
	public CommandScore() {

	}

	public CommandScore(Player player) {
		this.player = player;
	}

	@Override
	public void execute() {
		player.sendToPlayer(player.getStats());
	}
}
