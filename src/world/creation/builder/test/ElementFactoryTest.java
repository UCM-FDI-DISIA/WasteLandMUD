package world.creation.builder.test;

import world.Weapon;
import world.creation.builder.ElementFactory;

public class ElementFactoryTest {

	public static void main(String[] args) {
		
		String name = "Laser Pistol";
		String description = "A clunky old laser pistol; reliable, but ugly.";
		int level = 1;
		int damage = 3;
		
		Weapon weapon1 = ElementFactory.buildWeapon(name, description, level, damage);
		
		System.out.println(weapon1.getName());
		System.out.println(weapon1.getDescription());
		System.out.println(weapon1.getItemLevel());
		System.out.println(weapon1.getDamage());
	}
}
