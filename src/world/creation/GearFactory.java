package world.creation;

import world.Armor;
import world.Gear;
import world.GearContainer;
import world.HealthOrb;
import world.Weapon;

public class GearFactory {

	public GearFactory() {
		// TODO Auto-generated constructor stub
	}
		
	public GearContainer buildCaptainsDesk() {
		return  new GearContainer("Captain's Cabinet",
				"(The captain's gun cabinet.)", 5, false);
	}
	
	
	// Armor
	

	public Gear buildFlakVest() {
		return new Armor("Flak Vest",
				"A sturdy vest meant to protect the wearer's torso.", 2, 'M');	
	}

	public Gear buildRegolithSuit() {
		return new Armor("Regolith Suit",
				"Armor made of the planet's processed regolith (very strong).",
				2, 'H');	
	}

	public Gear buildTuxTandJeans() {
		return new Armor(
				"Tuxedo T-Shirt and Jeans",
				"Tuxedo T-Shirt and Jeans (even your Mom won't think your funny).",
				1, 'L');	
	}


	public Gear buildAssaultCuirass() {
		return new Armor(
				"Assault SNO Cuirass",
				"(Despite it's requirements to withstand orbital strikes, this armor appears to "
						+ "be a composite, made out of strange glowing rectangles connected by dotted lines "
						+ "in some technological pattern.)", 3,
				'H');	
	}
}
