package world.creation;

import world.Gear;
import world.Weapon;

public class GearFactory {

	public GearFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Gear buildLaserPistol() {
		return new Weapon("Laser Pistol",
				"A clunky old laser pistol; reliable, but ugly.", 1, 3);		
	}

}
