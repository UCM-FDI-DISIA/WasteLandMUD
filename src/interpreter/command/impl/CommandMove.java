package interpreter.command.impl;

import world.Direction;
import world.Player;
import world.Room;

public class CommandMove extends AbstractCommand {

	Player player;
	String target;

	public CommandMove() {

	}

	public CommandMove(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	private Direction convertDirection(String direction) {

		Direction dir = null;
		
		if (direction.equals("north") || direction.equals("n")) {
			dir = Direction.NORTH;
		} 

		if (direction.equals("south") || direction.equals("s")) {
			dir = Direction.SOUTH;
		} 

		if (direction.equals("east") || direction.equals("e")) {
			dir = Direction.EAST;
		} 

		if (direction.equals("west") || direction.equals("w")) {
			dir = Direction.WEST;
		} 

		if (direction.equals("up") || direction.equals("u")) {
			dir = Direction.UP;
		} 

		if (direction.equals("down") || direction.equals("d")) {
			dir = Direction.DOWN;
		} 

		return dir;		
	}

	@Override
	public void execute() {

		Direction dir = this.convertDirection(target);
		this.move(player, dir);
	}
	
	/*
	 * this method moves a player in the specified direction.
	 */
	private void move(Player player, Direction dir) {
		Room destination = ((Room) player.getLocation())
				.getExitDestination(dir);
		if (destination == null) {
			player.sendToPlayer("You can't go that way.");
			return;
		}

		((Room) this.world.getDatabaseObject(player.getRoomId())).sendToRoom(""
				+ player.getName() + " exits " + dir.toString().toLowerCase()
				+ ".", player);

		player.moveToRoom(destination);

		String from = "";
		if (dir == Direction.NORTH) {
			from = "south";
		} else if (dir == Direction.EAST) {
			from = "west";
		} else if (dir == Direction.SOUTH) {
			from = "north";
		} else if (dir == Direction.WEST) {
			from = "east";
		} else if (dir == Direction.DOWN) {
			from = "above";
		} else if (dir == Direction.UP) {
			from = "below";
		}

		((Room) this.world.getDatabaseObject(player.getRoomId())).sendToRoom(""
				+ player.getName() + " enters from " + from + ".", player);
	}
}
