package world.creation.builder;

import java.util.HashMap;
import java.util.Map;

import world.Direction;
import world.Gear;
import world.GearContainer;
import world.Mobile;
import world.Room;
import world.World;

public class WorldBuilderImpl implements WorldBuilder {
	
	World worldBeingBuilt;
	
	Map<String,Room> roomSet;
	Map<String,GearContainer> gearContainerSet;
	Map<String,Mobile> mobileSet;

	public WorldBuilderImpl() {
		roomSet = new HashMap<String,Room>();
		gearContainerSet = new HashMap<String,GearContainer>();
		mobileSet = new HashMap<String,Mobile>();
		
		worldBeingBuilt = World.getInstance();
	}

	@Override
	public void buildWorld() {
		
		WorldDataParser parser = new WorldDataParser(this);
		
		parser.parseFile("data/world-data2.txt");
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

	@Override
	public void addGear(String where, Object gear) {

		Room room = roomSet.get(where);
		
		if(room != null) {

			room.add((Gear)gear);
			if(gear instanceof GearContainer) {
				GearContainer container = (GearContainer)gear;
				gearContainerSet.put(container.getName(), container);
			}
		}
		else {
			GearContainer container = gearContainerSet.get(where);
			if(container != null) {
				container.addGear((Gear)gear);				
			}
			else {
				Mobile mobile = mobileSet.get(where);
				if(mobile != null) {
					mobile.addGear((Gear)gear);				
				}
				else {
					
				}				
			}			
		}	
	}

	@Override
	public void addMobile(String where, Object mobile) {

		Room room = roomSet.get(where);
		
		if(room != null) {

			if(mobile instanceof Mobile) {
				Mobile mobileRep = (Mobile)mobile;
				mobileSet.put(mobileRep.getName(), mobileRep);
				

				mobileRep.setLocation(room);
				mobileRep.moveToRoom(room);
				mobileRep.setStart(room);

				room.add(mobileRep);			}
		}		
	}
}
