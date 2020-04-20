package world.creation.builder;

import world.Agressive;
import world.Greets;
import world.Mobile;
import world.Mutters;
import world.PassiveAgressive;
import world.Room;
import world.Strategy;

public class MobileFactory {
	
	
	/**
	 * createMobile is called when the MUD world is created. It will take in a
	 * string for a name, string as a description, a starting room and a
	 * strategy for that specific MOB. If the MOB already exists it return null.
	 * If it doesn't exist it will create a new MOB, add it to the current
	 * world, set the strategy, and set the location.
	 * 
	 * @param name
	 *            The name for the MOB
	 * @param description
	 *            The description for the MOB
	 * @param strategy
	 *            The strategy for the specific MOB
	 * 
	 * @return The created MOB, or null if duplicate
	 */
	public static Mobile createMobile(String name, String description, 
			String whichStrategy, String message4strategy) {
		
		Mobile temp = new Mobile(name);
		
		Strategy specificStrategy = buildStrategy(whichStrategy, message4strategy, temp);		

		temp.setStrategy(specificStrategy);
		temp.setDescription(description);
		
		return temp;
	}

	public static Strategy buildStrategy(String whichStrategy, String message4strategy, Mobile temp) {
		
		Strategy specificStrategy = null;
		
		switch(whichStrategy) {
			case "G": 
				specificStrategy = new Greets();
				break;

			case "PA": 
				specificStrategy = new PassiveAgressive();
				break;

			case "A": 
				specificStrategy = new Agressive();
				break;

			case "M": 
				Mutters m = new Mutters(message4strategy);
				m.setMobile(temp);
				specificStrategy = m;				
				break;		
		}
		
		return specificStrategy;		
	}
}
