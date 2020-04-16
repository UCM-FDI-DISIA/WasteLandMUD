package world.creation.builder;

import world.Direction;
import world.World;

public interface WorldBuilder {
	
	public void buildWorld();
	
	public World getWorld();
	
	public void buildRoom(String id, String name, String description);

	public void buildExit(String roomFrom, String whichWay, String roomTo);
	
	public void nestRooms(String outerRoom, String roomWithin);
}
