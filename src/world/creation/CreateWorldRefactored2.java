package world.creation;

import java.io.FileNotFoundException;
import java.io.IOException;

import world.Direction;
import world.Gear;
import world.GearContainer;
import world.Mobile;
import world.Room;
import world.Weapon;
import world.World;
import world.creation.builder.WorldBuilder;
import world.creation.builder.WorldBuilderImpl;

/**
 * CreateWorld will be called only if there is not a world already saved in the
 * current directory specified in World. It will create rooms and exits for
 * rooms, and make sure that the exits are directed towards another valid room.
 * It also creates the MOB's along with any gear that the world has.
 * 
 * @author Matt Turner, Ross Bottorf, Zach Boe, Jonathan Perrine
 * 
 */
public class CreateWorldRefactored2 {

	private World world = World.getInstance();
	
	GearFactory gearFactory;
	WeaponFactory weaponFactory;
	OrbFactory orbFactory;
	ArmorFactory armorFactory;
	
	MobileFactory1 mobileFactory;
	
	public CreateWorldRefactored2() {
		gearFactory = new GearFactory();	
		weaponFactory = new WeaponFactory();
		orbFactory = new OrbFactory();
		armorFactory = new ArmorFactory();
		
		mobileFactory = new MobileFactory1();
	}


	/**
	 * This is the main method for creating the world. It will call one method
	 * that will create all objects that the world has.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void createWorld() {

		// defaultWorld();
		buildRooms();
		// world.saveWorld();

	}

	/**
	 * Test method, this will not be used.
	 */
	public void defaultWorld() {
		Room zero = world.createRoom("Home Room");
		world.addToWorld(zero);

		Room central = world.createRoom("Central Chamber");
		central.setDescription("This is the Central Room.");
		world.addToWorld(central);

		Room north = world.createRoom("North Wing");
		north.setDescription("This is the North Wing");
		world.addToWorld(north);

		Room east = world.createRoom("East Wing");
		east.setDescription("This is the East Wing");
		world.addToWorld(east);

		Room south = world.createRoom("South Wing");
		south.setDescription("This is the South Wing");
		world.addToWorld(south);

		Room west = world.createRoom("West Wing");
		north.setDescription("This is the West Wing");
		world.addToWorld(west);

		central.setExitDestination(Direction.NORTH, north);
		central.setExitDestination(Direction.EAST, east);
		central.setExitDestination(Direction.SOUTH, south);
		central.setExitDestination(Direction.WEST, west);

		south.setExitDestination(Direction.NORTH, central);
		west.setExitDestination(Direction.EAST, central);
		north.setExitDestination(Direction.SOUTH, central);
		east.setExitDestination(Direction.WEST, central);

		Weapon laser = new Weapon("STING", "A laser sword from days of old.");
		world.addToWorld(laser);

		laser.setLocation(north);
		north.add(laser);

		Room environment = world.createRoom("Environment Room");
		zero.add(environment);
		environment.add(central);
		environment.add(north);
		environment.add(east);
		environment.add(south);
		environment.add(west);
		world.addToWorld(environment);

		System.out.println("Central Room");
		System.out.println(central.generateDescription());
		System.out.println("Env Room's Rooms");
		System.out.println(environment.listRooms());
		System.out.println();
	}

	/**
	 * This is the main build method for the CreateWorld class. It will be used
	 * when there isn't a already existing world. It creates all objects that
	 * the world will have, including rooms, MOB's, items, etc.
	 */
	public void buildRooms() {

		// Camp
		Room zero = world.createRoom("Home Room");

		WorldBuilder builder = new WorldBuilderImpl();
		
		builder.buildWorld();	
	}
}
