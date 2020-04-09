package interpreter.command.impl;

import world.DatabaseObject;
import world.Dreadnaught;
import world.Gunner;
import world.Player;

public class CommandSetClass extends AbstractCommand {

	Player player;
	String characterClass;

	public CommandSetClass() {

	}

	public CommandSetClass(Player player) {
		this.player = player;
	}

	public CommandSetClass(Player player, String characterClass) {
		this.player = player;
		this.characterClass = characterClass;
	}

	@Override
	public void execute() {

		if(characterClass != null) {
			if (characterClass.equalsIgnoreCase("gunner")) {
				player.setCharacterClass(Gunner.getInstance());
			} else 
				if (characterClass.equalsIgnoreCase("dreadnaught")) {
					player.setCharacterClass(Dreadnaught.getInstance());
				} else {
					player.sendToPlayer(characterClass
							+ " is not a character class.");
				}
		}
		else {
			player.sendToPlayer("Please type a class name: Gunner or Dreadnaught.");
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
