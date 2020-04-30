package world.creation.factorymethod;

import world.Mobile;
import world.state.State4Mobile;
import world.state.StateAgressive;
import world.state.StateGreets;
import world.state.StateMutters;
import world.state.StatePassiveAgressive;

public class StateEncoder {

	public static State4Mobile buildState(String whichStrategy, String message4strategy, Mobile temp) {
		
		State4Mobile specificStrategy = null;
		
		switch(whichStrategy) {
			case "G": 
				specificStrategy = new StateGreets();
				break;

			case "PA": 
				specificStrategy = new StatePassiveAgressive();
				break;

			case "A": 
				specificStrategy = new StateAgressive();
				break;

			case "M": 
				StateMutters m = new StateMutters(message4strategy);
				m.setMobile(temp);
				specificStrategy = m;				
				break;		
		}
		
		return specificStrategy;		
	}
}
