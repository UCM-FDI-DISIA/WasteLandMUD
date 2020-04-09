package interpreter.command.impl;

import world.DatabaseObject;
import world.Player;
import world.Room;

public class CommandLook extends AbstractCommand {

	Player player;
	String target;

	public CommandLook() {

	}

	public CommandLook(Player player) {
		this.player = player;
	}

	public CommandLook(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {

		if(target != null) {
			look(player, target);
		}
		else {
			player.sendToPlayer(((Room) player.getLocation()).generateDescription());
		}
	}

	/*
	 * This method lets a player look at another player, item, or mobile.
	 */
	private void look(Player player, String objName) {

		for (DatabaseObject item : world.getDatabaseObjects()) {
			if (item.getName().toLowerCase().equals(
					objName.toLowerCase().trim())) {
				player.sendToPlayer(item.getDescription());
				return;
			}
		}

		player.sendToPlayer(objName + " is not here.");
	}

}
