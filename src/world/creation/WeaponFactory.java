package world.creation;

import world.Gear;
import world.Weapon;

public class WeaponFactory {

	public WeaponFactory() {
		// TODO Auto-generated constructor stub
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

}
