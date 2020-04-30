package world.state;

import world.strategies.attack.StrategyAttackCombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendPassive;

public class StatePassiveAgressive extends StateGenericImpl {
	
	private static final long serialVersionUID = 3039773453796280139L;
	
	public StatePassiveAgressive() {

		 attack = new StrategyAttackCombatant();
		 send = new StrategySendPassive();
		 roomChange = new StrategyRoomChangeDefault();
	}
}
