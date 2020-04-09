package interpreter.command.impl;

import java.util.List;

import world.Gear;
import world.GearContainer;
import world.Player;
import world.Room;

public class CommandGet extends AbstractCommand {

	Player player;
	List<String> arguments;

	public CommandGet() {

	}

	public CommandGet(Player player) {
		this.player = player;
	}

	public CommandGet(Player player, List<String> arguments) {
		this.player = player;
		this.arguments = arguments;
	}

	@Override
	public void execute() {
		
		if(arguments.isEmpty()) {
			player.sendToPlayer("Get what?");
		}
		else {
			if(arguments.size()==1) {
				
				String itemName = arguments.get(0);
				
				this.get(itemName);				
			}
			else {				

				String itemName = arguments.get(0);
				String target = arguments.get(1);
				
				this.get(itemName, target);
			}
		}
	}
	
	private void get(String itemName) {
		
		boolean found = false;

		for (Gear roomItem : ((Room) player.getLocation())
				.listGear()) {
			if (roomItem.getName().equalsIgnoreCase(itemName)) {
				found = true;
				if (roomItem instanceof GearContainer
						&& !((GearContainer) roomItem)
								.canBeCarried()) {
					player.sendToPlayer(itemName
							+ " cannot be carried.");
				}
				else {
					player.addGear(roomItem);
					((Room) player.getLocation()).remove(roomItem);							
				}
			}
		}
		if(!found) {

			player.sendToPlayer(itemName + " is not in the room.");
		}		
	}
	
	private void get(String itemName, String target) {
		
		boolean giveable = false;
		
		if (world.playerExists(target)
				&& world.playerIsLoggedOn(target)) {
			if (!world.getPlayer(target).giveGear(
					world.getPlayer(target), itemName,
					player.getName())) {
				player.sendToPlayer(target
						+ " does not have that item.");
			}
			else {
				giveable = true;
			}
		}
		if (world.mobileExists(target)) {
			if (!world.getMobile(target).giveGear(
					world.getMobile(target), itemName,
					player.getName())) {
				player.sendToPlayer(target
						+ " does not have that item.");
			}
			else {
				giveable = true;
			}
		}
		
		if(giveable) {

			for (Gear roomItem : ((Room) player.getLocation())
					.listGear()) {
				if (roomItem instanceof GearContainer
						&& target.equals(roomItem.getName()
								.toLowerCase())) {
					if (((GearContainer) roomItem).giveGear(null,
							itemName, player.getName())) {
						return;
					} else {
						player.sendToPlayer("Does " + target
								+ " have that item?");
					}
				}
			}					
		}
		
	}
}
