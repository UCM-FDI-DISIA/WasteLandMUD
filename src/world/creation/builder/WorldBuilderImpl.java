package world.creation.builder;

import java.util.HashMap;
import java.util.Map;

import world.Direction;
import world.Room;
import world.World;

public class WorldBuilderImpl implements WorldBuilder {
	
	World worldBeingBuilt;
	
	Map<String,Room> roomSet;

	public WorldBuilderImpl() {
		roomSet = new HashMap<String,Room>();
		worldBeingBuilt = World.getInstance();
	}

	@Override
	public void buildWorld() {
		
		WorldDataParser parser = new WorldDataParser(this);
		
		parser.parseFile("data/world-data.txt");
	}

	@Override
	public World getWorld() {
		return worldBeingBuilt;
	}

	@Override
	public void buildRoom(String id, String name, String description) {
		Room room = new Room(name);
		room.setDescription(description);
		roomSet.put(id, room);
		//
		worldBeingBuilt.addToWorld(room);
	}

	@Override
	public void buildExit(String roomFrom, String whichWay, String roomTo) {

		Room room1 = roomSet.get(roomFrom);
		Room room2 = roomSet.get(roomTo);

		Direction dir = DirectionEncoder.convertDirection(whichWay);
		
		room1.setExitDestination(dir, room2);
	}

	@Override
	public void nestRooms(String outerRoom, String roomWithin) {
		Room room1 = roomSet.get(outerRoom);
		Room room2 = roomSet.get(roomWithin);
		room1.add(room2);		
	}
}
