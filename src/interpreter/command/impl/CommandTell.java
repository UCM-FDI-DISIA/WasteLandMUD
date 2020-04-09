package interpreter.command.impl;

import java.util.List;

import interpreter.command.ReformatLine;
import world.Player;

public class CommandTell extends AbstractCommand {

	Player player;
	List<String> arguments;

	public CommandTell() {

	}

	public CommandTell(Player player, List<String> arguments) {
		this.player = player;
		this.arguments = arguments;
	}

	@Override
	public void execute() {

		if(arguments.isEmpty()) {

			player.sendToPlayer("Tell who... What?");
		}
		else {
			if(arguments.size()==1) {

				player.sendToPlayer("Tell them what?");
			}
			else {

				String otherPlayerName = arguments.get(0);

				String message = 
						ReformatLine.reformat(
								arguments.subList(2, arguments.size())
								);
				
				if (world.playerIsLoggedOn(otherPlayerName)) {
					this.tell(player, world.getPlayer(otherPlayerName),message);
				} else {
					player.sendToPlayer(otherPlayerName
							+ " is not logged on.");
				}
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
