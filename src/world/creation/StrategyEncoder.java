package world.creation;

import world.Agressive;
import world.Greets;
import world.Mobile;
import world.Mutters;
import world.PassiveAgressive;
import world.Strategy;

public class StrategyEncoder {

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
