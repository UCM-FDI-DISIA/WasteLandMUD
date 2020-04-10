package interpreter.command.impl;

import world.Gunner;
import world.Movable;
import world.Player;

public class CommandSnipe extends CommandCombat {

	public CommandSnipe() {
		
	}

	public CommandSnipe(Player player) {
		super(player);		
	}

	public CommandSnipe(Player player, String target) {
		super(player,target);		
	}

	/*
	 * This method initializes combat with an other.
	 */
	protected void kill(Movable attacker, Movable target) {

		if (player.getCharacterClass().toString()
				.equalsIgnoreCase("Gunner")) {
			((Gunner) player.getCharacterClass())
			.Snipe(player, target);
		} else {
			player
			.sendToPlayer("You aren't trained in sniping!");
		}
	}
}
