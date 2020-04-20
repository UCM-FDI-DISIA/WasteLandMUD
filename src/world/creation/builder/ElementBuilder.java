package world.creation.builder;

import world.Armor;
import world.GearContainer;
import world.HealthOrb;
import world.Weapon;

public interface ElementBuilder {
	
	public Weapon buildWeapon(String name, String description, int level, int damage);

	public Armor buildArmor(String name, String description, int level, char typeChar);

	public HealthOrb buildHealthOrb(String name, String description, int healthPoints);

	public GearContainer buildGearContainer(String name, String description, int maxSize, boolean canCarry);


}
