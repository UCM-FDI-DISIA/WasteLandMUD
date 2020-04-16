package world.creation;

import world.Agressive;
import world.Greets;
import world.Mobile;
import world.Mutters;
import world.PassiveAgressive;
import world.Room;
import world.Trait;
import world.World;

public class MobileFactory0 {

	private World world = World.getInstance();

	public MobileFactory0() {
		// TODO Auto-generated constructor stub
	}

	
	public Mobile buildMarine(Room location) {

		return world.createMobile("Off-Duty Marine", "An off duty marine.",
				location, new Greets());
	}

	public Mobile buildRover(Room location) {
		Mobile rover = world.createMobile("Rover", "A mechanical dog.",
				location, new Mutters("Rover Woofs!"));
		((Mutters) world.getMobile("Rover").getStrategy()).setMobile(rover);

		return rover;
	}
	
	public Mobile buildSandCat(Room location) {
		Mobile sandCat = world
				.createMobile(
						"Sand Cat",
						"Not exactly a feline, but this sleek, "
								+ "hard to catch creature is similar to a housecat in shape. "
								+ "Also, it has huge digging claws. Weird.",
								location,
								new Mutters(
										"Sand Cat burrows into the ground, leaving a raised trail in the earth."));
		((Mutters) world.getMobile("Sand_Cat").getStrategy())
		.setMobile(sandCat);
		world.getMobile("Sand_Cat").setStat(10, Trait.AGILITY);
		world.getMobile("Sand_Cat").setStat(2, Trait.STRENGTH);

		return sandCat;
	}

	public Mobile buildGiantScorpion(Room location) {
		Mobile giantScorpion = world
				.createMobile(
						"Giant Scorpion",
						"A giant scorpion the likes of which the world has never seen.",
						location, new PassiveAgressive());
		((Mobile) world.getMobile("Giant_Scorpion"))
				.setStat(40, Trait.STRENGTH);
		((Mobile) world.getMobile("Giant_Scorpion")).setStat(3, Trait.AGILITY);

		return giantScorpion;
	}

	public Mobile buildSmallScorpion(Room location) {
		Mobile smallScorpion = world
				.createMobile(
						"Small Scorpion",
						"A small scorpion the likes of which you've likely seen before.",
						location, new PassiveAgressive());
		((Mobile) world.getMobile("Small_Scorpion")).setStat(2, Trait.STRENGTH);
		((Mobile) world.getMobile("Small_Scorpion")).setStat(7, Trait.AGILITY);
		((Mobile) world.getMobile("Small_Scorpion")).setStat(15,
				Trait.MAXHITPOINTS);

		return smallScorpion;
	}

	public Mobile buildMediumScorpion(Room location) {
		Mobile mediumScorpion = world
				.createMobile(
						"Medium Scorpion",
						"A medium scorpion the likes of which you've likely seen before.",
						location, new PassiveAgressive());
		((Mobile) world.getMobile("Medium_Scorpion"))
				.setStat(3, Trait.STRENGTH);
		((Mobile) world.getMobile("Medium_Scorpion")).setStat(8, Trait.AGILITY);
		((Mobile) world.getMobile("Medium_Scorpion")).setStat(16,
				Trait.MAXHITPOINTS);

		return mediumScorpion;
	}

	public Mobile buildLurker(Room location) {
		Mobile lurker = world.createMobile("Lurker",
				"A monstrous spider-like creature, whose fangs drip acid.",
				location, new Agressive());
		((Mobile) world.getMobile("Lurker")).setStat(6, Trait.STRENGTH);
		((Mobile) world.getMobile("Lurker")).setStat(6, Trait.AGILITY);
		((Mobile) world.getMobile("Lurker")).setStat(25, Trait.MAXHITPOINTS);

		return lurker;
	}

