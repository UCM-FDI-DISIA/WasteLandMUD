package interpreter.command.impl;

import world.Dreadnaught;
import world.Movable;
import world.Player;

public class CommandWound extends CommandCombat {

	public CommandWound() {
		
	}

	public CommandWound(Player player) {
		super(player);		
	}

	public CommandWound(Player player, String target) {
		super(player,target);		
	}

	/*
	 * This method initializes combat with an other.
	 */
	protected void kill(Movable attacker, Movable target) {


		if (player.getCharacterClass().toString()
				.equalsIgnoreCase("dreadnaught")) {
			((Dreadnaught) player.getCharacterClass())
					.Wound(player, target);
		} else {
			player
			.sendToPlayer("You aren't trained to Wound like that!");
		}
	}
}
