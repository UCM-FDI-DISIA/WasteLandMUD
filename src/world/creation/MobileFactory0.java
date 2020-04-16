package world.creation;

import world.Greets;
import world.Mobile;
import world.Room;
import world.Strategy;
import world.World;

public class MobileFactory0 {

	private World world = World.getInstance();

	public MobileFactory0() {
		// TODO Auto-generated constructor stub
	}

	
	public Mobile buildMarine(Room location) {

		return world.createMobile("Off-Duty Marine", "An off duty marine.",
				location, new Greets());
	}

}
