package world.creation;

import world.Mobile;
import world.Room;
import world.Trait;

public class MobileFactory1 {

	public MobileFactory1() {
		// TODO Auto-generated constructor stub
	}
	
	public Mobile buildMarine(Room location) {
		
		return MobileFactory.createMobile("Off-Duty Marine", "An off duty marine.", location, "G", "");
	}

	public Mobile buildRover(Room location) {
		
		return MobileFactory.createMobile("Rover", "A mechanical dog.", location, "M", "Rover Woofs!");
	}
	
	public Mobile buildSandCat(Room location) {
		
		Mobile sandCat = 
				MobileFactory.createMobile(
						"Sand Cat", 
						"Not exactly a feline, but this sleek, "
								+ "hard to catch creature is similar to a housecat in shape. "
								+ "Also, it has huge digging claws. Weird.",
								location,
						"M",
						"Sand Cat burrows into the ground, leaving a raised trail in the earth.");
		
		sandCat.setStat(10, Trait.AGILITY);
		sandCat.setStat(2, Trait.STRENGTH);

		return sandCat;
	}

	public Mobile buildGiantScorpion(Room location) {
		Mobile giantScorpion = 
				MobileFactory.createMobile(
						"Giant Scorpion",
						"A giant scorpion the likes of which the world has never seen.",
						location, 
						"PA",
						"");

		giantScorpion.setStat(40, Trait.STRENGTH);
		giantScorpion.setStat(3, Trait.AGILITY);

		return giantScorpion;
	}

	public Mobile buildSmallScorpion(Room location) {
		Mobile smallScorpion =
				MobileFactory.createMobile(
						"Small Scorpion",
						"A small scorpion the likes of which you've likely seen before.",
						location, 
						"PA",
						"");
		
		smallScorpion.setStat(2, Trait.STRENGTH);
		smallScorpion.setStat(7, Trait.AGILITY);
		smallScorpion.setStat(15,Trait.MAXHITPOINTS);

		return smallScorpion;
	}

	public Mobile buildMediumScorpion(Room location) {
		Mobile mediumScorpion =
				MobileFactory.createMobile(
						"Medium Scorpion",
						"A medium scorpion the likes of which you've likely seen before.",
						location, 
						"PA",
						"");

		mediumScorpion.setStat(3, Trait.STRENGTH);
		mediumScorpion.setStat(8, Trait.AGILITY);
		mediumScorpion.setStat(16,
				Trait.MAXHITPOINTS);

		return mediumScorpion;
	}

	public Mobile buildLurker(Room location) {
		Mobile lurker = 
				MobileFactory.createMobile(
						"Lurker",
						"A monstrous spider-like creature, whose fangs drip acid.",
						location, 
						"A",
						"");
		lurker.setStat(6, Trait.STRENGTH);
		lurker.setStat(6, Trait.AGILITY);
		lurker.setStat(25, Trait.MAXHITPOINTS);

		return lurker;
	}

	public Mobile buildHiveScout(Room location) {
		Mobile hiveScout = 
				MobileFactory.createMobile(
						"Hive Scout",
						"A strange creature, like an eight-legged dog with "
								+ "dozens of solid red eyes, and chitinous body-segmets "
								+ "that turn into a whiplike tail.",
						location, 
						"PA",
						"");
		
		hiveScout.setStat(4, Trait.STRENGTH);
		hiveScout.setStat(25, Trait.MAXHITPOINTS);
		hiveScout.setStat(8, Trait.AGILITY);
		hiveScout.setStat(3, Trait.TOUGHNESS);

		return hiveScout;
	}


	public Mobile buildHiveDrone(Room location) {
		Mobile hiveDrone = 
				MobileFactory.createMobile(
						"Hive Scout",
						"A strange creature, like an eight-legged dog with "
								+ "dozens of solid red eyes, and chitinous body-segmets "
								+ "that turn into a whiplike tail.",
						location, 
						"PA",
						"");
		
		hiveDrone.setStat(4, Trait.STRENGTH);
		hiveDrone.setStat(25, Trait.MAXHITPOINTS);
		hiveDrone.setStat(8, Trait.AGILITY);
		hiveDrone.setStat(3, Trait.TOUGHNESS);

		return hiveDrone;
	}

	public Mobile buildHiveGuardian(Room location) {
		Mobile hiveGuardian = 
				MobileFactory.createMobile(
						"Hive Guardian",
						"A strange armored beast, like a six-legged rhino with long talons and angry teeth.",
						location, 
						"A",
						"");
		
		hiveGuardian.setStat(9, Trait.STRENGTH);
		hiveGuardian.setStat(6, Trait.AGILITY);
		hiveGuardian.setStat(7, Trait.TOUGHNESS);
		hiveGuardian.setStat(40, Trait.MAXHITPOINTS);

		return hiveGuardian;
	}

	public Mobile buildHiveWorker(Room location) {
		Mobile hiveWorker = 
				MobileFactory.createMobile(
						"Hive Worker",
						"A strange insectile creature with the body of a gorilla and thick armored plates moves about ",
						location,
						"M",
						"A Hive Worker uses it's mandibles to gnaw a thick chunk "
										+ "of organic material out of the wall, and take it "
										+ "deeper into the hive before returning.");
		
		hiveWorker.setStat(9, Trait.STRENGTH);
		hiveWorker.setStat(2, Trait.AGILITY);
		hiveWorker.setStat(40, Trait.MAXHITPOINTS);

		return hiveWorker;
	}

	public Mobile buildAllienQueen(Room location) {
		Mobile alienQueen = 
				MobileFactory.createMobile(
						"Alien Queen",
						"This enormous creature has a bulbous body and thousands of legs, and a vaguely face-like "
								+ "construct filled with fangs and glittering ruby eyes. and often leaves dripping eggs in "
								+ "it's wake as it meanders through it's deep chamber.",
						location, 
						"A",
						"");
		
		alienQueen.setStat(16, Trait.STRENGTH);
		alienQueen.setStat(6, Trait.AGILITY);
		alienQueen.setStat(8, Trait.TOUGHNESS);
		alienQueen.setStat(200, Trait.MAXHITPOINTS);

		return alienQueen;
	}
}
