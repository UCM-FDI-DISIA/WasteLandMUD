package world.creation.builder;

import java.util.HashMap;
import java.util.Map;

import world.Direction;
import world.Gear;
import world.GearContainer;
import world.Mobile;
import world.Room;
import world.World;
import world.creation.ArmorFactory;
import world.creation.GearFactory;
import world.creation.MobileFactory1;
import world.creation.OrbFactory;
import world.creation.WeaponFactory;

public class WorldBuilderImpl2 implements WorldBuilder {
	
	World worldBeingBuilt;
	
	Map<String,Room> roomSet;

	GearFactory gearFactory;
	WeaponFactory weaponFactory;
	OrbFactory orbFactory;
	ArmorFactory armorFactory;
	
	MobileFactory1 mobileFactory;

	public WorldBuilderImpl2() {
		roomSet = new HashMap<String,Room>();
		worldBeingBuilt = World.getInstance();

		gearFactory = new GearFactory();	
		weaponFactory = new WeaponFactory();
		orbFactory = new OrbFactory();
		armorFactory = new ArmorFactory();
		
		mobileFactory = new MobileFactory1();

		// Camp
		Room zero = worldBeingBuilt.createRoom("Home Room");
	}

	@Override
	public void buildWorld() {
		
		WorldDataParser parser = new WorldDataParser(this);
		
		parser.parseFile("data/world-data.txt");

		worldBeingBuilt = World.getInstance();

		// Add gear

		// Camp Gear
		
		GearContainer captainsDesk = 
				gearFactory.buildCaptainsDesk();
		worldBeingBuilt.addGearToWorld(captainsDesk, roomSet.get("BC-CampSquareBunker"));
		
		// Weapons

		worldBeingBuilt.addGearToWorld(
				weaponFactory.buildLaserPistol(),
				roomSet.get("BC-CampSquare"));

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildLaserPistol(), captainsDesk);

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildPlasmaGun(), captainsDesk);

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildVibroBlade(), captainsDesk);
		

		// Orbs


		worldBeingBuilt
				.addGearToWorld(
						orbFactory.buildHealthOrb(), captainsDesk);
		worldBeingBuilt
				.addGearToWorld(
						orbFactory.buildLongLifeOrb(), captainsDesk);

		// Gear in the Wild

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildOldLaserRifle(), roomSet.get("CS-BrokenCargoPod"));

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildLaserCannon(), roomSet.get("CS-BrokenCargoPod"));

		worldBeingBuilt.addGearToWorld(
				armorFactory.buildFlakVest(),
				roomSet.get("CS-BrokenCargoPod"));

		worldBeingBuilt.addGearToWorld(
				armorFactory.buildRegolithSuit(), roomSet.get("CS-BrokenCargoPod"));

		worldBeingBuilt
				.addGearToWorld(
						armorFactory.buildTuxTandJeans(), roomSet.get("CS-BrokenCargoPod"));

		// Easter-Egg Gear

		Gear orbOfSpontaneousReanimation = 
				orbFactory.buildSpontaneousReanimationOrb();
		worldBeingBuilt.addGearToWorld(orbOfSpontaneousReanimation, roomSet.get("AH-BroodTunnelCave"));

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildPlasmaMcCannon(),
						roomSet.get("CS-BrokenCargoPod"));

		worldBeingBuilt
				.addGearToWorld(
						armorFactory.buildAssaultCuirass(), roomSet.get("WL-Cave"));

		worldBeingBuilt
				.addGearToWorld(
						weaponFactory.buildMallignPattern(),
						roomSet.get("AH-Queen'sLair"));

		// Add mobs.
		

		Mobile marine = mobileFactory.buildMarine(roomSet.get("BC-CampSquare"));
		worldBeingBuilt.createMobile(marine);

		Mobile rover = mobileFactory.buildRover(roomSet.get("BC-LandingPad"));
		worldBeingBuilt.createMobile(rover);

		Mobile sandCat = mobileFactory.buildSandCat(roomSet.get("BC-LandingPad"));
		worldBeingBuilt.createMobile(sandCat);
		
		Mobile giantScorpion = mobileFactory.buildGiantScorpion(roomSet.get("WL-Cave"));
		worldBeingBuilt.createMobile(giantScorpion);


		Mobile smallScorpion = mobileFactory.buildSmallScorpion(roomSet.get("WL-NearWastes"));
		worldBeingBuilt.createMobile(smallScorpion);

		Mobile mediumScorpion = mobileFactory.buildMediumScorpion(roomSet.get("WL-Canyon"));
		worldBeingBuilt.createMobile(mediumScorpion);
		

		Mobile lurker = mobileFactory.buildLurker(roomSet.get("CS-CargoPodNest"));
		worldBeingBuilt.createMobile(lurker);
		
		Mobile hiveScout = mobileFactory.buildHiveScout(roomSet.get("AH-Approach"));
		worldBeingBuilt.createMobile(hiveScout);

		Mobile hiveDrone = mobileFactory.buildHiveDrone(roomSet.get("AH-Approach"));
		worldBeingBuilt.createMobile(hiveDrone);
		
		Mobile hiveGuardian = mobileFactory.buildHiveGuardian(roomSet.get("AH-Perimeter"));
		worldBeingBuilt.createMobile(hiveGuardian);

		Mobile hiveWorker = mobileFactory.buildHiveGuardian(roomSet.get("AH-Perimeter"));
		worldBeingBuilt.createMobile(hiveWorker);

		Mobile alienQueen = mobileFactory.buildHiveGuardian(roomSet.get("AH-Queen'sLair"));
		worldBeingBuilt.createMobile(alienQueen);
	}

	@Override
	public World getWorld() {
		return worldBeingBuilt;
	}

	@Override
	public void buildRoom(String id, String name, String description) {
		Room room = new Room(name);
		room.setDescription(description);
		roomSet.put(id, room);
		//
		worldBeingBuilt.addToWorld(room);
	}

	@Override
	public void buildExit(String roomFrom, String whichWay, String roomTo) {

		Room room1 = roomSet.get(roomFrom);
		Room room2 = roomSet.get(roomTo);

		Direction dir = DirectionEncoder.convertDirection(whichWay);
		
		room1.setExitDestination(dir, room2);
	}

	@Override
	public void nestRooms(String outerRoom, String roomWithin) {
		Room room1 = roomSet.get(outerRoom);
		Room room2 = roomSet.get(roomWithin);
		room1.add(room2);		
	}
}
