package world.creation;

import world.Gear;
import world.HealthOrb;

public class OrbFactory {

	public OrbFactory() {
		// TODO Auto-generated constructor stub
	}

	// Orbs

	public Gear buildHealthOrb() {
		return new HealthOrb(
				"Life Orb",
				"(A health orb, adds 5 hit points when used. Regenerates every 10 seconds. Dropping it would be a bad idea.)",
				5);	
	}

	public Gear buildLongLifeOrb() {
		return new HealthOrb(
				"Long Life Orb",
				"(A health orb, adds 10 hit points when used. Regenerates every 10 seconds. Dropping it would be a bad idea.)",
				10);	
	}

	public Gear buildSpontaneousReanimationOrb() {
		return new HealthOrb("Reanimator",
				"An orb of spontaneous regeneration.", 99);	
	}
}
