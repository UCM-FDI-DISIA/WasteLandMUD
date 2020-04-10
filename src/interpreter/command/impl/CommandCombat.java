package interpreter.command.impl;

import world.CombatManager;
import world.Movable;
import world.Player;
import world.Room;

public class CommandCombat extends AbstractCommand {

	Player player;
	String target;

	public CommandCombat() {
		
	}

	public CommandCombat(Player player) {
		this.player = player;		
	}

	public CommandCombat(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {
		
		if (player.getFighting() == true) {
			player.sendToPlayer("You cannot attack because you are already in battle");
		}
		else {
			if(target == null) {
				player.sendToPlayer("Who do you want to attack? (Attack <victim>)");	
			}
			else {	

				//

				for (Movable i : ((Room) player.getLocation())
						.listMovables()) {
					if (i.getName().equalsIgnoreCase(target)) {

						if (i.getFighting()) {
							player.sendToPlayer(i.getName()
									+ " is already in battle");
						}
						else {

							kill(player, i);
						}
					}
				}
			}			
		}
	}

	/*
	 * This method initializes combat with an other.
	 */
	private void kill(Movable attacker, Movable target) {
		CombatManager attack = new CombatManager(attacker, target);
	}
}
