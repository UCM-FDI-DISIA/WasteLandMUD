package world.composite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import world.DatabaseObject;
import world.Room;

public class LocationCompiler {
	
	List<Location> locations;

	public LocationCompiler() {
		// TODO Auto-generated constructor stub
	}

	public Location compileWorld( List<DatabaseObject> databaseArray) {
		
		locations = new LinkedList<Location>();		
		
		for(DatabaseObject dbo : databaseArray) {
			
			if(dbo instanceof Room) {

				Room room = (Room)dbo;
				
				List<Room> roomsNested = room.listRooms();
				
				for(Room nested : roomsNested) {

					Location correspondingLocation = this.findLocation4room(nested);
					locations.remove(correspondingLocation);
				}
				
				Location loc4room = new LocationAdapter(room);
				locations.add(loc4room);	
			}				
		}
		
		return locations.get(0);
	}

	public Location compileWorld(Map<String,Room> roomSet) {
		
		locations = new LinkedList<Location>();		
		
		for(String key : roomSet.keySet()) {
			
			Room room = roomSet.get(key);
			
			List<Room> roomsNested = room.listRooms();
			
			for(Room nested : roomsNested) {

				Location correspondingLocation = this.findLocation4room(nested);
				locations.remove(correspondingLocation);
			}
			
			Location loc4room = new LocationAdapter(room);
			locations.add(loc4room);					
		}
		
		return locations.get(0);
	}
	
	private Location findLocation4room(Room room) {
		
		boolean found = false;
		
		Location correspondingLocation = null;
		
		Iterator<Location> it = locations.iterator();
		
		while(it.hasNext() && !found) {
			Location loc = it.next();
			found = loc.getName().equalsIgnoreCase(room.getName());
			if(found) {
				correspondingLocation = loc;
			}			
		}
		
		return correspondingLocation;		
	}
}
