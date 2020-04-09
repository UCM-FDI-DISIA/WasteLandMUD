package interpreter.command.impl;

import java.util.List;

import world.Player;

public class CommandGive extends AbstractCommand {

	Player player;
	List<String> arguments;

	public CommandGive() {

	}

	public CommandGive(Player player, List<String> arguments) {
		this.player = player;
		this.arguments = arguments;
	}

	@Override
	public void execute() {

		if(arguments.isEmpty()) {

			player.sendToPlayer("Give what?");
		}
		else {
			if(arguments.size()==1) {
				
				String itemName = arguments.get(0);
				
				player.sendToPlayer("Give " + itemName 	+ " to who or what?");
			}
			else {			

				String itemName = arguments.get(0);
				String target = arguments.get(1);
				
				player.giveGear(player, itemName, target);
			}	
		}
	}

	/*
	 * Tell sends a message between two players, visible only to them.
	 * 
	 * @param player The initiating player of the whisper
	 * 
	 * @param otherPlayer The recipient of the whisper
	 * 
	 * @param message The actual text of the whisper
	 */
	private void tell(Player player, Player otherPlayer, String message) {
		if (otherPlayer != null) {
			otherPlayer.sendToPlayer("chat " + player.getName()
					+ " whispers : " + message);
			player.sendToPlayer("chat You whisper to " + otherPlayer.getName()
					+ ": " + message);
		} else
			player.sendToPlayer("Player does not exist.");
	}
}
