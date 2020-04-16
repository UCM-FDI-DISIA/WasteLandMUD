package world.creation.builder.test;

import world.creation.builder.WorldBuilder;
import world.creation.builder.WorldBuilderImpl;

public class WorldBuilderTest {

	public static void main(String[] args) {
		
		WorldBuilder builder = new WorldBuilderImpl();
		
		builder.buildWorld();		
	}
}
