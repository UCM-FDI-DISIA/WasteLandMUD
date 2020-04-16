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
	
	//   Weapons	

	public Gear buildLaserPistol() {
		return new Weapon("Laser Pistol",
				"A clunky old laser pistol; reliable, but ugly.", 1, 3);		
	}

	public Gear buildNewLaserRifle() {
		return new Weapon(
				"Laser Rifle",
				"(A brand new laser rifle. It is a little heavy, but packs a punch)",
				1, 6);	
	}

	public Gear buildOldLaserRifle() {
		return new Weapon(
				"Laser Rifle",
				"(A bruised and beaten laser rifle which ahs seen it's share of combat.)",
				1, 6);	
	}

	public Gear buildPlasmaGun() {
		return new Weapon(
				"Plasma Gun",
				"(A brand new plasma gun. It is unwieldy, but also packs a whallop.)",
				2, 9);	
	}

	public Gear buildLaserCannon() {
		return new Weapon(
				"Laser Cannon",
				"(A brand new laser cannon with just a little dust on the lens.)",
				3, 12);	
	}

	public Gear buildPlasmaMcCannon() {
		return new Weapon(
				"Plasma McCannon",
				"(An inductive weapon which directly proves your enemies to be a pile of ash, beyond "
						+ "contradiction.)", 5, 25);	
	}

	public Gear buildVibroBlade() {
		return new Weapon(
				"Vibro-Blade",
				"(A sword whose edge hums with slicing power, yearning for a Dreadnaught's gauntlets.)",
				3, 15);	
	}

	public Gear buildMallignPattern() {
		return new Weapon(
				"Malign Pattern",
				"(While initially appearing to be a sheet of paper with glittering silicon traces, "
						+ "A Dreadnaught with enough strength could bend this simple paper into an epic "
						+ "Origami Vibro-Blade.)", 5, 35);	
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