	public Mobile buildHiveScout(Room location) {
		Mobile hiveScout = world
				.createMobile(
						"Hive Scout",
						"A strange creature, like an eight-legged dog with "
								+ "dozens of solid red eyes, and chitinous body-segmets "
								+ "that turn into a whiplike tail.",
								location, new PassiveAgressive());
		((Mobile) world.getMobile("Hive_Scout")).setStat(4, Trait.STRENGTH);
		((Mobile) world.getMobile("Hive_Scout")).setStat(25, Trait.MAXHITPOINTS);
		((Mobile) world.getMobile("Hive_Scout")).setStat(8, Trait.AGILITY);
		((Mobile) world.getMobile("Hive_Scout")).setStat(3, Trait.TOUGHNESS);

		return hiveScout;
	}


	public Mobile buildHiveDrone(Room location) {
		Mobile hiveDrone = world
				.createMobile(
						"Hive Scout",
						"A strange creature, like an eight-legged dog with "
								+ "dozens of solid red eyes, and chitinous body-segmets "
								+ "that turn into a whiplike tail.",
								location, new PassiveAgressive());
		((Mobile) world.getMobile("Hive_Scout")).setStat(4, Trait.STRENGTH);
		((Mobile) world.getMobile("Hive_Scout")).setStat(25, Trait.MAXHITPOINTS);
		((Mobile) world.getMobile("Hive_Scout")).setStat(8, Trait.AGILITY);
		((Mobile) world.getMobile("Hive_Scout")).setStat(3, Trait.TOUGHNESS);

		return hiveDrone;
	}

	public Mobile buildHiveGuardian(Room location) {
		Mobile hiveGuardian = world
				.createMobile(
						"Hive Guardian",
						"A strange armored beast, like a six-legged rhino with long talons and angry teeth.",
						location, new Agressive());
		((Mobile) world.getMobile("Hive_Guardian")).setStat(9, Trait.STRENGTH);
		((Mobile) world.getMobile("Hive_Guardian")).setStat(6, Trait.AGILITY);
		((Mobile) world.getMobile("Hive_Guardian")).setStat(7, Trait.TOUGHNESS);
		((Mobile) world.getMobile("Hive_Guardian"))
				.setStat(40, Trait.MAXHITPOINTS);

		return hiveGuardian;
	}

	public Mobile buildHiveWorker(Room location) {
		Mobile hiveWorker = world
				.createMobile(
						"Hive Worker",
						"A strange insectile creature with the body of a gorilla and thick armored plates moves about ",
						location,
						new Mutters(
								"A Hive Worker uses it's mandibles to gnaw a thick chunk "
										+ "of organic material out of the wall, and take it "
										+ "deeper into the hive before returning."));
		((Mobile) world.getMobile("Hive_Worker")).setStat(9, Trait.STRENGTH);
		((Mobile) world.getMobile("Hive_Worker")).setStat(2, Trait.AGILITY);
		((Mobile) world.getMobile("Hive_Worker")).setStat(40, Trait.MAXHITPOINTS);
		((Mutters) world.getMobile("Hive_Worker").getStrategy())
				.setMobile(world.getMobile("Hive_Worker"));

		return hiveWorker;
	}

	public Mobile buildAllienQueen(Room location) {
		Mobile alienQueen = world
				.createMobile(
						"Alien Queen",
						"This enormous creature has a bulbous body and thousands of legs, and a vaguely face-like "
								+ "construct filled with fangs and glittering ruby eyes. and often leaves dripping eggs in "
								+ "it's wake as it meanders through it's deep chamber.",
								location, new Agressive());
		((Mobile) world.getMobile("Hive_Guardian")).setStat(16, Trait.STRENGTH);
		((Mobile) world.getMobile("Hive_Guardian")).setStat(6, Trait.AGILITY);
		((Mobile) world.getMobile("Hive_Guardian")).setStat(8, Trait.TOUGHNESS);
		((Mobile) world.getMobile("Hive_Guardian")).setStat(200,
				Trait.MAXHITPOINTS);

		return alienQueen;
	}


	


}
