package interpreter.command.impl;

import world.CombatManager;
import world.Dreadnaught;
import world.Gunner;
import world.Movable;
import world.Player;
import world.Room;

public class CommandCombatAll extends AbstractCommand {

	Player player;
	String target;
	String how;

	public CommandCombatAll() {
		
	}

	public CommandCombatAll(Player player) {
		this.player = player;		
	}

	public CommandCombatAll(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	public CommandCombatAll(Player player, String target, String how) {
		this.player = player;
		this.target = target;
		this.how = how;
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
							if(how != null) {
								
								// Alternate Attack Types
								
								if (how.equalsIgnoreCase("snipe")) {
									if (player.getCharacterClass().toString()
											.equalsIgnoreCase("Gunner")) {
										((Gunner) player.getCharacterClass())
												.Snipe(player, i);
									} else {
										player
												.sendToPlayer("You aren't trained in sniping!");
									}
								}
								if (how.equals("wound")) {
									if (player.getCharacterClass().toString()
											.equalsIgnoreCase("dreadnaught")) {
										((Dreadnaught) player.getCharacterClass())
												.Wound(player, i);
									} else {
										player
												.sendToPlayer("You aren't trained to Wound like that!");
									}
								}								
							}
							else {
								
								// generic attack

								kill(player, i);
							}
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
