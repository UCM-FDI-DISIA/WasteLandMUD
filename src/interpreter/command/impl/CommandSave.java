package interpreter.command.impl;

import world.Player;

public class CommandSave extends AbstractCommand {

	Player player;

	public CommandSave() {

	}

	public CommandSave(Player player) {
		this.player = player;
	}

	@Override
	public void execute() {
		if (world.savePlayer(player)) {
			player.sendToPlayer("Player saved.");
		}
	}
}
