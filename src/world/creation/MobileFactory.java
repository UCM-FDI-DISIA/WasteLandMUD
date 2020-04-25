package world.creation;

import world.Mobile;
import world.Room;

public interface MobileFactory {

	public Mobile createMobile(String name, String description, Room room,
			String whichStrategy, String message4strategy);

}