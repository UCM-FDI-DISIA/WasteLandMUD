package interpreter.command.impl;

import world.DatabaseObject;
import world.GearList;
import world.Player;

public class CommandInspect extends AbstractCommand {

	Player player;
	String target;

	public CommandInspect() {

	}

	public CommandInspect(Player player) {
		this.player = player;
	}

	public CommandInspect(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {
		
		if(target == null) {	
			player.sendToPlayer("Inspect what?");	
		}
		else {
			inspect(player, target);		
		}
	}

	/*
	 * this method inspectwS the contents of an item container.
	 */
	private void inspect(Player player, String objName) {
		for (DatabaseObject item : world.getDatabaseObjects()) {
			if (item.getName().toLowerCase().equals(
					objName.toLowerCase().trim())
					&& (item instanceof world.GearList)) {
				player.sendToPlayer(((GearList) item).inspect());
				return;
			}
		}

		player
				.sendToPlayer(objName
						+ " does not exist or cannot be inspected.");
	}
}
