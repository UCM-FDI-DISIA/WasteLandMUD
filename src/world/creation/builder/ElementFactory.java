package world.creation.builder;

import world.Armor;
import world.GearContainer;
import world.HealthOrb;
import world.Weapon;

public class ElementFactory {

	public static Weapon buildWeapon(String name, String description, int level, int damage) {

		return new Weapon(name,	description, level, damage);
	}

	public static GearContainer buildGearContainer(String name, String description, int maxSize, boolean canCarry) {

		return  new GearContainer(name,	description, maxSize, canCarry);
	}

	public static Armor buildArmor(String name, String description, int level, char typeChar) {
		return new Armor(name,	description, level, typeChar);
	}

	public static HealthOrb buildHealthOrb(String name, String description, int healthPoints) {
		return new HealthOrb(name,	description, healthPoints);	
	}
}
