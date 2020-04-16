package world.creation;

import world.GearContainer;

public class GearFactory {

	public GearFactory() {
		// TODO Auto-generated constructor stub
	}
		
	public GearContainer buildCaptainsDesk() {
		return  new GearContainer("Captain's Cabinet",
				"(The captain's gun cabinet.)", 5, false);
	}
}
